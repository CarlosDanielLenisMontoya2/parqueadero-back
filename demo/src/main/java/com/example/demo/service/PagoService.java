package com.example.demo.service;

import com.example.demo.dto.PagoDto;
import com.example.demo.models.Pago;
import org.springframework.data.domain.Page;

public interface PagoService {
    PagoDto create (PagoDto pagoDto);
    PagoDto update (PagoDto pagoDto);
    void delete (Long id);
    Page<Pago> read (Integer PageSize, Integer PageNumber);
}
