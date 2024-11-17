package com.projeto.clean.architecture.app_clean_architecture.infrastructure.gateways;


import com.projeto.clean.architecture.app_clean_architecture.domain.entities.usuario.Usuario;
import com.projeto.clean.architecture.app_clean_architecture.infrastructure.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

   public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(
                usuario.getCpf(),
                usuario.getNome(),
                usuario.getNascimento(),
                usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity usuarioEntity){
       return new Usuario(
               usuarioEntity.getCpf(),
               usuarioEntity.getNome(),
               usuarioEntity.getNascimento(),
               usuarioEntity.getEmail());
    }
}
