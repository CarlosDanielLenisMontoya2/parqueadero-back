package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ZonaDto {
    private Long id;
    private String nombre;
    private String descripcion;
}
