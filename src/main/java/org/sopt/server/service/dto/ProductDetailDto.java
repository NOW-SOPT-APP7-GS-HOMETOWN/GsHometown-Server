package org.sopt.server.service.dto;

import lombok.Builder;
import lombok.NonNull;
import org.sopt.server.domain.Product;
import org.sopt.server.domain.ProductDetail;

@Builder
public record ProductDetailDto(
        String thumbnail,
        String title,
        Boolean isLiked,
        Integer price,
        Boolean isReceiveAvailable,
        Float starRating,
        Integer reviewCount,
        String detailImage
) {

    public static ProductDetailDto of(final Product product, final ProductDetail productDetail, final Boolean isLiked, final Float starRating, final Integer reviewCount) {
        return ProductDetailDto.builder()
                .thumbnail(productDetail.getThumbnail())
                .title(product.getTitle())
                .isLiked(isLiked)
                .price(product.getPrice())
                .isReceiveAvailable(productDetail.isReceiveAvailable())
                .starRating(starRating)
                .reviewCount(reviewCount)
                .detailImage(productDetail.getDetailImage())
                .build();
    }
}
