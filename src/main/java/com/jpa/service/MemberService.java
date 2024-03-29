package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.domain.Member;
import com.jpa.repository.MemberRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	/**
     * 회원 가입
     */
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) throws NotFoundException {
        return memberRepository.findById(memberId).orElseThrow(() -> new NotFoundException("Unable to get Member with memberId = " + memberId));
    }
}
