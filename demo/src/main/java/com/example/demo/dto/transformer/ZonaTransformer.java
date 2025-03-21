package com.example.demo.dto.transformer;

import com.example.demo.dto.ZonaDto;
import com.example.demo.models.Zona;
import org.springframework.stereotype.Component;

@Component
public class ZonaTransformer {
    public Zona zonaTransformerFromDto (ZonaDto zonaDto){
        if (zonaDto == null)return null;

        Zona zona = new Zona();
        zona.setNombre(zonaDto.getNombre());
        zona.setDescripcion(zonaDto.getDescripcion());
        return zona;
    }
    public ZonaDto zonaDtoTransformerFromModels (Zona zona){
        if (zona == null)return null;

        ZonaDto zonaDto = new ZonaDto();
        zonaDto.setId(zona.getId());
        zonaDto.setNombre(zona.getNombre());
        zonaDto.setDescripcion(zona.getDescripcion());
        return zonaDto;
    }
    public Zona zonaTransformerFromDtoUpdate (ZonaDto zonaDto){
        if (zonaDto == null)return null;

        Zona zona = new Zona();
        zona.setId(zonaDto.getId());
        zona.setNombre(zonaDto.getNombre());
        zona.setDescripcion(zonaDto.getDescripcion());
        return zona;
    }
}
