package org.sopt.server.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.server.common.dto.ResponseDto;
import org.sopt.server.service.ProductService;
import org.sopt.server.dto.response.ProductDetailDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseDto<ProductDetailDto> getProductDetailInfo(
            @RequestHeader(name = "memberId") final Long memberId,
            @PathVariable(name = "productId") final Long productId
    ) {
        return ResponseDto.success(productService.getProductDetailInfo(memberId, productId));
    }

    @GetMapping
    public ResponseDto<?> getProductsByType(@RequestParam(name = "type") final String type) {
        if (type.equals("basic")) {
            return ResponseDto.success(null);
        } else if (type.equals("event")) {
            return ResponseDto.success(null);
        } else { /* type.equals("category") */
            return ResponseDto.success(productService.getCategoryProducts());
        }
    }

}
