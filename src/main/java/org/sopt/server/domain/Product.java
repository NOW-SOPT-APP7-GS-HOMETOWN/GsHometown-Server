package org.sopt.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.server.domain.type.Category;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private Integer price;

    /* nullable */
    @Column(name = "original_price")
    private Integer originalPrice;

    /* nullable */
    @Column(name = "card_price")
    private Integer cardPrice;

    @Column(name = "is_gs_discount", nullable = false)
    private boolean isGsDiscount;

    /* nullable */
    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @PrimaryKeyJoinColumn(name = "product_detail_info_id")
    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
    private ProductDetail productDetail;

    @OneToMany(mappedBy = "product")
    private List<Like> likedMembers;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
