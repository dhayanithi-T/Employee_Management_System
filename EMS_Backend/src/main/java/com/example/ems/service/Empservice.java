package com.example.ems.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ems.contoller.ResourceNotFoundException;
import com.example.ems.model.empDto;
import com.example.ems.model.employee;
import com.example.ems.repo.dtoRepo;
import com.example.ems.repo.repo;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class Empservice implements empserviceinter {
	
	@Autowired
    repo repo;
	@Autowired
	dtoRepo dtoRepo;

	@Override
    public empDto createEmployee(empDto dto) {
        employee employee = new employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());

        employee saved = repo.save(employee);
        return convertToDto(saved);
    }

    @Override
    public List<empDto> getAllEmployees() {
        return repo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public empDto getEmployeeById(Long id) {
        employee employee = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with ID: " + id));
        return convertToDto(employee);
    }

    @Override
    public empDto updateEmployee(Long id, empDto dto) {
        employee employee = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with ID: " + id));

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());

        employee updated = repo.save(employee);
        return convertToDto(updated);
    }

    @Override
    public void deleteEmployee(Long id) {
        employee employee = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found wit h ID: " + id));
        repo.delete(employee);
    }

    // Internal helper method
    private empDto convertToDto(employee employee) {
        empDto dto = new empDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        return dto;
    }

}
