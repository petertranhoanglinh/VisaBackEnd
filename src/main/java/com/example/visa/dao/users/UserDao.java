package com.example.visa.dao.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.visa.entity.Users;
import com.example.visa.model.UserModel;

@Repository
public interface UserDao extends JpaRepository<Users, String> {

        @Query(value = "SELECT USERNAME AS userName                 "
                        + "          , USERID     AS userId         "
                        + "          , ROLE     AS role             "
                        + "          , PASSWORD AS password         "
                        + "          , photo         as photo       "
                        + "          , address       as address     "
                        + "          , phone         as phone       "
                        + "          , email         as email       "
                        + "       FROM USERS                        "
                        + "      WHERE USERID =:userId              ", nativeQuery = true)
        public UserModel getByUser(String userId);
}
