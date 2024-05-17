package org.sopt.server.dto.response;

import lombok.Builder;
import org.sopt.server.domain.Banner;

import java.util.List;

@Builder
public record AdvanceReservationScreenDto(
    List<String> topBanners,

    String headerTitle,

    String date,
    List<ProductDto> products
) {
    public static AdvanceReservationScreenDto of(List<String> topBanners, String headerTitle, String date, List<ProductDto> products){
        return new AdvanceReservationScreenDto(topBanners, headerTitle, date, products);
    }
}
