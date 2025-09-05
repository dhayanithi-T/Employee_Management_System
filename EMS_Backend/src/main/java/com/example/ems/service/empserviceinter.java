package com.example.ems.service;


	import java.util.List;

import com.example.ems.model.empDto;

	public interface empserviceinter{
	    List<empDto> getAllEmployees();

	    empDto createEmployee(empDto employee);

	    empDto getEmployeeById(Long employeeId);

	    empDto updateEmployee(Long employeeId, empDto employeeDto);

	    void deleteEmployee(Long employeeId);
	
}
