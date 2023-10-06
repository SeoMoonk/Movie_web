package com.seomoon.movieApp.boundedContext.rating.repository;

import com.seomoon.movieApp.boundedContext.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
