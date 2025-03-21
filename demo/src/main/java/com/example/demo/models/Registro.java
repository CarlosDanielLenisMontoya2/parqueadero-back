package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "registro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reservaId;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculoId;

    @Column(name = "fecha_hora_ingreso", nullable = false)
    private LocalDateTime fechaHoraIngreso;

    @Column(name = "fecha_hora_salida")
    private LocalDateTime fechaHoraSalida;
}
