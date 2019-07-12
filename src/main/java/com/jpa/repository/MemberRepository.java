package com.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	
	List<Member> findByName(String name);
}
