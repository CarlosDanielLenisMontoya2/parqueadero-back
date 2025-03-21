package com.example.demo.controller;

import com.example.demo.dto.RegistroDto;
import com.example.demo.dto.ReservaDto;
import com.example.demo.models.Registro;
import com.example.demo.models.Reserva;
import com.example.demo.service.RegistroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/registros")
public class RegistroController {
    private final RegistroService registroService;

    @PostMapping("/create-registro")
    public RegistroDto create(@RequestBody RegistroDto registroDto){
        return registroService.create(registroDto);
    }
    @PutMapping("/update-registro")
    public RegistroDto update(@RequestBody RegistroDto registroDto){
        return registroService.update(registroDto);
    }
    @DeleteMapping("/delete-registro/{id}")
    void delete(@PathVariable Long id){
        registroService.delete(id);
    }
    @GetMapping("/read-registro")
    Page<Registro> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        return registroService.read(pageSize, pageNumber);
    }

}
