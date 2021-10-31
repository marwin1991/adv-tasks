package com.codecool.springaopdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping
    @LogExecutionTime
    public String ping(@RequestParam String test){
        System.out.println(test);
        return test("abcd");
    }

    public String test(String string){
        System.out.println("Hello");
        return string + "a";
    }
}
