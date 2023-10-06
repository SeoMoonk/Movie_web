package com.seomoon.movieApp.boundedContext.movie.repository;

import com.seomoon.movieApp.boundedContext.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
