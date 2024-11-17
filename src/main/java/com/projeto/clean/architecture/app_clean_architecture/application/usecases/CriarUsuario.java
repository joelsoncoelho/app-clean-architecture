package com.projeto.clean.architecture.app_clean_architecture.application.usecases;


import com.projeto.clean.architecture.app_clean_architecture.application.gateways.RepositorioDeUsuario;
import com.projeto.clean.architecture.app_clean_architecture.domain.entities.usuario.Usuario;

public class CriarUsuario {

    private final RepositorioDeUsuario repositorio;

    public CriarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
         return repositorio.cadastrarUsuario(usuario);
    }
}
