package org.sopt.server.dto.response;

import lombok.Builder;
import org.sopt.server.domain.Banner;

import java.util.List;

@Builder
public record AdvanceReservationScreenDto(
    List<String> topBanners,
    List<ProductDto> products
) {
    public static AdvanceReservationScreenDto of(List<String> topBanners, List<ProductDto> products){
        return new AdvanceReservationScreenDto(topBanners, products);
    }
}
