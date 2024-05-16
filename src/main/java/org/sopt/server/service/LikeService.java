package org.sopt.server.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopt.server.domain.Like;
import org.sopt.server.domain.Member;
import org.sopt.server.domain.Product;
import org.sopt.server.dto.request.LikeAddDto;
import org.sopt.server.dto.response.LikeDto;
import org.sopt.server.exception.CommonException;
import org.sopt.server.exception.dto.ErrorCode;
import org.sopt.server.repository.LikeRepository;
import org.sopt.server.repository.MemberRepository;
import org.sopt.server.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final LikeRepository likeRepository;

    public LikeDto postLike(final Long memberId, final LikeAddDto LikeAddDto) {
        Long productId = LikeAddDto.productId();
        Optional<Like> opLike = likeRepository.findByMemberIdAndProductId(memberId, productId);
        if (opLike.isPresent()) {
            throw new CommonException(ErrorCode.LIKE_ALREADY_EXISTS);
        }

        Member member = memberRepository.findByIdOrThrow(memberId);
        Product product = productRepository.findByIdOrThrow(productId);

        likeRepository.save(Like.of(member, product));

        return LikeDto.from(true);
    }
}
