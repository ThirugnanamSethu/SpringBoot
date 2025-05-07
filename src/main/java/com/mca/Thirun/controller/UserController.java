package com.mca.Thirun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private int count = 0;

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello from Spring Boot New Function !";
    }

    @PostMapping("/create")
    public String createData(@RequestBody String data) {
        return "Data received via POST: " + data;
    }

    @PutMapping("/update")
    public String updateData(@RequestBody String updatedData) {

        return "Data updated via PUT: " + updatedData;
    }

    @GetMapping("/increase")
    public String increase() {
        count++;
        return "The current count value is : " + count;
    }

    @GetMapping("/get")
    public String getCounter() {
        return "Current counter value: " + count;
    }

}
