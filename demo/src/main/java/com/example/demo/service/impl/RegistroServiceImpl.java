package com.example.demo.service.impl;

import com.example.demo.dto.RegistroDto;
import com.example.demo.dto.transformer.RegistroTranformer;
import com.example.demo.exeptions.MiExcepcionPersonalizada;
import com.example.demo.models.Registro;
import com.example.demo.models.Reserva;
import com.example.demo.models.Vehiculo;
import com.example.demo.repository.RegistroRepositry;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.VehiculoRepository;
import com.example.demo.service.RegistroService;
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
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RegistroServiceImpl implements RegistroService {
    private final RegistroRepositry registroRepositry;
    private final VehiculoRepository vehiculoRepository;
    private final ReservaRepository reservaRepository;
    private final RegistroTranformer registroTransformer;

    @Override
    public RegistroDto create(RegistroDto registroDto) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(registroDto.getReservaId().getId());
        if (reservaOptional.isEmpty()) {
            throw new MiExcepcionPersonalizada(404, HttpStatus.NOT_FOUND,
                    "Reserva no encontrada", "No se encontró la reserva con ID " + registroDto.getReservaId());
        }

        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(registroDto.getVehiculoId().getId());
        if (vehiculoOptional.isEmpty()) {
            throw new MiExcepcionPersonalizada(404, HttpStatus.NOT_FOUND,
                    "Vehículo no encontrado", "No se encontró el vehículo con ID " + registroDto.getVehiculoId());
        }

        Registro registro = registroTransformer.registroTransformerFromDto(registroDto);
        registroDto = registroTransformer.registroDtoTransformerFromModel(registroRepositry.save(registro));
        return registroDto;
    }

    @Override
    public RegistroDto update(RegistroDto registroDto) {
        Optional<Registro> existente = registroRepositry.findById(registroDto.getId());
        if (existente.isEmpty()) {
            throw new MiExcepcionPersonalizada(404, HttpStatus.BAD_REQUEST,
                    "Registro no encontrado", "El registro con ID " + registroDto.getId() + " no existe");
        }

        Registro registro = registroTransformer.registroTransformerFromDtoUpdate(registroDto);
        registroDto = registroTransformer.registroDtoTransformerFromModel(registroRepositry.save(registro));
        return registroDto;
    }

    @Override
    public void delete(Long id) {
        if (registroRepositry.existsById(id)) {
            log.info("Eliminando registro con ID: " + id);
            registroRepositry.deleteById(id);
        } else {
            log.error("Error: Registro con ID " + id + " no existe");
            throw new MiExcepcionPersonalizada(404, HttpStatus.BAD_REQUEST,
                    "No se encontró el registro", "El registro con ID " + id + " no existe");
        }
    }

    @Override
    public Page<Registro> read(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return registroRepositry.findAll(pageable);
    }
}
