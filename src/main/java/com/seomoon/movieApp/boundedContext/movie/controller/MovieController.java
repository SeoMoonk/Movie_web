package com.seomoon.movieApp.boundedContext.movie.controller;

import com.seomoon.movieApp.boundedContext.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
}
