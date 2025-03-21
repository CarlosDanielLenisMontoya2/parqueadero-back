package com.example.demo.controller;

import com.example.demo.dto.EspacioDto;
import com.example.demo.dto.UsuarioDto;
import com.example.demo.models.Espacio;
import com.example.demo.models.Usuario;
import com.example.demo.service.EspacioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/espacios")
public class EspacioController {
    private final EspacioService espacioService;
    @PostMapping("/create-espacio")
    public EspacioDto create(@RequestBody EspacioDto espacioDto){
        return espacioService.create(espacioDto);
    }
    @PutMapping("/update-espacio")
    public EspacioDto update(@RequestBody EspacioDto espacioDto){
        return espacioService.update(espacioDto);
    }
    @DeleteMapping("/delete-espacio/{id}")
    void delete(@PathVariable Long id){
        espacioService.delete(id);
    }
    @GetMapping("/read-usuario")
    Page<Espacio> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        return espacioService.read(pageSize, pageNumber);
    }
}
