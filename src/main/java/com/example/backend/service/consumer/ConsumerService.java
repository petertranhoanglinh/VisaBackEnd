package com.example.backend.service.consumer;

import java.util.List;

import com.example.backend.dto.consumer.ConsumerDto;
import com.example.backend.model.ConsumerModel;

public interface ConsumerService {
    public int callConsumerSP(ConsumerDto dto);
    public int callConsumerDelSP(long id, String workUser);
    public List<ConsumerModel> getAll(String mobile, String workUser , int page);
	List<ConsumerModel> getAllTest();

}
