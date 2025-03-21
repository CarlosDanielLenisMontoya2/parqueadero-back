package com.example.demo.repository;

import com.example.demo.models.Espacio;
import com.example.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EspacioRepository extends JpaRepository<Espacio,Long> {
    Optional<Espacio> findByNumero(String numero);
}
