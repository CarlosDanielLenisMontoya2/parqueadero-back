package com.example.demo.dto.transformer;

import com.example.demo.dto.ReservaDto;
import com.example.demo.models.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaTransformer {

    public Reserva reservaTransformerFromDto (ReservaDto reservaDto){
        if (reservaDto == null)return null;

        Reserva reserva = new Reserva();

        reserva.setUsuario(reservaDto.getUsuario());
        reserva.setEspacio(reservaDto.getEspacio());
        reserva.setFechaHoraInicio(reservaDto.getFechaHoraInicio());
        reserva.setFechaHoraFin(reservaDto.getFechaHoraFin());
        return reserva;
    }
    public ReservaDto reservaDtoTransformerFromModel(Reserva reserva){
        if (reserva == null)return null;

        ReservaDto reservaDto = new ReservaDto();

        reservaDto.setId(reserva.getId());
        reservaDto.setUsuario(reserva.getUsuario());
        reservaDto.setEspacio(reserva.getEspacio());
        reservaDto.setFechaHoraInicio(reserva.getFechaHoraInicio());
        reservaDto.setFechaHoraFin(reserva.getFechaHoraFin());
        return reservaDto;

    }
    public Reserva reservaTransformerFromDtoUpdate (ReservaDto reservaDto){
        if (reservaDto == null)return null;

        Reserva reserva = new Reserva();

        reserva.setId(reservaDto.getId());
        reserva.setUsuario(reservaDto.getUsuario());
        reserva.setEspacio(reservaDto.getEspacio());
        reserva.setFechaHoraInicio(reservaDto.getFechaHoraInicio());
        reserva.setFechaHoraFin(reservaDto.getFechaHoraFin());
        return reserva;
    }
}
