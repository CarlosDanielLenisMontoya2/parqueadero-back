package com.example.demo.dto;

import com.example.demo.models.Reserva;
import com.example.demo.models.Vehiculo;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistroDto {
    private Long id;
    private Reserva reservaId;
    private Vehiculo vehiculoId;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
}
