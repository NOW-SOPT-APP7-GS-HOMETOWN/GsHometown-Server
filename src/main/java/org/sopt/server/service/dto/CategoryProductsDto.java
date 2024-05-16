package org.sopt.server.service.dto;

import java.util.List;
import org.sopt.server.domain.type.Category;

public record CategoryProductsDto(
        Category category,
        List<ProductDto> products
) {
    public static CategoryProductsDto of(final Category category, final List<ProductDto> products) {
        return new CategoryProductsDto(category, products);
    }
}
