package com.example.demo.exeptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MiExcepcionPersonalizada extends RuntimeException {
    private final int codigo;
    private final HttpStatus estado;
    private final String descripcion;

    public MiExcepcionPersonalizada(int codigo, HttpStatus estado, String mensaje, String descripcion) {
        super(mensaje);
        this.codigo = codigo;
        this.estado = estado;
        this.descripcion = descripcion;
    }
}
