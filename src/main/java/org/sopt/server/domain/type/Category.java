package org.sopt.server.domain.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Category {

    BREAD("빵"),
    REFRIGERATED_CONVINIENCE("냉장간편식"),
    BASIC("기본 상품"),
    EVENT("이벤트 상품")
    ;

    private final String category;
}
