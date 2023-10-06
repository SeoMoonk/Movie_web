package com.seomoon.movieApp.boundedContext.movie.controller;

import com.seomoon.movieApp.boundedContext.movie.entity.Movie;
import com.seomoon.movieApp.boundedContext.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/list")
    public String getMovieList(Model model) {

        List<Movie> allMovieList = movieService.getAllMovieList();

        model.addAttribute("movieList", allMovieList);

        return "view/movie/movieList";
    }

}
