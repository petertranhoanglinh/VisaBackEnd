package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.backend.controller.api.CoinApiController;

@Configuration
@EnableScheduling
public class SchedulingService {
	//lên lịch làm việc
	
	@Autowired CoinApiController coin;
	@Async
	@Scheduled(fixedDelay = 1000*60*60)
	public void scheduleFixedDelayTask() throws Exception {
		this.coin.joinListCoin(1,100, null, "market_cap_desc", null);
	    System.out.println("Lịch làm việc đang chạy");
	}
}
