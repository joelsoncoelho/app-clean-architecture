package com.projeto.clean.architecture.app_clean_architecture.application.usecases;

import com.projeto.clean.architecture.app_clean_architecture.application.gateways.RepositorioDeUsuario;
import com.projeto.clean.architecture.app_clean_architecture.domain.entities.usuario.Usuario;

public class AlterarUsuario {

    private final RepositorioDeUsuario repositorio;

    public AlterarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario alteraDadosUsuario(String cpf, Usuario usuario){
        return repositorio.alterarUsuario(cpf, usuario);
    }
}
