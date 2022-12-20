package com.example.backend.dao.extend;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Coin;
import com.example.backend.model.extend.CoinModel;


@Repository
public interface CoinDao  extends JpaRepository<Coin, String> {
    
    @Query(value = "select B.id as coinId                                                          "
                  + "    , math_rate_coin_fn(b.id, A.coinBeforeSevenDay) AS rateCoin7day           "
                  + "    , ROUND(coinBeforeSevenDay, 5) as   coinBeforeSevenDay                    "
                  + "    , B.current_price as currentPrice                                         "
                  + "    , B.image as image                                                        "
                  + " from                                                                         "
                  + "      (select coinId                                                          "
                  + "            , avg(price_log) as coinBeforeSevenDay                            "
                  + "         from coin_log                                                        "
                  + "        where time_update = REPLACE(cast((current_date - 7) as TEXT),'-','')  "
                  + "        group by coinid) A                                                    "
                  + "    , coin B                                                                  "
                  + "where A.coinId = B.ID                                                         "
                  + "ORDER BY B.total_volume                                                       "
                  , nativeQuery = true)
    public List<CoinModel> getAvgCoinLog7d(Pageable pageable);

}
