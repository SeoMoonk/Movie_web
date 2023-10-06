package com.seomoon.movieApp.boundedContext.movie.controller;

import com.seomoon.movieApp.boundedContext.movie.model.MovieForm;
import com.seomoon.movieApp.boundedContext.movie.model.entity.Movie;
import com.seomoon.movieApp.boundedContext.movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('admin')")
    public String getAddMovieForm(MovieForm movieForm) {

        return "view/movie/movieAddForm";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin')")
    public String addMovie(@Valid MovieForm movieForm,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "view/movie/movieAddForm";
        }

        movieService.addMovie(movieForm);

        return "redirect:/movie/list";
    }

    @GetMapping("/detail")
    public String getDetail(@RequestParam(value="id") Long movieId, Model model) {

        Movie movie = movieService.getMovieById(movieId);

        model.addAttribute("movie", movie);

        return "/view/movie/movieDetail";
    }

    @GetMapping("/modify")
    @PreAuthorize("hasAuthority('admin')")
    public String getModifyForm(@RequestParam(value="id") Long movieId, Model model,
                                MovieForm movieForm) {

        Movie movie = movieService.getMovieById(movieId);

        model.addAttribute("movie", movie);

        return "/view/movie/movieModifyForm";
    }

    @PostMapping("/modify")
    @PreAuthorize("hasAuthority('admin')")
    public String modifyMovie(@RequestParam(value="id") Long movieId,
                              @Valid MovieForm movieForm, BindingResult bindingResult) {

        Movie targetMovie = movieService.getMovieById(movieId);

        movieService.modifyMovie(movieForm, targetMovie);

        return "redirect:/movie/detail?id=" + movieId;
    }

    @GetMapping("/remove")
    @PreAuthorize("hasAuthority('admin')")
    public String removeMovie(@RequestParam(value="id") Long movieId) {

        movieService.removeMovie(movieId);

        return "redirect:/movie/list";
    }

}
