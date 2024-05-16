package org.sopt.server.dto.response;

import java.util.List;
import org.sopt.server.domain.type.Category;

public record CategoryProductsDto(
        String category,
        List<ProductDto> products
) {
    public static CategoryProductsDto of(final Category category, final List<ProductDto> products) {
        return new CategoryProductsDto(category.getCategory(), products);
    }
}
