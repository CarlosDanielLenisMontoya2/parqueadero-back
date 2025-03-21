package com.example.demo.dto;

import com.example.demo.models.Usuario;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculoDto {
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private Usuario usuarioId;
}
