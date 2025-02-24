package com.seowoninfo.azuredev.sample;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByMemberId(String memberId);
	
}
