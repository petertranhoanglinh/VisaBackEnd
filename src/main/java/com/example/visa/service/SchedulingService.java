package com.example.visa.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingService {
	//lên lịch làm việc
	@Async
	@Scheduled(fixedDelay = 1000*60*60)
	public void scheduleFixedDelayTask() {
	    System.out.println("Lịch làm việc đang chạy");
	}
}
