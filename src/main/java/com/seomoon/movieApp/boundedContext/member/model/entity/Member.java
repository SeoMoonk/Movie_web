package com.seomoon.movieApp.boundedContext.member.model.entity;

import com.seomoon.movieApp.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
public class Member extends BaseEntity {

    private String username;     //아이디

    private String password;    //비밀번호

    private String nickname;    //닉네임

    @Enumerated(EnumType.STRING)
    private MemberGrade grade;  //등급

}
