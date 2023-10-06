package com.seomoon.movieApp.boundedContext.movie.repository;

import com.seomoon.movieApp.boundedContext.movie.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);

}
