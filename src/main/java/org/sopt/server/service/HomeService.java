package org.sopt.server.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.dto.response.HomeResponseDto;
import org.sopt.server.dto.response.MonthlyEventsResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    public HomeResponseDto getHome() {
        List<String> topBanners = Arrays.asList("top-image-url1", "top-image-url2", "top-image-url3");
        List<String> mainBanners = Arrays.asList("main-image-url1", "main-image-url2", "main-image-url3");
        List<String> subBanners = Arrays.asList("sub-image-url1", "sub-image-url2", "sub-image-url3");
        List<String> bottomBanners = Arrays.asList("bottom-image-url1", "bottom-image-url2", "bottom-image-url3");

        return new HomeResponseDto(topBanners, new MonthlyEventsResponseDto(mainBanners, subBanners), bottomBanners);
    }
}
