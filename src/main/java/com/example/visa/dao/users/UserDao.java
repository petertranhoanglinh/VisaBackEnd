package com.example.visa.dao.users;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.visa.entity.Users;
import com.example.visa.model.accounts.UserModel;

@Repository
public interface UserDao extends JpaRepository<Users, String> {

        @Query(value = "SELECT USERNAME AS userName    "
                        + "          , USERID     AS userId    "
                        + "          , ROLE     AS role        "
                        + "          , PASSWORD AS password    "
                        + "          , RankCd   as rankCd      "
                        + "          , ctrid    as ctrId       "
                        + "          , referral_code as referralCode"
                        + "          , photo         as photo       "
                        + "          , rate          as rate        "
                        + "       FROM USERS                   "
                        + "      WHERE USERID =:userId         ", nativeQuery = true)
        public UserModel getByUser(String userId);

        @Query(value = "SELECT USERID                            "
                        + "            FROM USERS                        "
                        + "           WHERE REFERRAL_CODE =:referralCode ", nativeQuery = true)
        public String checkReferralCode(String referralCode);

        @Modifying
        @Transactional
        @Query(value = "UPDATE USERS                              "
                        + "    SET RATE =  RATE + 1               "
                        + "  WHERE  USERID =:userId               ", nativeQuery = true)
        public void updateRateByUserId(String userId);

        @Query(value = " call test(:userId) ", nativeQuery = true)
        public String checkUser(String userId);

        @Modifying
        @Transactional
        @Query(value = "UPDATE USERS "
                        + "   SET photo =:photo "
                        + " WHERE USERID =:userId ", nativeQuery = true)
        public void updateUser(String userId, String photo);
}
