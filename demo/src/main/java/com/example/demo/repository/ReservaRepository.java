package com.example.demo.repository;

import com.example.demo.models.Espacio;
import com.example.demo.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {
    Optional<Reserva> findByEspacio(Espacio espacio);
}
