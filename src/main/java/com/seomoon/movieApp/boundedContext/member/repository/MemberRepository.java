package com.seomoon.movieApp.boundedContext.member.repository;

import com.seomoon.movieApp.boundedContext.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
