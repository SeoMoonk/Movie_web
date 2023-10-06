package com.seomoon.movieApp.boundedContext.screenInfo.repository;

import com.seomoon.movieApp.boundedContext.screenInfo.entity.ScreenInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenInfoRepository extends JpaRepository<ScreenInfo, Long> {
}
