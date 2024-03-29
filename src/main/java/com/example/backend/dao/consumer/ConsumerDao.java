package com.example.backend.dao.consumer;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Users;
import com.example.backend.model.ConsumerModel;

@Repository
public interface ConsumerDao extends JpaRepository<Users, String> {

    @Query(value = "CALL CONSUMER_SP(:id,:name,:address,:mobile,:email ,:taxCode, :comName, :workUser,0)", nativeQuery = true)
    public int callConsumerSP(long id, String name, String address, String mobile, String email, String taxCode, String comName,
            String workUser);

    @Query(value = "SELECT A.ID AS id                                          "
            + "                   , A.Name as name                             "
            + "                   , A.mobile as mobile                         "
            + "                   , A.address as address                       "
            + "                   , (B.username || ' ' || A.work_User) as workUser "
            + "                   , A.email as email                           "
            + "                   , Work_Date as workDate                      "
            + "                   , tax_code as taxCode                        "
            + "                   , com_name as comName                        "
            + "                from Consumer A , users B                       "
            + "               where A.work_user = B.userId                     "
            + "                 and A.mobile like :mobile                         "
            + "                 and A.work_user  =:workUser                         ", nativeQuery = true)
    public List<ConsumerModel> getAll(String mobile, String workUser, Pageable pageable);
    
    @Query(value = "CALL CONSUMER_DEL_SP(:id,:workUser,0)", nativeQuery = true)
    public int callConsumerDelSP(long id, String workUser);
    
    @Query(value = "SELECT A.ID AS id                                              "
            + "                   , A.Name as name                                 "
            + "                   , A.mobile as mobile                             "
            + "                   , A.address as address                           "
            + "                   , (B.username || ' ' || A.work_User) as workUser "
            + "                   , A.email as email                               "
            + "                   , Work_Date as workDate                          "
            + "                from Consumer A , users B                           "
            + "               where A.work_user = B.userId                         "
            , nativeQuery = true)
    public List<ConsumerModel> getAllTest();
}
