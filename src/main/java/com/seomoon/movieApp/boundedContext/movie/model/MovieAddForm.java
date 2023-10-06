package com.seomoon.movieApp.boundedContext.movie.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieAddForm {

    @NotEmpty(message="영화 제목은 필수 입력 사항입니다.")
    private String title;

    @NotEmpty(message="영화 줄거리는 필수 입력 사항입니다.")
    private String summary;

    @NotEmpty(message="영화 등급은 필수 기재 사항입니다.")
    private String grade;

}
