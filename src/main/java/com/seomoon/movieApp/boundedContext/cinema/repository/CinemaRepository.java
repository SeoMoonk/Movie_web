package com.seomoon.movieApp.boundedContext.cinema.repository;

import com.seomoon.movieApp.boundedContext.cinema.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
