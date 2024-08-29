package com.example.demo.datos;

import com.example.demo.logica.modelo.Fibonacci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FibonacciRepository extends JpaRepository<Fibonacci,Long> {

    @Query(nativeQuery = true,value = "SELECT f.* FROM fibonacci f " +
            "ORDER BY f.appearances desc")
    List<Fibonacci> getAllByAppearances();
}
