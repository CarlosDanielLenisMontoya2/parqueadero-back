package com.example.demo.service;

import com.example.demo.dto.VehiculoDto;
import com.example.demo.models.Vehiculo;
import org.springframework.data.domain.Page;

public interface VehiculoService {
    VehiculoDto create (VehiculoDto vehiculoDto);
    VehiculoDto update (VehiculoDto vehiculoDto);
    void delete (Long id);
    Page<Vehiculo> read (Integer PageSize, Integer PageNumber);
}
