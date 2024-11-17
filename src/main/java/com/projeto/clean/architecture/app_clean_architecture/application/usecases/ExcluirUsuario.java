package com.projeto.clean.architecture.app_clean_architecture.application.usecases;

import com.projeto.clean.architecture.app_clean_architecture.application.gateways.RepositorioDeUsuario;

public class ExcluirUsuario {

    private final RepositorioDeUsuario repositorio;

    public ExcluirUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public void excluirUsuario(String cpf){
        repositorio.excluirUsuario(cpf);
    }
}
