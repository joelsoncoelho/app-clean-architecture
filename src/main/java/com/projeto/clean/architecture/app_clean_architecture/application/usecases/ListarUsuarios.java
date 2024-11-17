package com.projeto.clean.architecture.app_clean_architecture.application.usecases;

import com.projeto.clean.architecture.app_clean_architecture.application.gateways.RepositorioDeUsuario;
import com.projeto.clean.architecture.app_clean_architecture.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuarios {

    private final RepositorioDeUsuario repositorio;

    public ListarUsuarios(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> obterTodosUsuarios(){
        return this.repositorio.listarTodos();
    }
}
