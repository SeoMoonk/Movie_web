package com.seomoon.movieApp.boundedContext.member.controller;

import com.seomoon.movieApp.boundedContext.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

}
