package com.seomoon.movieApp.boundedContext.movie.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovieGrade {

    AVAILABLE_ALL("전체관람가"),
    AVAILABLE_12("12세이상관람가"),
    AVAILABLE_15("15세이상관람가"),
    AVAILABLE_ADULT("청소년관람불가");

    private String grade;
}
