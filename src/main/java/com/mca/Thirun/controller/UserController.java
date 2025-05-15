package com.mca.Thirun.controller;

import com.mca.Thirun.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/operation")
    public ResponseEntity<String> performOperation(
            @RequestParam(required = false)Integer value1,
            @RequestParam(required = false)Integer value2,
            @RequestParam(required = false)String ops
    ){
        if (value1==null||value2==null||ops==null||ops.isEmpty()){


            return ResponseEntity.badRequest().body("please provide valid data");
        }
        String result =userService.calculate(value1,value2,ops);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/help")
    public ResponseEntity<Object>getHelp(){
        return ResponseEntity.ok(userService.getSupportedoperations());
    }
//    @GetMapping("/expression")
//    public ResponseEntity<String> expressionMethod(){
//
//        ResponseEntity<Object> response = ResponseEntity.ok(userService.getExpression());
//
//        HttpStatus status = (HttpStatus) response.getStatusCode();  // Gets status (e.g. 200 OK)
//        int statusCode = status.value();               // Gets int value (e.g. 200)
//
//        System.out.println("Status code is: " + statusCode);
//
////        return statusCode ;
//        return ResponseEntity.ok(status+" : "+userService.getExpression());
//    }


@GetMapping("/expression")
public ResponseEntity<String> expressionMethod() {
    String expression = userService.getExpression();
    HttpStatus status = expression != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;

    System.out.println("Status code is: " + status.value());

    return ResponseEntity.status(status).body(status + " : " + expression);
}

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
