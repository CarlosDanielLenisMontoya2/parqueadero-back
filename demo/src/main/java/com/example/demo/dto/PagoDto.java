package com.example.demo.dto;

import com.example.demo.models.Reserva;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagoDto {
    private Long id;
    private Reserva reserva;
    private Double monto;
    private LocalDateTime fechaHora;
    private String metodo;
}
