package com.example.demo.controller;

import com.example.demo.dto.ReservaDto;
import com.example.demo.dto.UsuarioDto;
import com.example.demo.models.Reserva;
import com.example.demo.models.Usuario;
import com.example.demo.service.ReservaService;
import com.example.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/reserva")
public class ReservaController {
    private final ReservaService service;

    @PostMapping("/create-reserva")
    public ReservaDto create(@RequestBody ReservaDto reservaDto){
        return service.create(reservaDto);
    }
    @PutMapping("/update-reserva")
    public ReservaDto update(@RequestBody ReservaDto reservaDto){
        return service.update(reservaDto);
    }
    @DeleteMapping("/delete-reserva/{id}")
    void delete(@PathVariable Long id){
        service.delete(id);
    }
    @GetMapping("/read-reserva")
    Page<Reserva> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        return service.read(pageSize, pageNumber);
    }
}
