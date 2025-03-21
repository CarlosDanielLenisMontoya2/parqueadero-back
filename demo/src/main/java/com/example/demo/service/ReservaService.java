package com.example.demo.service;


import com.example.demo.dto.ReservaDto;
import com.example.demo.models.Reserva;
import org.springframework.data.domain.Page;

public interface ReservaService {

    ReservaDto create (ReservaDto reservaDto);
    ReservaDto update (ReservaDto reservaDto);
    void delete (Long id);
    Page<Reserva> read (Integer PageSize, Integer PageNumber);
}
