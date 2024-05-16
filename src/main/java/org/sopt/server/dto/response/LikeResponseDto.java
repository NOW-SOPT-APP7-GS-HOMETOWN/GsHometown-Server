package org.sopt.server.dto.response;

public record LikeResponseDto(
        boolean isLiked
) {
    public static LikeResponseDto from(final boolean isLiked) {
        return new LikeResponseDto(isLiked);
    }
}
