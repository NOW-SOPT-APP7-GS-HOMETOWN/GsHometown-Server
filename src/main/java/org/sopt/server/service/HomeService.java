package org.sopt.server.service;

import lombok.RequiredArgsConstructor;
import org.sopt.server.domain.Banner;
import org.sopt.server.dto.response.HomeResponseDto;
import org.sopt.server.dto.response.MonthlyEventsResponseDto;
import org.sopt.server.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeService {

    @Autowired
    private BannerRepository bannerRepository;

    public HomeResponseDto getHome() {
        List<String> topBanners = bannerRepository.findImageUrlsByType("top").stream()
                                         .map(Banner::getImageUrl)
                                         .collect(Collectors.toList());

        List<String> mainBanners = bannerRepository.findImageUrlsByType("main").stream()
                                          .map(Banner::getImageUrl)
                                          .collect(Collectors.toList());

        List<String> subBanners = bannerRepository.findImageUrlsByType("sub").stream()
                                         .map(Banner::getImageUrl)
                                         .collect(Collectors.toList());

        List<String> bottomBanners = bannerRepository.findImageUrlsByType("bottom").stream()
                                            .map(Banner::getImageUrl)
                                            .collect(Collectors.toList());

        return new HomeResponseDto(topBanners, new MonthlyEventsResponseDto(mainBanners, subBanners), bottomBanners);
    }
}
