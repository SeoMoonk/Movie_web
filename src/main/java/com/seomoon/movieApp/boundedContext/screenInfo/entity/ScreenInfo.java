package com.seomoon.movieApp.boundedContext.screenInfo.entity;

import com.seomoon.movieApp.base.entity.BaseEntity;
import com.seomoon.movieApp.boundedContext.cinema.entity.Cinema;
import com.seomoon.movieApp.boundedContext.movie.model.entity.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
public class ScreenInfo extends BaseEntity {

    @ManyToOne
    private Movie linkedMovie;

    @ManyToOne
    private Cinema linkedCinema;

    private LocalDateTime showTime;

}
