package com.projeto.clean.architecture.app_clean_architecture.application.gateways;

import com.projeto.clean.architecture.app_clean_architecture.domain.entities.usuario.Usuario;

import java.util.List;

public interface RepositorioDeUsuario {

    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario alterarUsuario(String cpf, Usuario usuario);

    void excluirUsuario(String cpf);
}
