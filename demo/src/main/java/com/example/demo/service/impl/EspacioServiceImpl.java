package com.example.demo.service.impl;

import com.example.demo.dto.EspacioDto;
import com.example.demo.dto.transformer.EspacioTranformer;
import com.example.demo.exeptions.MiExcepcionPersonalizada;
import com.example.demo.models.Espacio;
import com.example.demo.models.Usuario;
import com.example.demo.models.Vehiculo;
import com.example.demo.models.Zona;
import com.example.demo.repository.EspacioRepository;
import com.example.demo.repository.ZonaRepository;
import com.example.demo.service.EspacioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ =@Autowired)
public class EspacioServiceImpl implements EspacioService {
    private final EspacioRepository espacioRepository;
    private final ZonaRepository zonaRepository;
    private final EspacioTranformer espacioTranformer;

    @Override
    public EspacioDto create(EspacioDto espacioDto) {
        Optional<Espacio> espacioExistente = espacioRepository.findByNumero(espacioDto.getNumero());

        if (espacioExistente.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST,
                    "Número de espacio ya en uso", "El número de espacio ingresado ya está en uso");
        }

        // Validar si la Zona existe
        Optional<Zona> zonaOptional = zonaRepository.findById(espacioDto.getZonaId().getId());

        if (zonaOptional.isEmpty()) {
            throw new MiExcepcionPersonalizada(404, HttpStatus.NOT_FOUND,
                    "Zona no encontrada", "No se encontró la zona con ID ");
        }
        Espacio espacio = espacioTranformer.EspacioFromDto(espacioDto);
        espacioDto = espacioTranformer.espacioDtoFromModel(espacioRepository.save(espacio));
        return espacioDto;

    }

    @Override
    public EspacioDto update(EspacioDto espacioDto) {
        Optional<Espacio> existente = espacioRepository.findById(espacioDto.getId());
        if (existente.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST, "espacio no encontrado", "El espacio que ingresó ya no se encuentra con el id " );
        }
        Espacio espacio = espacioTranformer.EspacioFromDtoUpdate(espacioDto);
        espacioDto = espacioTranformer.espacioDtoFromModel(espacioRepository.save(espacio));
        return espacioDto;
    }

    @Override
    public void delete(Long id) {
        if (this.espacioRepository.existsById(id)) {
            log.info("Deleting espacio with id: " + id);
            this.espacioRepository.deleteById(id);
        } else {
            log.error("Error: espacio con id " + id + " no existe");
            throw new MiExcepcionPersonalizada(404, HttpStatus.BAD_REQUEST,
                    "No se encontro espacio", "El espacio que ingresó ya está no existe ");
        }

    }

    @Override
    public Page<Espacio> read(Integer PageSize, Integer PageNumber) {
        Pageable pageable = PageRequest.of(PageNumber, PageSize);
        return espacioRepository.findAll(pageable);
    }
}
