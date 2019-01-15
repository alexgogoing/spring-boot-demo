package org.example.demo.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* @Controller + @ResponseBody */
@RequestMapping("/hello")
public class HellowordController {
    private Logger logger = LoggerFactory.getLogger(HellowordController.class);

    @RequestMapping("/test")
    public String test(){
        return "success";
    }
}
