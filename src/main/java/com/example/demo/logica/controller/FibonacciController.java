package com.example.demo.logica.controller;

import com.example.demo.FibonacciApplication;
import com.example.demo.logica.modelo.Fibonacci;
import com.example.demo.logica.service.FibonacciService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600,allowedHeaders = "*")
@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {
    @Autowired
    FibonacciService fibonacciService;

    @GetMapping("/top-consulted")
    public ResponseEntity<?> getTopConsulted(){
        try {
            return new ResponseEntity<List<Fibonacci>>(fibonacciService.getAllByAppearances(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(Arrays.toString(e.getStackTrace()), HttpStatus.BAD_REQUEST);
        }

    }
}
