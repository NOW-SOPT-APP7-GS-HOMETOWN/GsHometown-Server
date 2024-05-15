package org.sopt.server.exception.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExceptionDto {
    private final String code;
    private final String message;

    public static ExceptionDto from(final ErrorCode errorCode) {
        return new ExceptionDto(errorCode.name(), errorCode.getMessage());
    }
}
