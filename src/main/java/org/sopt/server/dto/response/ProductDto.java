package org.sopt.server.dto.response;

import lombok.Builder;
import org.sopt.server.domain.Product;

@Builder
public record ProductDto(
        String image,
        String title,
        Integer price,
        Integer originalPrice,
        Integer cardPrice,
        Boolean isGsDiscount,
        Float starRating,
        Integer reviewCount
) {
        public static ProductDto of(final Product product, final Float starRating, final Integer reviewCount) {
            return ProductDto.builder()
                    .image(product.getImage())
                    .title(product.getTitle())
                    .price(product.getPrice())
                    .originalPrice(product.getOriginalPrice())
                    .cardPrice(product.getCardPrice())
                    .isGsDiscount(product.isGsDiscount())
                    .starRating(starRating)
                    .reviewCount(reviewCount)
                    .build();
        }
}
