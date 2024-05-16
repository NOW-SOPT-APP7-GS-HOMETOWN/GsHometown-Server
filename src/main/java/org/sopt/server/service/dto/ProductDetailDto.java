package org.sopt.server.service.dto;

import lombok.Builder;
import org.sopt.server.domain.Product;

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

    public static ProductDetailDto of(final Product product, final Boolean isLiked, final Float starRating, final Integer reviewCount) {
        return ProductDetailDto.builder()
                .thumbnail(product.getProductDetail().getThumbnail())
                .title(product.getTitle())
                .isLiked(isLiked)
                .price(product.getPrice())
                .isReceiveAvailable(product.getProductDetail().isReceiveAvailable())
                .starRating(starRating)
                .reviewCount(reviewCount)
                .detailImage(product.getProductDetail().getDetailImage())
                .build();
    }
}
