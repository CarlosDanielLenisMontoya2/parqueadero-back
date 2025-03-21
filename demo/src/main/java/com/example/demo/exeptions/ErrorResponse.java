package com.example.demo.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int codigo;
    private HttpStatus estado;
    private String error;
    private String mensaje;
    private String descripcion;
    private LocalDateTime timestamp = LocalDateTime.now();
}
