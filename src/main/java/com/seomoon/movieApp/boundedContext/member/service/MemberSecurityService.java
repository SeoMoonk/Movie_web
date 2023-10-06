package com.seomoon.movieApp.boundedContext.member.service;

import com.seomoon.movieApp.boundedContext.member.model.entity.Member;
import com.seomoon.movieApp.boundedContext.member.model.entity.MemberGrade;
import com.seomoon.movieApp.boundedContext.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> ObyUsername = memberRepository.findByUsername(username);

        if(ObyUsername.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        Member loginMember = ObyUsername.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(loginMember.getGrade().equals(MemberGrade.ADMIN_USER)) {
            System.out.println("어드민 로그인!");
            authorities.add(new SimpleGrantedAuthority("admin"));
        } else if(loginMember.getGrade().equals(MemberGrade.CRITIC_USER)) {
            System.out.println("크리틱 로그인!");
            authorities.add(new SimpleGrantedAuthority("critic"));
        } else {
            System.out.println("유저 로그인!");
            authorities.add(new SimpleGrantedAuthority("user"));
        }

        return new User(loginMember.getUsername(), loginMember.getPassword(), authorities);
    }


}
