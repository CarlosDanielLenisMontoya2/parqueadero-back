package com.example.demo.service.impl;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.dto.transformer.UsuarioTransformer;
import com.example.demo.exeptions.MiExcepcionPersonalizada;
import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ =@Autowired)
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioTransformer transformer;
    @Override
    public UsuarioDto create(UsuarioDto usuarioDto) {
        Optional<Usuario> existenteEmail = usuarioRepository.findByEmail(usuarioDto.getEmail());
        if (existenteEmail.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST, "email ya en uso", "El email que ingresó ya está en uso por otro usuario");
        }
        Optional<Usuario> existenteTelefono = usuarioRepository.findByTelefono(usuarioDto.getTelefono());
        if (existenteTelefono.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST, "telefono ya en uso", "El telefono que ingresó ya está en uso por otro usuario");
        }

        Usuario usuario = transformer.usuarioFromTransformerDto(usuarioDto);
        usuarioDto = transformer.usuarioDtoFromTransformerModel(usuarioRepository.save(usuario));
        return usuarioDto;
    }

    @Override
    public UsuarioDto update(UsuarioDto usuarioDto) {
        Optional<Usuario> existenteEmail = usuarioRepository.findByEmail(usuarioDto.getEmail());
        if (existenteEmail.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST, "email ya en uso", "El email que ingresó ya está en uso por otro usuario");
        }
        Optional<Usuario> existenteTelefono = usuarioRepository.findByTelefono(usuarioDto.getTelefono());
        if (existenteEmail.isPresent()) {
            throw new MiExcepcionPersonalizada(400, HttpStatus.BAD_REQUEST, "telefono ya en uso", "El telefono que ingresó ya está en uso por otro usuario");
        }

        Usuario usuario = transformer.usuarioFromTransformerDtoUpdate(usuarioDto);
        usuarioDto = transformer.usuarioDtoFromTransformerModel(usuarioRepository.save(usuario));
        return usuarioDto;
    }

    @Override
    public void delete(Long id) {

        if (this.usuarioRepository.existsById(id)) {
            log.info("Deleting usuario with id: " + id);
            this.usuarioRepository.deleteById(id);
        } else {
            log.error("Error: Usuario con id " + id + " no existe");
            throw new MiExcepcionPersonalizada(404, HttpStatus.BAD_REQUEST,
                    "No se encontro Usuario", "El usuario que ingresó ya está no existe ");
        }

    }


    @Override
    public Page<Usuario> read(Integer PageSize, Integer PageNumber) {
        Pageable pageable = PageRequest.of(PageNumber, PageSize);
        return usuarioRepository.findAll(pageable);
    }
}
