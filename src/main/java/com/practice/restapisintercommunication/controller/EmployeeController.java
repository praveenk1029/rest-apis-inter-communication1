package com.practice.restapisintercommunication.controller;

import com.practice.restapisintercommunication.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.practice.restapisintercommunication.model.Employee;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

@RestController
@RequestMapping("/all/employee")
@Api(value = "Employee Transactions", description = "Manage Employee")
public class EmployeeController {

    @Autowired
    protected EmployeeService employeeService;

    @GetMapping(value = "/getEmployee/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Pulls Employee Info", notes = "Search Employee!")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Employee not found"),
            @ApiResponse(code = 200, message = "Success Message:200")
    })
    public Employee getEmployee(@PathVariable Integer empId) throws Exception {
        return employeeService.findByEmpId(empId);
    }

    @PostMapping(value = "/rest/employee/saveEmployee")
    public void saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @PutMapping(value = "/rest/employee/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @GetMapping(value = "/callRemoteRestApi", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee callRemoteRestApi(){
        String uri = "http://localhost:8080/rest/employee/getEmployee/6";
        RestTemplate restTemplate = new RestTemplate();
        Employee employee = restTemplate.getForObject(uri, Employee.class);
        System.out.println("Result from Remote Api:::::"+employee);
        return employee;
    }
}
