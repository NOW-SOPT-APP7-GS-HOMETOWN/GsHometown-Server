package org.sopt.server.exception;

import lombok.extern.slf4j.Slf4j;
import org.sopt.server.common.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ResponseDto<?>> handleIllegalArgumentException(final IllegalArgumentException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(ResponseDto.fail(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {CommonException.class})
    public ResponseEntity<ResponseDto<?>> handleCommonException(final CommonException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        HttpStatus status = e.getErrorCode().getHttpStatus();
        return new ResponseEntity<>(ResponseDto.fail(status, e), status);
    }
}
