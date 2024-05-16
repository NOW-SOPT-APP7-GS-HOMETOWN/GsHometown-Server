package org.sopt.server.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.dto.response.HomeResponseDto;
import org.sopt.server.dto.response.MonthlyEventsResponseDto;
import org.sopt.server.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    @Autowired
    private BannerRepository bannerRepository;

    public HomeResponseDto getHome() {
        List<String> topBanners = bannerRepository.findImageUrlsByType("top");
        List<String> mainBanners = bannerRepository.findImageUrlsByType("main");
        List<String> subBanners = bannerRepository.findImageUrlsByType("sub");
        List<String> bottomBanners = bannerRepository.findImageUrlsByType("bottom");

        return new HomeResponseDto(topBanners, new MonthlyEventsResponseDto(mainBanners, subBanners), bottomBanners);
    }
}
