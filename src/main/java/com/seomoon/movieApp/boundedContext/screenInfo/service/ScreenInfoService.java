package com.seomoon.movieApp.boundedContext.screenInfo.service;

import com.seomoon.movieApp.boundedContext.screenInfo.repository.ScreenInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScreenInfoService {

    private final ScreenInfoRepository screenInfoRepository;

}
