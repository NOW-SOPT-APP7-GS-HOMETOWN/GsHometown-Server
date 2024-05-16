package org.sopt.server.dto.response;

import java.util.Date;
import java.util.List;

public record EventProductsResponseDto(
    String headerTitle,
    String date,
    List<ProductDto> products
) {
    public static EventProductsResponseDto of(String headerTitle, String date, List<ProductDto> products) {
        return new EventProductsResponseDto(headerTitle, date, products);
    }
}
