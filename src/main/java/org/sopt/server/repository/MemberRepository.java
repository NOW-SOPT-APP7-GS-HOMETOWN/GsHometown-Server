package org.sopt.server.repository;

import java.util.Optional;
import org.sopt.server.domain.Member;
import org.sopt.server.exception.CommonException;
import org.sopt.server.exception.dto.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member findByIdOrThrow(final Long memberId) {
        return findById(memberId)
                .orElseThrow(() -> new CommonException(ErrorCode.MEMBER_NOT_FOUND));
    }

    Optional<Member> findById(final Long memberId);
}
