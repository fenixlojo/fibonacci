package com.example.demo.logica.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "value")
    private Integer value;

    @Column(name = "appearances")
    private Integer appearances;
}
