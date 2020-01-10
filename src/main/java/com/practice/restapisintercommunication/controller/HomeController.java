package com.practice.restapisintercommunication.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/all/home")
@Api(value = "", description = "This is Plain Rest API for Inter Rest Api's Communication")
public class HomeController {

    @GetMapping("/getHome")
    @ApiOperation(value = "Get Home Soon", notes = "Test if the Home Resource is accessible")
    public String getHome(){
        return "Got home safely!!!";
    }

}
