package org.sopt.server.repository;

import org.sopt.server.domain.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {
    @Query(value = "SELECT image_url FROM \"gs \".banner WHERE type = :type", nativeQuery = true)
    List<String> findImageUrlsByType(@Param("type") String type);
}
