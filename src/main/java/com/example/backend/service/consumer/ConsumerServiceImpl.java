package com.example.backend.service.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.backend.dao.consumer.ConsumerDao;
import com.example.backend.dto.consumer.ConsumerDto;
import com.example.backend.model.ConsumerModel;
import com.example.backend.util.Utils;

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
    public List<ConsumerModel> getAll(String mobile, String workUser , int page) {
        // TODO Auto-generated method stub
        if (mobile.equals("*")) {
            mobile = "%%";
        } else {
            mobile = "%" + mobile + "%";
        }
        return this.dao.getAll(mobile, workUser ,PageRequest.of(page, 10));
    }

	@Override
	public int callConsumerDelSP(long id, String workUser) {
		// TODO Auto-generated method stub
		return this.dao.callConsumerDelSP(id, workUser);
	}
	
	@Override 
	public List<ConsumerModel> getAllTest(){
		return this.dao.getAllTest();
	}

}
