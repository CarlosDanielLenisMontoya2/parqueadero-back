package com.example.demo.repository;

import com.example.demo.models.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepositry extends JpaRepository<Registro,Long> {
}
