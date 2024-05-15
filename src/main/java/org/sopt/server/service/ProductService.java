package org.sopt.server.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopt.server.domain.Like;
import org.sopt.server.domain.Product;
import org.sopt.server.domain.ProductDetail;
import org.sopt.server.domain.Review;
import org.sopt.server.repository.LikeRepository;
import org.sopt.server.repository.ProductDetailRepository;
import org.sopt.server.repository.ProductRepository;
import org.sopt.server.repository.ReviewRepository;
import org.sopt.server.service.dto.ProductDetailDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final LikeRepository likeRepository;
    private final ProductDetailRepository productDetailRepository;
    private final ReviewRepository reviewRepository;

    public ProductDetailDto getProductDetailInfo(final Long memberId, final Long productId) {

        Product product = productRepository.findByIdOrThrow(productId);

        /* product detail info: thumbnail, detail image, is receive available */
        ProductDetail productDetail = productDetailRepository.findByProductIdOrThrow(productId);

        /* isLiked */
        Optional<Like> like = likeRepository.findByMemberIdAndProductId(memberId, productId);
        boolean isLiked = like.isPresent();

        /* review count */
        List<Review> reviews = reviewRepository.findAllByProductId(productId);
        int reviewCount = reviews.size();

        /* star rating */
        List<Float> stars = reviews.stream().map(Review::getStar).toList();

        /*
        * 메모리와 API 명세를 고려하여 Float 자료형으로 하였으나, 스트림 API로 별점을 계산하기 위해 타입 변환이 필요하였습니다.
        * 리뷰가 엄청 많지 않아 당장 문제는 없지만, 아래와 같은 방법으로 수정할 수 있습니다.
        * 1. stream 대신 전통적인 for문 사용
        * 2. 메모리 사용량이 조금 커지더라도 별점을 Double로 정의
        * 의견 주시면 반영하도록 하겠습니다!
        *  */
        float starRating;
        if (stars.isEmpty()) {
            starRating = 0.0f;
        } else {
            starRating = (float) stars.stream().mapToDouble(Float::doubleValue).sum() / stars.size();
        }

        return ProductDetailDto.of(product, productDetail, isLiked, starRating, reviewCount);
    }
}
