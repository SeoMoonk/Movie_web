package com.seomoon.movieApp.boundedContext.member.entity;

import com.seomoon.movieApp.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
public class Member extends BaseEntity {

    private String loginId;     //아이디

    private String password;    //비밀번호

    private String nickname;    //닉네임

    private MemberGrade grade;  //등급

}
