package com.example.demo.dto.transformer;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioTransformer {
    public Usuario usuarioFromTransformerDto (UsuarioDto usuarioDto){
        if (usuarioDto == null)return null;

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setTelefono(usuarioDto.getTelefono());
        return usuario;
    }

    public UsuarioDto usuarioDtoFromTransformerModel (Usuario usuario){
        if (usuario == null)return null;

        UsuarioDto usuariodto = new UsuarioDto();
        usuariodto.setId(usuario.getId());
        usuariodto.setNombre(usuario.getNombre());
        usuariodto.setEmail(usuario.getEmail());
        usuariodto.setTelefono(usuario.getTelefono());
        return usuariodto;
    }
    public Usuario usuarioFromTransformerDtoUpdate (UsuarioDto usuarioDto){
        if (usuarioDto == null)return null;

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setTelefono(usuarioDto.getTelefono());
        return usuario;
    }
}
