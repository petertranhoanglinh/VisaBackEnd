

DO
$$
declare
	 v_count numeric;
	 i  numeric ;
     rec   record;
	 cur1 cursor 
		 for select *
		 from users;
begin
   select count(*) into v_count  from users ;
   i := 0;
   open cur1;
   loop
      i := i+1;
	 fetch cur1 into rec;
	 exit when i > v_count ;
	 RAISE NOTICE 'tên nhân viên là(%)', rec.username;
	 
   end loop;
  
   -- close the cursor
   close cur1;
END$$;
