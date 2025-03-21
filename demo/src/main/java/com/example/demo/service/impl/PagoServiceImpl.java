package com.example.demo.service.impl;

import com.example.demo.dto.PagoDto;
import com.example.demo.dto.transformer.PagoTransformer;
import com.example.demo.exeptions.MiExcepcionPersonalizada;
import com.example.demo.models.Pago;
import com.example.demo.models.Reserva;
import com.example.demo.repository.PagoRepository;
import com.example.demo.service.PagoService;
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
public class PagoServiceImpl implements PagoService {
    private final PagoRepository repository;
    private final PagoTransformer transformer;
    @Override
    public PagoDto create(PagoDto pagoDto) {

        Optional<Pago> pagoExistente = repository.findAllByReserva(pagoDto.getReserva());
        if (pagoExistente.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST,
                    "Esta reserva ya se pago", "la reserva con ID " + pagoExistente.isPresent() + " ya está ocupado.");
        }
        Pago pago = transformer.pagoTransformerFromDto(pagoDto);
        pagoDto = transformer.pagoDtoTransformerFromModels(repository.save(pago));
        return pagoDto;
    }

    @Override
    public PagoDto update(PagoDto pagoDto) {
        Optional<Pago> pagoExistente = repository.findAllByReserva(pagoDto.getReserva());
        if (pagoExistente.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST,
                    "Esta reserva ya se pago", "la reserva con ID " + pagoExistente.isPresent() + " ya está ocupado.");
        }
        Pago pago = transformer.pagoTransformerFromDto(pagoDto);
        pagoDto = transformer.pagoDtoTransformerFromModels(repository.save(pago));
        return pagoDto;
    }

    @Override
    public void delete(Long id) {
        if (this.repository.existsById(id)) {
            log.info("Deleting espacio with id: " + id);
            this.repository.deleteById(id);
        } else {
            log.error("Error: espacio con id " + id + " no existe");
            throw new MiExcepcionPersonalizada(404, HttpStatus.BAD_REQUEST,
                    "No se encontro espacio", "El espacio que ingresó ya está no existe ");
        }

    }

    @Override
    public Page<Pago> read(Integer PageSize, Integer PageNumber) {
        Pageable pageable = PageRequest.of(PageNumber, PageSize);
        return repository.findAll(pageable);
    }
}
