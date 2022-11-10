DO
$$
declare
	 i  numeric ;

begin
   i := 0;
   
   loop
      i := i+1;
	   insert into consumer (name, address, mobile , email , work_user)
	   values(random_string(5) ,random_string(5),random_string(5),random_string(5),'VN000000');
	   COMMIT;
	 exit when i > 10 ;
	
	 
   end loop;
  
   -- close the cursor

END$$;