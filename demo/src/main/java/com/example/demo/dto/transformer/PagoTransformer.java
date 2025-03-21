package com.example.demo.dto.transformer;

import com.example.demo.dto.PagoDto;
import com.example.demo.models.Pago;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagoTransformer {
    public Pago pagoTransformerFromDto (PagoDto pagoDto){
        if (pagoDto == null)return null;

        Pago pago = new Pago();
        pago.setReserva(pagoDto.getReserva());
        pago.setMonto(pagoDto.getMonto());
        pago.setFechaHora(LocalDateTime.now());
        pago.setMetodo(pagoDto.getMetodo());
        return pago;
    }

    public PagoDto pagoDtoTransformerFromModels (Pago pago){
        if (pago==null)return null;

        PagoDto pagoDto = new PagoDto();

        pagoDto.setId(pago.getId());
        pagoDto.setReserva(pago.getReserva());
        pagoDto.setMonto(pago.getMonto());
        pagoDto.setFechaHora(LocalDateTime.now());
        pagoDto.setMetodo(pago.getMetodo());
        return pagoDto;
    }
    public Pago pagoTransformerFromDtoUpdate (PagoDto pagoDto){
        if (pagoDto == null)return null;

        Pago pago = new Pago();
        pago.setId(pagoDto.getId());
        pago.setReserva(pagoDto.getReserva());
        pago.setMonto(pagoDto.getMonto());
        pago.setFechaHora(LocalDateTime.now());
        pago.setMetodo(pagoDto.getMetodo());
        return pago;
    }
}
