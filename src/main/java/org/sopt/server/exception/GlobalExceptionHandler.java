package org.sopt.server.exception;

import lombok.extern.slf4j.Slf4j;
import org.sopt.server.common.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, MethodArgumentTypeMismatchException.class})
    public ResponseDto<?> handleIllegalArgumentException(final Exception e) {
        log.error(e.getMessage());
        return ResponseDto.fail(e);
    }

    @ExceptionHandler(value = {CommonException.class})
    public ResponseDto<?> handleCommonException(final CommonException e) {
        log.error(e.getMessage());
        return ResponseDto.fail(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }
}
