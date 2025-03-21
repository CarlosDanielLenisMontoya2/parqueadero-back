package com.example.demo.dto.transformer;

import com.example.demo.dto.VehiculoDto;
import com.example.demo.models.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class VehiculoTranformer {

    public Vehiculo vehiculoTranformerDto(VehiculoDto vehiculoDto) {
        if (vehiculoDto == null) return null;

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(vehiculoDto.getPlaca());
        vehiculo.setMarca(vehiculoDto.getMarca());
        vehiculo.setModelo(vehiculoDto.getModelo());
        vehiculo.setUsuarioId(vehiculoDto.getUsuarioId());
        return vehiculo;
    }

    public VehiculoDto vehiculoDtoFromTranfrmerModel(Vehiculo vehiculo) {
        if (vehiculo == null) return null;

        VehiculoDto vehiculoDto = new VehiculoDto();
        vehiculoDto.setId(vehiculo.getId());
        vehiculoDto.setPlaca(vehiculo.getPlaca()); // Corregido
        vehiculoDto.setMarca(vehiculo.getMarca());
        vehiculoDto.setModelo(vehiculo.getModelo()); // Corregido
        vehiculoDto.setUsuarioId(vehiculo.getUsuarioId());

        return vehiculoDto;
    }

    public Vehiculo vehiculoTranformerDtoUpdate(VehiculoDto vehiculoDto) {
        if (vehiculoDto == null) return null;

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(vehiculoDto.getId());
        vehiculo.setPlaca(vehiculoDto.getPlaca());
        vehiculo.setMarca(vehiculoDto.getMarca());
        vehiculo.setModelo(vehiculoDto.getModelo());
        vehiculo.setUsuarioId(vehiculoDto.getUsuarioId());

        return vehiculo;
    }
}
