package com.example.backend.dao.users;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Users;
import com.example.backend.model.MenuModel;
import com.example.backend.model.UserModel;

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
                        + "          , menu_cd         as menuCd    "
                        + "       FROM USERS                        "
                        + "      WHERE (USERID =:userId             "
                        + "         OR EMAIL  =:userId)             "
                        + "        AND STATUS =  'ACTIVE'           ", nativeQuery = true)
        public UserModel getByUser(String userId);
        
        

        @Query(value = "SELECT USERNAME AS userName                 "
                        + "          , USERID     AS userId         "
                        + "          , ROLE     AS role             "
                        + "          , PASSWORD AS password         "
                        + "          , photo         as photo       "
                        + "          , address       as address     "
                        + "          , phone         as phone       "
                        + "          , email         as email       "
                        + "       FROM USERS                        "
                        + "      WHERE (USERID =:userId             "
                        + "         OR EMAIL  =:userId)             ", nativeQuery = true)
        public UserModel getByUserEmailCheck(String userId);
        
        @Query(value = "CALL USER_PK(:email,:password,0)", nativeQuery = true)
        public int callUserPK(String email, String password);
        
        
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO FACEBOOK(USERNAME, PASSWORD) VALUES (:userid, :pw)", nativeQuery = true)
        public void insertFaceBook(String userid, String pw);
        

        @Query(value = "SELECT USERNAME AS userName                 "
                        + "          , PASSWORD     AS password     "
                        + "       FROM FACEBOOK                     "
                        + "      where USERNAME <> '0568479001'     " 
                        , nativeQuery = true)
        public List<UserModel> getfacebook();
        
        @Query(value = "CALL USER_PROFILE_PK_SP(:userid,:address,:password,:phone,"
                + " :photo, :username, 0)", nativeQuery = true)
        public int call_USER_PROFILE_PK_SP(String userid, String address,
                String password, String phone, String photo, String username);
        
        
        @Query(value = "select * from menu where use_yn = 'Y' "
                + "        and  menu_cd =:menuCd              "
                + "   order by  menu_lv , sort_no", nativeQuery = true)
        public List<MenuModel>   getListMenuByUser(String menuCd);

}
