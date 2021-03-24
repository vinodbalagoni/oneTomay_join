package com.vinod;

public class DepartmentRequest {
	
	
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "OrderRequest [department=" + department + "]";
	}
	
	

}
