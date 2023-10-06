package com.seomoon.movieApp.boundedContext.movie.entity;


import com.seomoon.movieApp.base.entity.BaseEntity;
import jakarta.persistence.Entity;
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

    private MovieGrade grade;

}
