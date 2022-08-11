package com.example.visa.dao.setting;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.visa.entity.Users;
import com.example.visa.model.UserModel;

@Repository
public interface LoginDao extends PagingAndSortingRepository<Users, String> {
	// getUserDetailDao
	@Query(value = "SELECT NAME AS userName    "
			+ "          , USERID AS userId    "
			+ "          , ADDRESS AS address  "
			+ "       FROM ACCOUNTS            "
			+ "      WHERE NAME =:userId       ", nativeQuery = true)
	public UserModel getUser(String userId);

}
