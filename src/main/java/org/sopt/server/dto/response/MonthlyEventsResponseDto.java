package org.sopt.server.dto.response;

import java.util.List;

public record MonthlyEventsResponseDto(

    List<String> mainBanners,
    List<String> subBanners
) {

}
