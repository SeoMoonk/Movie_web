package com.seomoon.movieApp.boundedContext.cinema.service;

import com.seomoon.movieApp.boundedContext.cinema.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CinemaService {

    private final CinemaRepository cinemaRepository;
}
