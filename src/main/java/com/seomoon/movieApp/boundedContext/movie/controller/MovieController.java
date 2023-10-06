package com.seomoon.movieApp.boundedContext.movie.controller;

import com.seomoon.movieApp.boundedContext.movie.model.MovieAddForm;
import com.seomoon.movieApp.boundedContext.movie.model.entity.Movie;
import com.seomoon.movieApp.boundedContext.movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/add")
    public String getAddMovieForm(MovieAddForm movieAddForm) {

        return "view/movie/movieAddForm";
    }

    @PostMapping("/add")
    public String addMovie(@Valid MovieAddForm movieAddForm,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "view/movie/movieAddForm";
        }

        movieService.addMovie(movieAddForm);

        return "redirect:/movie/list";
    }

    @GetMapping("/detail")
    public String getDetail(@RequestParam(value="id") Long movieId, Model model) {

        Movie movie = movieService.getMovieById(movieId);

        model.addAttribute("movie", movie);

        return "/view/movie/movieDetail";
    }

}
