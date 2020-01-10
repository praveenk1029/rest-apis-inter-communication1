package com.practice.restapisintercommunication.service;

import com.practice.restapisintercommunication.model.Employee;
import com.practice.restapisintercommunication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    protected EmployeeRepository employeeRepository;

    public Employee findByEmpId(Integer empId) throws Exception {
        Optional<Employee> optionalEmployee //= Optional.ofNullable(employeeRepository.findOne(empId));
            = employeeRepository.findByEmpId(empId);
        optionalEmployee.orElseThrow(()->new Exception("Employee not found!!!"));
        return optionalEmployee.get();
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }


}
