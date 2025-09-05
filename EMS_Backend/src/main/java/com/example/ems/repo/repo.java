package com.example.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ems.model.employee;

@Repository

public interface repo extends JpaRepository <employee,Long>{

}
