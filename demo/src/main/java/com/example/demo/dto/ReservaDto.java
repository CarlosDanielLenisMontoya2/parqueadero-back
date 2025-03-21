package com.example.demo.dto;

import com.example.demo.models.Espacio;
import com.example.demo.models.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservaDto {
    private Long id;
    private Usuario usuario;
    private Espacio espacio;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
}
