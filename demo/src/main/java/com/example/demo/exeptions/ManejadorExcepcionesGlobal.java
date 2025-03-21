package com.example.demo.exeptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ManejadorExcepcionesGlobal {

    @ExceptionHandler(MiExcepcionPersonalizada.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse manejarMiExcepcion(MiExcepcionPersonalizada ex) {
        return new ErrorResponse(
                ex.getCodigo(),
                ex.getEstado(),
                ex.getEstado().getReasonPhrase(),
                ex.getMessage(),
                ex.getDescripcion(),
                LocalDateTime.now()
        );
    }
}
