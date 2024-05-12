package org.sopt.server.exception.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    BAD_REQUEST(40000, HttpStatus.BAD_REQUEST, "Bad Request"),
    UNAUTHORIZED(40100, HttpStatus.UNAUTHORIZED, "Unauthorized"),
    FORBIDDEN(40300, HttpStatus.FORBIDDEN, "Forbidden"),
    NOT_FOUND(40400, HttpStatus.NOT_FOUND, "Not Found"),
    METHOD_NOT_ALLOWED(40500, HttpStatus.METHOD_NOT_ALLOWED, "Method Not Allowed"),
    CONFLICT(40900, HttpStatus.CONFLICT, "Conflict"),
    INTERNAL_SERVER_ERROR(50000, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    ;

    final int status;
    final HttpStatus httpStatus;
    final String message;
}
