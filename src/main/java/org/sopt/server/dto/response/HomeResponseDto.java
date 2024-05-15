package org.sopt.server.dto.response;

import java.util.List;

public record HomeResponseDto(
    List<String> topBanners,
    MonthlyEventsResponseDto  monthlyEvents,
    List<String> bottomBanners
) {

}
