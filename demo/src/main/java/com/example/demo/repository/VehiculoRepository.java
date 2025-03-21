package com.example.demo.repository;

import com.example.demo.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
    Optional<Vehiculo> findByPlaca(String placa);
}
