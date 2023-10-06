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

        Member boardUser = ObyUsername.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(username.contains("admin")) {
            authorities.add(new SimpleGrantedAuthority(MemberGrade.ADMIN_USER.getGrade()));
        } else {
            authorities.add(new SimpleGrantedAuthority(MemberGrade.NORMAL_USER.getGrade()));
        }

        return new User(boardUser.getUsername(), boardUser.getPassword(), authorities);
    }


}
