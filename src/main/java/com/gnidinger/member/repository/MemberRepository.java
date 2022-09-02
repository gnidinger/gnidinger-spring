package com.gnidinger.member.repository;

import com.gnidinger.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> { // Crud -> Jpa
    Optional<Member> findByEmail(String email);
}