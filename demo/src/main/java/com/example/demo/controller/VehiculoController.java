package com.example.demo.controller;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.dto.VehiculoDto;
import com.example.demo.models.Usuario;
import com.example.demo.models.Vehiculo;
import com.example.demo.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final VehiculoService vehiculoService;

    @PostMapping("/create-vehiculo")
    public VehiculoDto create(@RequestBody VehiculoDto vehiculoDto){
        return vehiculoService.create(vehiculoDto);
    }
    @PutMapping("/update-vehiculo")
    public VehiculoDto update(@RequestBody VehiculoDto vehiculoDto){
        return vehiculoService.update(vehiculoDto);
    }
    @DeleteMapping("/delete-vehiculo/{id}")
    void delete(@PathVariable Long id){
        vehiculoService.delete(id);
    }
    @GetMapping("/read-vehiculo")
    Page<Vehiculo> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        return vehiculoService.read(pageSize, pageNumber);
    }
}
