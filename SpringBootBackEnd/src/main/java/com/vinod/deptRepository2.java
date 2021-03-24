package com.vinod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface deptRepository2 extends JpaRepository<dept, Long>  {
	
	
	

}
