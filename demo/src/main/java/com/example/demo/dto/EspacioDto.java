package com.example.demo.dto;

import com.example.demo.models.Zona;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EspacioDto {
    private Long id;
    private String numero;
    private Zona zonaId;
}
