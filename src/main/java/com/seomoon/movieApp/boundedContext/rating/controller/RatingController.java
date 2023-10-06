package com.seomoon.movieApp.boundedContext.rating.controller;

import com.seomoon.movieApp.boundedContext.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

}
