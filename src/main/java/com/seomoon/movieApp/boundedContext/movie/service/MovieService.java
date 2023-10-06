package com.seomoon.movieApp.boundedContext.movie.service;

import com.seomoon.movieApp.boundedContext.movie.entity.Movie;
import com.seomoon.movieApp.boundedContext.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovieList() {

        return movieRepository.findAll();
    }

}
