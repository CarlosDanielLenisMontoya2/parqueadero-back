package com.example.demo.dto.transformer;

import com.example.demo.dto.RegistroDto;
import com.example.demo.models.Registro;
import com.example.demo.models.Reserva;
import com.example.demo.models.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class RegistroTranformer {

    public Registro registroTransformerFromDto(RegistroDto registroDto) {
        if (registroDto == null) return null;

        Registro registro = new Registro();
        registro.setReservaId(registroDto.getReservaId());
        registro.setVehiculoId(registroDto.getVehiculoId());
        registro.setFechaHoraIngreso(registroDto.getFechaHoraIngreso());
        registro.setFechaHoraSalida(registroDto.getFechaHoraSalida());
        return registro;
    }

    public RegistroDto registroDtoTransformerFromModel(Registro registro) {
        if (registro == null) return null;

        RegistroDto registroDto = new RegistroDto();
        registroDto.setId(registro.getId());
        registroDto.setReservaId(registro.getReservaId());
        registroDto.setVehiculoId(registro.getVehiculoId());
        registroDto.setFechaHoraIngreso(registro.getFechaHoraIngreso());
        registroDto.setFechaHoraSalida(registro.getFechaHoraSalida());
        return registroDto;
    }

    public Registro registroTransformerFromDtoUpdate(RegistroDto registroDto) {
        if (registroDto == null) return null;

        Registro registro = new Registro();
        registro.setId(registroDto.getId());
        registro.setReservaId(registroDto.getReservaId());
        registro.setVehiculoId(registroDto.getVehiculoId());
        registro.setFechaHoraIngreso(registroDto.getFechaHoraIngreso());
        registro.setFechaHoraSalida(registroDto.getFechaHoraSalida());
        return registro;
    }
}
