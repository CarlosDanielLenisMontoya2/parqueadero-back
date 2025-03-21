package com.example.demo.controller;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.models.Usuario;
import com.example.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService service;

    @PostMapping("/create-usuario")
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto){
        return service.create(usuarioDto);
    }
    @PutMapping("/update-usuario")
    public UsuarioDto update(@RequestBody UsuarioDto usuarioDto){
        return service.update(usuarioDto);
    }
    @DeleteMapping("/delete-usuario/{id}")
    void delete(@PathVariable Long id){
        service.delete(id);
    }
    @GetMapping("/read-usuario")
    Page<Usuario> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        return service.read(pageSize, pageNumber);
    }
}
