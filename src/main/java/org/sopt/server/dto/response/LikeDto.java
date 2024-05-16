package org.sopt.server.dto.response;

public record LikeDto(
        boolean isLiked
) {
    public static LikeDto from(final boolean isLiked) {
        return new LikeDto(isLiked);
    }
}
