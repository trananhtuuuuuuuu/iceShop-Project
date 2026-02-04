package iceShop.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iceShop.backend.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID>{
  
}
