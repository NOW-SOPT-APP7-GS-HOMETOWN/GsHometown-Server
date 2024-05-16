package org.sopt.server.controller;


import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.dto.request.LikeAddDto;
import org.sopt.server.dto.response.LikeDto;
import org.sopt.server.service.LikeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public ResponseDto<LikeDto> postLike(
            @RequestHeader("memberId") final Long memberId,
            @RequestBody final LikeAddDto likeAddDto
    ) {
        return ResponseDto.success(likeService.postLike(memberId, likeAddDto));
    }
}
