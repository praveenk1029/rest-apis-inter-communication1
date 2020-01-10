package com.practice.restapisintercommunication.repository;

import com.practice.restapisintercommunication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmpId(Integer empId);
}
