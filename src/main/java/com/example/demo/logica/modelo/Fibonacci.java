package com.example.demo.logica.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "fibonacci")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fibonacci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    Se guarda como String ya que al guardarlo como BigInteger los valores mas grandes de Fibonacci (al crecer
//    de forma exponencial) no se pueden guardar ya que son demaciado grandes para el tipo de dato.
//    La idea detras de esto es que la API pueda devolver números de la secuencia Fibonacci sin un limitante
//    maximo de valores.
    @Column(name = "value")
    private String value;

    @Column(name = "position")
    private Long position;

    @Column(name = "appearances")
    private Long appearances;
}
