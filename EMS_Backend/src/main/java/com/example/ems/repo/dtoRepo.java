package com.example.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ems.model.empDto;

@Repository
public interface dtoRepo  extends JpaRepository<empDto,Long>{

}
