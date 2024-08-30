package com.example.demo.logica.test;

import com.example.demo.logica.service.FibonacciService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FibonacciServiceTest {

    @Autowired
    FibonacciService fibonacciService;

    @Test
    public void testFibonacciPositiveNumbers() {
        System.out.println("TEST STARTING");
        assertEquals(BigInteger.valueOf(1), fibonacciService.getFibonacci(1));
        assertEquals(BigInteger.valueOf(1), fibonacciService.getFibonacci(2));
        assertEquals(BigInteger.valueOf(2), fibonacciService.getFibonacci(3));
        assertEquals(BigInteger.valueOf(3), fibonacciService.getFibonacci(4));
        assertEquals(BigInteger.valueOf(5), fibonacciService.getFibonacci(5));
        assertEquals(BigInteger.valueOf(8), fibonacciService.getFibonacci(6));
        System.out.println("TEST FINISH");
    }

    @Test
    public void testFibonacciLargeNumber() {
        System.out.println("TEST STARTING");
        assertEquals(new BigInteger("12586269025"), fibonacciService.getFibonacci(50));
        System.out.println("TEST FINISH");
    }

    @Test
    public void testInvalidInput() {
        System.out.println("TEST STARTING");
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciService.getFibonacci(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciService.getFibonacci(-1);
        });
        System.out.println("TEST FINISH");
    }
}