package com.example.backend.dao.extend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Coin;


@Repository
public interface CoinDao  extends JpaRepository<Coin, String> {

}
