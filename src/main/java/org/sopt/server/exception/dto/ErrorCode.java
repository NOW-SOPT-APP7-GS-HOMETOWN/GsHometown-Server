package org.sopt.server.exception.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    /* 400 - BAD REQUEST */
    BAD_REQUEST(40000, HttpStatus.BAD_REQUEST, "Bad Request"),

    /* 401 - UNAUTHORIZED */
    UNAUTHORIZED(40100, HttpStatus.UNAUTHORIZED, "Unauthorized"),

    /* 403 - FORBIDDEN */
    FORBIDDEN(40300, HttpStatus.FORBIDDEN, "Forbidden"),

    /* 404 - NOT FOUND */
    NOT_FOUND(40400, HttpStatus.NOT_FOUND, "Not Found"),
    MEMBER_NOT_FOUND(40401, HttpStatus.NOT_FOUND, "Member Not Found"),
    PRODUCT_NOT_FOUND(40402, HttpStatus.NOT_FOUND, "Product Not Found"),
    PRODUCT_DETAIL_NOT_FOUND(40403, HttpStatus.NOT_FOUND, "Product Detail Not Found"),

    /* 405 - METHOD NOT ALLOWED */
    METHOD_NOT_ALLOWED(40500, HttpStatus.METHOD_NOT_ALLOWED, "Method Not Allowed"),

    /* 409 - CONFLICT */
    CONFLICT(40900, HttpStatus.CONFLICT, "Conflict"),

    /* 500 - INTERNAL SERVER ERROR */
    INTERNAL_SERVER_ERROR(50000, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    ;

    final int status;
    final HttpStatus httpStatus;
    final String message;
}
