package com.example.demo.service;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.models.Usuario;
import org.springframework.data.domain.Page;

public interface UsuarioService {

    UsuarioDto create (UsuarioDto usuarioDto);
    UsuarioDto update (UsuarioDto usuarioDto);
    void delete (Long id);
    Page<Usuario> read (Integer PageSize,Integer PageNumber);
}
