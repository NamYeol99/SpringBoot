package org.zerock.mrerview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.mrerview.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
