package org.sopt.server.repository;

import java.util.Optional;
import org.sopt.server.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByMemberIdAndProductId(final Long memberId, final Long productId);
}
