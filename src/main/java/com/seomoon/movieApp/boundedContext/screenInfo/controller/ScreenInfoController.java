package com.seomoon.movieApp.boundedContext.screenInfo.controller;

import com.seomoon.movieApp.boundedContext.screenInfo.service.ScreenInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ScreenInfoController {

    private final ScreenInfoService screenInfoService;

}
