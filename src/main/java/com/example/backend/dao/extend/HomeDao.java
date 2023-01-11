package com.example.backend.dao.extend;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Users;
import com.example.backend.model.AnalysicModel;

@Repository 
public interface HomeDao extends JpaRepository<Users, String> {
    
    @Query(value = "select A.qtyUser              "
            + "     , B.qtyConsumer               "
            + "  from (                           "
            + "    select count(*) as qtyUser     "
            + "      from users                   "
            + "  )A,                              "
            + "  (                                "
            + "    select count(*) as qtyConsumer "
            + "      from consumer                "
            + "  )B"   , nativeQuery = true)
    public  AnalysicModel getHomeDao();
    
    

}
