package com.example.demo.logica.service;

import com.example.demo.datos.FibonacciRepository;
import com.example.demo.logica.modelo.Fibonacci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FibonacciService {
    @Autowired
    FibonacciRepository fibonacciRepository;
    public List<Fibonacci> getAllByAppearances () {
        return fibonacciRepository.getAllByAppearances();
    }

    public BigInteger getFibonacci(long n) {

        Fibonacci fibonacci = fibonacciRepository.getByPosition(n);
        if (fibonacci != null) {
            fibonacciRepository.updateByAppearances(n,fibonacci.getAppearances() + 1);
            return new BigInteger(fibonacci.getValue());
        }


        BigInteger result;
        if (n <= 0) {
            throw new IllegalArgumentException("El valor de n debe ser un número natural mayor que 0.");
        }else if (n == 1) {
            return BigInteger.ONE;
        }else {
            BigInteger[] fibonacciArray = new BigInteger[(int) n];
            fibonacciArray[0] = BigInteger.ONE;
            fibonacciArray[1] = BigInteger.ONE;
            for (int i = 2; i < n; i++) {
                fibonacciArray[i] = fibonacciArray[i - 1].add(fibonacciArray[i - 2]);
            }
            result = fibonacciArray[(int) (n - 1)];
        }


        Fibonacci newFibonacci = new Fibonacci();
        newFibonacci.setPosition(n);
//        Se guarda como String por las razones explicadas en el modelo. (Leer modelo para explicación)
        newFibonacci.setValue(result.toString());
        newFibonacci.setAppearances(1L);
        fibonacciRepository.save(newFibonacci);

        return result;
    }
}
