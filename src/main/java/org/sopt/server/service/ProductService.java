package org.sopt.server.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.sopt.server.domain.Banner;
import org.sopt.server.domain.Like;
import org.sopt.server.domain.Product;
import org.sopt.server.domain.Review;
import org.sopt.server.domain.type.Category;
import org.sopt.server.dto.response.*;
import org.sopt.server.exception.CommonException;
import org.sopt.server.exception.dto.ErrorCode;
import org.sopt.server.repository.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final LikeRepository likeRepository;
    private final BannerRepository bannerRepository;
    private final ReviewRepository reviewRepository;

    public ProductDetailDto getProductDetailInfo(final Long memberId, final Long productId) {

        Product product = productRepository.findByIdOrThrow(productId);

        /* isLiked */
        Optional<Like> like = likeRepository.findByMemberIdAndProductId(memberId, productId);
        boolean isLiked = like.isPresent();

        /* review count */
        List<Review> reviews = reviewRepository.findAllByProductId(productId);
        int reviewCount = reviews.size();
        Float starRating = getStarRating(reviews);

        return ProductDetailDto.of(product, isLiked, starRating, reviewCount);
    }

    public List<CategoryProductsDto> getCategoryProducts() {
        return Arrays.stream(Category.values()).map(category -> {
            // 카테고리 별 상품 목록 조회
            List<Product> categoryProducts = productRepository.findAllByCategory(category);
            // 카테고리 상품 dto 생성
            return CategoryProductsDto.of(category, categoryProducts.stream().map(cp -> {
                List<Review> reviews = cp.getReviews();
                return ProductDto.of(cp, getStarRating(reviews), reviews.size());
            }).toList());
        }).toList();
    }

    public AdvanceReservationScreenDto getAdvanceReservationScreen() {
        List<String> advanceTopBanners =  bannerRepository.findImageUrlsByType("advancetop").stream()
                                                                        .map(Banner::getImageUrl)
                                                                        .collect(Collectors.toList());// 사전 예약 화면에 탑 배너 이미지들
        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        // 현재 날짜와 현재 날짜로부터 이틀 뒤 날짜
        String date = LocalDate.now().format(formatter) + " ~ " + LocalDate.now().plusDays(2).format(formatter);

        List<ProductDto> gsPayProducts = productRepository.findAllByCategory(Category.GSPAY).stream()
                                                .map(product -> ProductDto.of(product, getStarRating(product.getReviews()), product.getReviews().size()))
                                                .collect(Collectors.toList());

        return AdvanceReservationScreenDto.of(advanceTopBanners,"[GS Pay 추가 할인] GS25 정육상품 4", date, gsPayProducts);
    }

    public EventProductsResponseDto getEvenetProducts() {
        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        // 현재 날짜와 현재 날짜로부터 이틀 뒤 날짜
        String date = LocalDate.now().format(formatter) + " ~ " + LocalDate.now().plusDays(2).format(formatter);

        List<ProductDto> eventProducts = productRepository.findAllByCategory(Category.EVENT).stream()
                                                 .map(product -> ProductDto.of(product, getStarRating(product.getReviews()), product.getReviews().size()))
                                                 .collect(Collectors.toList());

        return EventProductsResponseDto.of("푸냥이 푸딩젤리 2탄!복숭아맛🍑", date, eventProducts);
    }

    private Float getStarRating(final List<Review> reviews) {
        /* star rating */
        List<Float> stars = reviews.stream().map(Review::getStar).toList();

        /*
         * 메모리와 API 명세를 고려하여 Float 자료형으로 하였으나, 스트림 API로 별점을 계산하기 위해 타입 변환이 필요하였습니다.
         * 리뷰가 엄청 많지 않아 당장 문제는 없지만, 아래와 같은 방법으로 수정할 수 있습니다.
         * 1. stream 대신 전통적인 for문 사용
         * 2. 메모리 사용량이 조금 커지더라도 별점을 Double로 정의
         * -> 논의 후 for문 사용
         *  */
        float starRating = 0.0f;
        for (Float star : stars) {
            if (star % 0.5f != 0.0f) {
                throw new CommonException(ErrorCode.STAR_DECIMAL_POINT);
            }
            starRating += star;
        }
        starRating /= stars.size();
        starRating = Math.round(starRating * 10) / 10.0f; /* 한 자리 수까지 표현 */

        return starRating;
    }
}
