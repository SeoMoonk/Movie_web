package com.seomoon.movieApp.boundedContext.member.service;

import com.seomoon.movieApp.boundedContext.member.model.MemberJoinForm;
import com.seomoon.movieApp.boundedContext.member.model.entity.Member;
import com.seomoon.movieApp.boundedContext.member.model.entity.MemberGrade;
import com.seomoon.movieApp.boundedContext.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Map<String, String> createMember(MemberJoinForm memberJoinForm){

        String username = memberJoinForm.getUsername();
        String password1 = memberJoinForm.getPassword1();
        String password2 = memberJoinForm.getPassword2();
        String nickname = memberJoinForm.getNickname();

        Map<String, String> checkJoinMap = checkValidJoin(username, password1, password2, nickname);

        if(checkJoinMap.get("code").startsWith("S")){

            MemberGrade userGrade = null;

            if(username.contains("admin")) {
                userGrade = MemberGrade.ADMIN_USER;
            } else if(username.contains("critic")) {
                userGrade = MemberGrade.CRITIC_USER;
            } else {
                userGrade = MemberGrade.NORMAL_USER;
            }

            Member member = Member.builder()
                    .username(username)
                    .password(passwordEncoder.encode(password1)) //TODO PasswordEncorder from security
                    .nickname(nickname)
                    .grade(userGrade)
                    .build();

            memberRepository.save(member);
        }

        return checkJoinMap;
    }

    public Map<String, String> checkValidJoin(String username, String password1, String password2, String nickname){

        Map<String, String> resultMap = new HashMap<>();

        String code = "S-1";
        String msg = "유효한 폼 입니다.";

        Optional<Member> ObyId = memberRepository.findByUsername(username);
        if(ObyId.isPresent()){
            code = "F-1";
            msg = "이미 사용중인 아이디 입니다.";
        }

        Optional<Member> ObyNickname = memberRepository.findByNickname(nickname);
        if(ObyNickname.isPresent()){

            code = "F-2";
            msg = "이미 사용중인 닉네임 입니다.";
        }

        if(!password1.equals(password2)){
            code = "F-3";
            msg = "두가지 비밀번호가 일치하지 않습니다.";
        }

        resultMap.put("code", code);
        resultMap.put("msg", msg);

        return resultMap;
    }

    public Member getMemberByUsername(String username) {

        return memberRepository.findByUsername(username).get();
    }

}
