package com.example.demo.service;

import com.example.demo.dto.EspacioDto;
import com.example.demo.dto.UsuarioDto;
import com.example.demo.models.Espacio;
import com.example.demo.models.Usuario;
import org.springframework.data.domain.Page;

public interface EspacioService {
    EspacioDto create (EspacioDto espacioDto);
    EspacioDto update (EspacioDto espacioDto);
    void delete (Long id);
    Page<Espacio> read (Integer PageSize, Integer PageNumber);
}
