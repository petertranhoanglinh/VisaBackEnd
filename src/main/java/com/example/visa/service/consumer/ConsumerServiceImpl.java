package com.example.visa.service.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.visa.dao.consumer.ConsumerDao;
import com.example.visa.dto.consumer.ConsumerDto;
import com.example.visa.model.ConsumerModel;
import com.example.visa.util.Utils;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    ConsumerDao dao;

    @Override
    public int callConsumerSP(ConsumerDto dto) {

        String workUser = Utils.getUserDetail().getUsername();
        // TODO Auto-generated method stub
        return this.dao.callConsumerSP(dto.getId(), dto.getName(),
                dto.getAddress(), dto.getMobile(), dto.getEmail(), workUser);
    }

    @Override
    public List<ConsumerModel> getAll(String mobile, String workUser) {
        // TODO Auto-generated method stub
        return this.dao.getAll(mobile, workUser);
    }

}