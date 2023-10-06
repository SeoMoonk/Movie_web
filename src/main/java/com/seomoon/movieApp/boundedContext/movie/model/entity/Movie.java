package com.seomoon.movieApp.boundedContext.movie.model.entity;


import com.seomoon.movieApp.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
public class Movie extends BaseEntity {

    private String title;

    private String summary;

    @Enumerated(EnumType.STRING)
    private MovieGrade grade;

}
