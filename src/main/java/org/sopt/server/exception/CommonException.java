package org.sopt.server.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.server.exception.dto.ErrorCode;

@Getter
@RequiredArgsConstructor
public class CommonException extends RuntimeException {
    private final ErrorCode errorCode;
}
