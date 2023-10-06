package com.seomoon.movieApp.boundedContext.movie.service;

import com.seomoon.movieApp.boundedContext.movie.model.MovieAddForm;
import com.seomoon.movieApp.boundedContext.movie.model.entity.Movie;
import com.seomoon.movieApp.boundedContext.movie.model.entity.MovieGrade;
import com.seomoon.movieApp.boundedContext.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovieList() {

        return movieRepository.findAll();
    }

    @Transactional
    public Map<String, String> addMovie(MovieAddForm movieAddForm) {

        Map<String,String> resultMap = new HashMap<>();

        String validCode = checkValidAdd(movieAddForm);

        resultMap.put("Code", validCode);

        String msg = null;

        if(validCode.startsWith("F")){
            msg = "영화 등록에 실패하였습니다.";
        } else{
            Movie newMovie = Movie.builder()
                    .title(movieAddForm.getTitle())
                    .summary(movieAddForm.getSummary())
                    .grade(MovieGrade.valueOf(movieAddForm.getGrade()))
                    .build();

            movieRepository.save(newMovie);

            msg = "영화 등록에 성공하였습니다.";
        }

        resultMap.put("msg", msg);

        return resultMap;
    }

    public String checkValidAdd(MovieAddForm movieAddForm) {

        String validCheckCode = null;

        String title = movieAddForm.getTitle();

        if(movieRepository.findByTitle(title).isPresent()) {
            validCheckCode = "F-1";
        } else {
            validCheckCode = "S-1";
        }

        return validCheckCode;
    }

}
