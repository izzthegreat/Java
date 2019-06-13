package com.win.practice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// provides hints for Spring that the class plays a specific role
// our class is a web @controller so Spring considers it whe handling incoming web requests
@RestController
public class MainController {
    // annotation that provides routing info.
    // tells Spring that any http request with "/" path should be mapped to the home() method
    @RequestMapping("/")
    // Because of @RestController annotation Spring renders resulting string directly back to the caller.
    // IN this case caller is the home() method and theString is returned.
    public String home(){
        return "Hello, World!";
    }
}
