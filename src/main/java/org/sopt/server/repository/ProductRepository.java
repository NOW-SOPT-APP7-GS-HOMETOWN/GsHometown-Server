package org.sopt.server.repository;

import java.util.List;
import java.util.Optional;
import org.sopt.server.domain.Product;
import org.sopt.server.domain.type.Category;
import org.sopt.server.exception.CommonException;
import org.sopt.server.exception.dto.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findAllByCategory(final Category category);

    default Product findByIdOrThrow(final Long productId) {
        return findById(productId).orElseThrow(() -> new CommonException(ErrorCode.PRODUCT_NOT_FOUND));
    }

    Optional<Product> findById(final Long productId);
}
