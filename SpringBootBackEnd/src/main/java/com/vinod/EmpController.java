package com.vinod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/")
public class EmpController {
	
	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	private DeptRepository deptRepository;
	
	@Autowired
	private deptRepository2  deptRepository2;
	
	//save department 
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/department")
	public Department createDepartment(@RequestBody DepartmentRequest department)
	{
		return deptRepository.save(department.getDepartment());
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/dept")
	public dept createdept(@RequestBody deptRequest2 department)
	{
		return deptRepository2.save(department.getDept());
		
	}
	
	//get all employees
	@GetMapping("/employees")
	public List<employees> getAllEmployees(){
		
		return empRepository.findAll();
		
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/employees")
	
	// create Employee rest api
	
	public employees createEmployee(@RequestBody employees employees)
	{
		return empRepository.save(employees);
		
	}
	
	
	
	//getting all departments
	
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/dept")

		public List<dept> getDepartment()
		{
			return deptRepository2.findAll( );
			
		}
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/department")

		public List<Department> getDepartment1()
		{
			return deptRepository.findAll( );
			
		}
		 
//	//get Employee by  id
//	@GetMapping("/employees/{id}")
//	public ResponseEntity<employee> getEmployeeById(@PathVariable Long id)
//	{
//		employee employee=empRepository.findById(id)
//				.orElseThrow(()->new ResourceNotFoundException("employee not exits with id"+id));
//		return ResponseEntity.ok(employee);
//		
//	}
	
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
//		Employee employee = empRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		
//		employee.setFirstName(employeeDetails.getFirstName());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Employee updatedEmployee = empRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
//	// delete employee rest api
//		@DeleteMapping("/employees/{id}")
//		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
//			Employee employee = empRepository.findById(id)
//					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//			
//			empRepository.delete(employee);
//			Map<String, Boolean> response = new HashMap<>();
//			response.put("deleted", Boolean.TRUE);
//			return ResponseEntity.ok(response);
//		}
//	
//	

}
