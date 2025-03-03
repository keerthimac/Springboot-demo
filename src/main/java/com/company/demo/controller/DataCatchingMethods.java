package com.company.demo.controller;


import com.company.demo.dto.StudentDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/param")
public class DataCatchingMethods {

    //this is Query parameter request method
    //only need to decorate with @RequestParam
    //@RequestParam(required = false) means this parameter is not required
    //@RequestParam(required = true) means this parameter is required
    //@RequestParam(defaultValue = "default value") means this parameter has a default value & if the parameter is not provided, the default value will be used
    //@RequestParam(value = "name") means this parameter has a different name.as a example, if the parameter name is "name", we can use @RequestParam(value = "name") for our different name parameter variable
    @PostMapping
    public String paramCheck(@RequestParam(required = false) String id,@RequestParam(required = false) String name,@RequestParam(required = false) String address){
        System.out.println(id);
        System.out.println(name);
        System.out.println(address);
        return "ok";

    }

    @PostMapping("/header")
    public String headerCheck(@RequestParam(required = false) String id,@RequestParam(required = false) String name,@RequestParam(required = false) String address){
        System.out.println(id);
        System.out.println(name);
        System.out.println(address);
        return "ok";

    }

    @PostMapping("/body")
    public String bodyCheck(@RequestBody StudentDto studentDto){
        System.out.println("===========================");
        System.out.println("Id: " + studentDto.getId());
        System.out.println("Name: " + studentDto.getName());
        System.out.println("Address: "+studentDto.getAddress());
        System.out.println("Age: "+ studentDto.getAge());
        System.out.println("===========================");
        return "ok";

    }    @PostMapping("/body_arr")
    public String bodyCheckArr(@RequestBody ArrayList<StudentDto> studentDtoList){
        for(StudentDto studentDto : studentDtoList){
            System.out.println("===========================");
            System.out.println("Id: " + studentDto.getId());
            System.out.println("Name: " + studentDto.getName());
            System.out.println("Address: "+studentDto.getAddress());
            System.out.println("Age: "+ studentDto.getAge());
            System.out.println("===========================");
        }
        return "ok";
    }
}
