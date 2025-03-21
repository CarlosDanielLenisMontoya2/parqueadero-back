package com.example.demo.service.impl;

import com.example.demo.dto.ReservaDto;
import com.example.demo.dto.transformer.ReservaTransformer;
import com.example.demo.exeptions.MiExcepcionPersonalizada;
import com.example.demo.models.Espacio;
import com.example.demo.models.Reserva;
import com.example.demo.models.Usuario;
import com.example.demo.repository.EspacioRepository;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.service.ReservaService;
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
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final ReservaTransformer transformer;

    @Override
    public ReservaDto create(ReservaDto reservaDto) {
        Optional<Reserva> reservaExistente = reservaRepository.findByEspacio(reservaDto.getEspacio());
        if (reservaExistente.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST,
                    "Espacio ocupado", "El espacio con ID " + reservaDto.getEspacio() + " ya está ocupado.");
        }

        Reserva reserva = transformer.reservaTransformerFromDto(reservaDto);
        reservaDto = transformer.reservaDtoTransformerFromModel(reservaRepository.save(reserva));
        return reservaDto;
    }

    @Override
    public ReservaDto update(ReservaDto reservaDto) {
        Optional<Reserva> reservaExistente = reservaRepository.findByEspacio(reservaDto.getEspacio());
        if (reservaExistente.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST,
                    "Espacio ocupado", "El espacio con ID " + reservaDto.getEspacio() + " ya está ocupado.");
        }
        Reserva reserva = transformer.reservaTransformerFromDtoUpdate(reservaDto);
        reservaDto = transformer.reservaDtoTransformerFromModel(reservaRepository.save(reserva));
        return reservaDto;
    }

    @Override
    public void delete(Long id) {
        if (this.reservaRepository.existsById(id)) {
            log.info("Deleting usuario with id: " + id);
            this.reservaRepository.deleteById(id);
        } else {
            log.error("Error: Usuario con id " + id + " no existe");
            throw new MiExcepcionPersonalizada(404, HttpStatus.BAD_REQUEST,
                    "No se encontro Usuario", "El usuario que ingresó ya está no existe ");
        }


    }

    @Override
    public Page<Reserva> read(Integer PageSize, Integer PageNumber) {
        Pageable pageable = PageRequest.of(PageNumber, PageSize);
        return reservaRepository.findAll(pageable);
    }
}
