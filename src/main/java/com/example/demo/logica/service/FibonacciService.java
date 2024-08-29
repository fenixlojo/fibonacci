package com.example.demo.logica.service;

import com.example.demo.datos.FibonacciRepository;
import com.example.demo.logica.modelo.Fibonacci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FibonacciService {
    @Autowired
    FibonacciRepository fibonacciRepository;
    public List<Fibonacci> getAllByAppearances () {
        return fibonacciRepository.getAllByAppearances();
    }
}
