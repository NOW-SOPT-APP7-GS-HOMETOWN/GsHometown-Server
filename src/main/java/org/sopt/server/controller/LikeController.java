package org.sopt.server.controller;


import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.dto.request.LikeRequestDto;
import org.sopt.server.dto.response.LikeDto;
import org.sopt.server.dto.response.LikeResponseDto;
import org.sopt.server.service.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public ResponseDto<LikeResponseDto> postLike(
            @RequestHeader("memberId") final Long memberId,
            @RequestBody final LikeRequestDto likeRequestDto
    ) {
        return ResponseDto.success(likeService.postLike(memberId, likeRequestDto));
    }

    @DeleteMapping
    public ResponseDto<LikeResponseDto> deleteLike(
        @RequestHeader("memberId") final Long memberId,
        @RequestBody final LikeRequestDto likeRequestDto
    ) {
        return ResponseDto.success(likeService.deleteLike(memberId, likeRequestDto));
    }
}
