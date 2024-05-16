package org.sopt.server.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.dto.response.HomeResponseDto;
import org.sopt.server.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping ("/api/")
    public ResponseDto<HomeResponseDto> getHome() {
        return ResponseDto.success(homeService.getHome());
    }
}

