package org.sopt.server.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import lombok.NonNull;
import org.sopt.server.exception.CommonException;
import org.sopt.server.exception.dto.ErrorCode;
import org.sopt.server.exception.dto.ExceptionDto;
import org.springframework.http.HttpStatus;

public record ResponseDto<T>(
        @JsonIgnore HttpStatus httpStatus,
        @NonNull Integer status,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Nullable T data,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Nullable ExceptionDto exception
        ) {

    public static <T> ResponseDto<T> success(@Nullable final T data) {
        return new ResponseDto<>(HttpStatus.OK, HttpStatus.OK.value(), data, null);
    }

    public static ResponseDto<?> fail(@NonNull final HttpStatus httpStatus, @NonNull final CommonException e) {
        return new ResponseDto<>(httpStatus, httpStatus.value(), null, ExceptionDto.from(e.getErrorCode()));
    }

    public static ResponseDto<?> fail(@NonNull final Exception e) {
        return new ResponseDto<>(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), null, ExceptionDto.from(
                ErrorCode.BAD_REQUEST));
    }
}
