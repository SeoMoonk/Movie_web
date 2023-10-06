package com.seomoon.movieApp.boundedContext.rating.entity;

import com.seomoon.movieApp.base.entity.BaseEntity;
import com.seomoon.movieApp.boundedContext.member.model.entity.Member;
import com.seomoon.movieApp.boundedContext.movie.entity.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
public class Rating extends BaseEntity {

    @ManyToOne
    private Member writer;

    @ManyToOne
    private Movie linkedMovie;

    private Long score;

    private String review;

}
