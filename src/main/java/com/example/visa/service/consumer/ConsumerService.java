package com.example.visa.service.consumer;

import java.util.List;

import com.example.visa.dto.consumer.ConsumerDto;
import com.example.visa.model.ConsumerModel;

public interface ConsumerService {
    public int callConsumerSP(ConsumerDto dto);
    public int callConsumerDelSP(long id, String workUser);
    public List<ConsumerModel> getAll(String mobile, String workUser);

}
