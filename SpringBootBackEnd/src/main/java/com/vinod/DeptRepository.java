package com.vinod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DeptRepository extends JpaRepository<Department, Long> {
	
	
	
	
	 

}
