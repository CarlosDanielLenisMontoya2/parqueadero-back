package com.example.demo.service.impl;

import com.example.demo.dto.VehiculoDto;
import com.example.demo.dto.transformer.VehiculoTranformer;
import com.example.demo.exeptions.MiExcepcionPersonalizada;
import com.example.demo.models.Usuario;
import com.example.demo.models.Vehiculo;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.VehiculoRepository;
import com.example.demo.service.VehiculoService;
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
public class VehiculoServiceImpl implements VehiculoService {
    private final VehiculoRepository vehiculoRepository;
    private final UsuarioRepository usuarioRepository;
    private final VehiculoTranformer vehiculoTranformer;

    @Override
    public VehiculoDto create(VehiculoDto vehiculoDto) {
        // Validar si la placa ya está en uso
        if (vehiculoRepository.findByPlaca(vehiculoDto.getPlaca()).isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST,
                    "Placa ya en uso", "La placa ingresada ya está en uso");
        }

        // Validar si el usuario existe
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(vehiculoDto.getUsuarioId().getId());
        if (!usuarioOptional.isPresent()) {
            throw new MiExcepcionPersonalizada(404, HttpStatus.NOT_FOUND,
                    "Usuario no encontrado", "No se encontró el usuario con ID " + vehiculoDto.getUsuarioId());
        }
        Vehiculo vehiculo = vehiculoTranformer.vehiculoTranformerDto(vehiculoDto);
        vehiculoDto = vehiculoTranformer.vehiculoDtoFromTranfrmerModel(vehiculoRepository.save(vehiculo));
        return vehiculoDto;
    }

    @Override
    public VehiculoDto update(VehiculoDto vehiculoDto) {
        Optional<Vehiculo> existente = vehiculoRepository.findById(vehiculoDto.getId());
        if (existente.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST, "Vehiculo no encontrado", "El Vehiculo que ingresó ya no se encuentra con el id " +vehiculoDto.getId());
        }
        Vehiculo vehiculo = vehiculoTranformer.vehiculoTranformerDtoUpdate(vehiculoDto);
        vehiculoDto = vehiculoTranformer.vehiculoDtoFromTranfrmerModel(vehiculoRepository.save(vehiculo));
        return vehiculoDto;
    }

    @Override
    public void delete(Long id) {
        if (this.vehiculoRepository.existsById(id)) {
            log.info("Deleting usuario with id: " + id);
            this.vehiculoRepository.deleteById(id);
        } else {
            log.error("Error: Vehiculo con id " + id + " no existe");
            throw new MiExcepcionPersonalizada(404, HttpStatus.BAD_REQUEST,
                    "No se encontro vehiculo", "El vehiculo que ingresó ya está no existe ");
        }

    }

    @Override
    public Page<Vehiculo> read(Integer PageSize, Integer PageNumber) {
        Pageable pageable = PageRequest.of(PageNumber, PageSize);
        return vehiculoRepository.findAll(pageable);
    }
}
