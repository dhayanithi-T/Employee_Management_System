package com.example.ems.contoller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.model.empDto;
import com.example.ems.repo.dtoRepo;
import com.example.ems.service.Empservice;

import lombok.AllArgsConstructor;


	@CrossOrigin("*")
	@AllArgsConstructor
	@RestController
	@RequestMapping("/api/v1/employees")
	public class empcontroller {
		
		@Autowired
	     Empservice employeeService;
		@Autowired
		dtoRepo dtoRepo;

	    @GetMapping
	    public ResponseEntity<List<empDto>> getAllEmployees(){
	        List<empDto> employees = employeeService.getAllEmployees();
	        return ResponseEntity.ok(employees);
	    }

	    // build create employee REST API
	    @PostMapping
	    public ResponseEntity<empDto> createEmployee(@RequestBody empDto employee) {
	        empDto employeeDto = employeeService.createEmployee(employee);
	        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
	    }

	    // build get employee by id REST API
	    @GetMapping("{id}")
	    public ResponseEntity<empDto> getEmployeeById(@PathVariable("id") Long employeeId){
	        empDto employee = employeeService.getEmployeeById(employeeId);
	        return ResponseEntity.ok(employee);
	    }

	    // build update employee REST API
	    @PutMapping("{id}")
	    public ResponseEntity<empDto> updateEmployee(@PathVariable("id") Long employeeId,
	                                                   @RequestBody empDto employeeDetails) {
	        empDto updateEmployee = employeeService.updateEmployee(employeeId, employeeDetails);
	        return ResponseEntity.ok(updateEmployee);
	    }

	    // build delete employee REST API
	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
	        employeeService.deleteEmployee(employeeId);
	        return ResponseEntity.ok("Employee deleted successfully!");
	    }
	

}
