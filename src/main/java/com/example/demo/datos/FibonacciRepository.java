package com.example.demo.datos;

import com.example.demo.logica.modelo.Fibonacci;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FibonacciRepository extends JpaRepository<Fibonacci,Long> {

    @Query(nativeQuery = true,value = "SELECT f.* FROM fibonacci f " +
            "ORDER BY f.appearances desc LIMIT :limit")
    List<Fibonacci> getAllByAppearances(long limit);

    @Query(nativeQuery = true,value = "SELECT f.* FROM fibonacci f " +
            "WHERE f.position = :position")
    Fibonacci getByPosition(long position);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE fibonacci f SET f.appearances = :appearances WHERE f.position = :position")
    void updateByAppearances(long position,long appearances);
}
