package com.seomoon.movieApp.boundedContext.cinema.controller;

import com.seomoon.movieApp.boundedContext.cinema.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

}
