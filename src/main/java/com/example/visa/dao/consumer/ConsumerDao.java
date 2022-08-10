package com.example.visa.dao.consumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.visa.entity.Users;

@Repository
public interface ConsumerDao extends JpaRepository<Users, String> {

    @Query(value = "CALL CONSUMER_SP(:id,:name,:address,:mobile,:workUser,0)", nativeQuery = true)
    public int callConsumerSP(long id, String name, String address, String mobile,
            String workUser);

}
