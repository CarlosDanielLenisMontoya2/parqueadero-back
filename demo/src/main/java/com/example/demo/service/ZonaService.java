package com.example.demo.service;


import com.example.demo.dto.ZonaDto;
import com.example.demo.models.Zona;
import org.springframework.data.domain.Page;

public interface ZonaService {

    ZonaDto create (ZonaDto zonaDto);
    ZonaDto update (ZonaDto zonaDto);
    void delete (Long id);
    Page<Zona> read (Integer PageSize, Integer PageNumber);
}
