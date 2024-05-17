package org.sopt.server.domain.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Category {

    SIDE_DISH_NOODLES("요리반찬/조리면"),
    REFRIGERATED_CONVINIENCE("냉장간편식"),
    GSPAY("GS Pay 상품"),
    EVENT("이벤트 상품")
    ;

    private final String category;
}
