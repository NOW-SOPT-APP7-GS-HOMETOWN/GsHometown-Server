package org.sopt.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_details")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "thumbnail", nullable = false)
    private String thumbnail;

    @Column(name = "detail_image", nullable = false)
    private String detailImage;

    @Column(name = "is_receive_available", nullable = false)
    private boolean isReceiveAvailable;

    /* OneToOne에서는 관계의 소유자만 mappedBy 사용 */
    /* mappedBy 옵션 제거 -> Product에서 ProductDetail 조인하지 못하는 문제 해결 */
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "product_id")
    private Product product;
}
