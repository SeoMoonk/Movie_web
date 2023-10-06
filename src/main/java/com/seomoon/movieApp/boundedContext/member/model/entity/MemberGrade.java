package com.seomoon.movieApp.boundedContext.member.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberGrade {

    NORMAL_USER("일반 관람객"),
    CRITIC_USER("전문 평론가"),
    ADMIN_USER("극장 관리자");

    private String grade;
}
