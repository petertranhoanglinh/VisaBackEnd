SELECT A.coinId as coinId 
     , AVG(A.priceBuy)  as priceBuy 
	 , SUM(A.quantityCoin) as quantityCoin
	 , AVG(A.rate)  as rate
	 , AVG(A.priceNow) as priceNow
	 , A.userId as  userId
  FROM  (SELECT A.coinID as coinId                                            
			  , A.coin_price  as priceBuy                                      
			  , A.quantity_Coin as quantityCoin                               
			  , math_rate_coin_fn(A.coinid , A.coin_price) as rate            
			  , B.PRICE as priceNow 
		      , A.BUYER_ID as userID
		 FROM CART_SHOPPING  A , COIN B                                       
		WHERE A.BUYER_ID ='VN051098'                                             
		  AND A.COINID = B.COINID) A 
 GROUP BY A.coinId , A.userId;