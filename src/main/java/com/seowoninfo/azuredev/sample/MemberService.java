package com.seowoninfo.azuredev.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FileName    : IntelliJ IDEA
 * Author      : Seowon
 * Date        : 2025-01-21
 * Description :
 */
@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원정보상세
     */
    public MemberResponseDto getMember(Long memberSeq) {
        Member member = memberRepository.findById(memberSeq).get();
        return MemberResponseDto.toDto(member);
    }

}
