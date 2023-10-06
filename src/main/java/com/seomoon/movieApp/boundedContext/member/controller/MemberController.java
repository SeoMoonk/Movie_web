package com.seomoon.movieApp.boundedContext.member.controller;

import com.seomoon.movieApp.boundedContext.member.model.MemberJoinForm;
import com.seomoon.movieApp.boundedContext.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String getJoinForm(MemberJoinForm memberJoinForm) {

        return "view/member/joinForm";
    }

    @PostMapping("/join")
    public String joinMember(@Valid MemberJoinForm memberJoinForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "view/member/joinForm";
        }

        Map<String, String> joinResultMap = memberService.createMember(memberJoinForm);

        if (joinResultMap.get("code").startsWith("F")) {

            String failCode = joinResultMap.get("code");
            String failMsg = joinResultMap.get("msg");

            bindingResult.reject("global.error", failCode + ": " + failMsg);

            return "view/member/joinForm";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginForm(){

        return "view/member/loginForm";
    }
}
