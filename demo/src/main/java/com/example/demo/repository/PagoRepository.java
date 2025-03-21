package com.example.demo.repository;

import com.example.demo.models.Pago;
import com.example.demo.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago,Long> {
    Optional<Pago> findAllByReserva(Reserva reserva);
}
