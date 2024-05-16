package org.sopt.server.repository;

import java.util.Optional;
import org.sopt.server.domain.ProductDetail;
import org.sopt.server.exception.CommonException;
import org.sopt.server.exception.dto.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    default ProductDetail findByProductIdOrThrow(final Long productId) {
        return findByProductId(productId).orElseThrow(() -> new CommonException(ErrorCode.PRODUCT_DETAIL_NOT_FOUND));
    }
    Optional<ProductDetail> findByProductId(final Long productId);
}
