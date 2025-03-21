package com.example.demo.dto.transformer;

import com.example.demo.dto.EspacioDto;
import com.example.demo.dto.VehiculoDto;
import com.example.demo.models.Espacio;
import com.example.demo.models.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class EspacioTranformer {


        public Espacio EspacioFromDto(EspacioDto espacioDto) {
            if (espacioDto == null) return null;

            Espacio espacio = new Espacio();
            espacio.setNumero(espacioDto.getNumero());
            espacio.setZonaId(espacioDto.getZonaId());
            return espacio;
        }
        public EspacioDto espacioDtoFromModel(Espacio espacio){
            if (espacio == null) return null;

            EspacioDto espacioDto = new EspacioDto();
            espacioDto.setId(espacio.getId());
            espacioDto.setNumero(espacio.getNumero());
            espacioDto.setZonaId(espacio.getZonaId());
            return espacioDto;
        }
        public Espacio EspacioFromDtoUpdate(EspacioDto espacioDto) {
            if (espacioDto == null) return null;

            Espacio espacio = new Espacio();
            espacio.setId(espacioDto.getId());
            espacio.setNumero(espacioDto.getNumero());
            espacio.setZonaId(espacioDto.getZonaId());
            return espacio;
        }
    }



