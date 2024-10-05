package com.develhope.logging_exercise.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/logging")
public class Controller {
    // parameters
    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    // methods
    @GetMapping("/")
    public String welcomeMsg(){
        String message = "welcome to fantasy world";
        logger.info("message: {}", message);
        return message;
    }

    @GetMapping("/exp")
    public Double exponent(@RequestParam Double base,@RequestParam Double exponent){
          logger.info("calculating the power of base: {} and exponen: {}", base, exponent);
        Double value = Math.pow(base,exponent);
        logger.info("result value: {}",value);
          return value;
    }

    @GetMapping("/get-errors")
    public String customErrors(){
        logger.error("my custom error");
        throw new RuntimeException("exception at endpoint /get-errors");
    }


}
