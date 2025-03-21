package com.example.demo.service;

import com.example.demo.dto.RegistroDto;
import com.example.demo.dto.ReservaDto;
import com.example.demo.models.Registro;
import com.example.demo.models.Reserva;
import org.springframework.data.domain.Page;

public interface RegistroService {
    RegistroDto create (RegistroDto registroDto);
    RegistroDto update (RegistroDto registroDto);
    void delete (Long id);
    Page<Registro> read (Integer PageSize, Integer PageNumber);
}
