package com.example.demo.service.impl;

import com.example.demo.dto.ZonaDto;
import com.example.demo.dto.transformer.ZonaTransformer;
import com.example.demo.exeptions.MiExcepcionPersonalizada;
import com.example.demo.models.Zona;
import com.example.demo.repository.ZonaRepository;
import com.example.demo.service.ZonaService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ =@Autowired)
public class ZonaServiceImpl implements ZonaService {
    private final ZonaRepository repository;
    private final ZonaTransformer transformer;
    @Override
    public ZonaDto create(ZonaDto zonaDto) {

        Zona zona = transformer.zonaTransformerFromDto(zonaDto);
        zonaDto = transformer.zonaDtoTransformerFromModels(repository.save(zona));
        return zonaDto;
    }

    @Override
    public ZonaDto update(ZonaDto zonaDto) {
        Zona zona = transformer.zonaTransformerFromDtoUpdate(zonaDto);
        zonaDto = transformer.zonaDtoTransformerFromModels(repository.save(zona));
        return zonaDto;
    }

    @Override
    public void delete(Long id) {
        if (this.repository.existsById(id)) {
            log.info("Deleting usuario with id: " + id);
            this.repository.deleteById(id);
        } else {
            log.error("Error: Usuario con id " + id + " no existe");
            throw new MiExcepcionPersonalizada(404, HttpStatus.BAD_REQUEST,
                    "No se encontro Usuario", "El usuario que ingresó ya está no existe ");
        }
    }

    @Override
    public Page<Zona> read(Integer PageSize, Integer PageNumber) {
        Pageable pageable = PageRequest.of(PageNumber, PageSize);
        return repository.findAll(pageable);
    }
}
