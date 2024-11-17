package com.projeto.clean.architecture.app_clean_architecture.configuration;


import com.projeto.clean.architecture.app_clean_architecture.application.gateways.RepositorioDeUsuario;
import com.projeto.clean.architecture.app_clean_architecture.application.usecases.AlterarUsuario;
import com.projeto.clean.architecture.app_clean_architecture.application.usecases.CriarUsuario;
import com.projeto.clean.architecture.app_clean_architecture.application.usecases.ExcluirUsuario;
import com.projeto.clean.architecture.app_clean_architecture.application.usecases.ListarUsuarios;
import com.projeto.clean.architecture.app_clean_architecture.infrastructure.gateways.RepositorioDeUsuarioJpa;
import com.projeto.clean.architecture.app_clean_architecture.infrastructure.gateways.UsuarioEntityMapper;
import com.projeto.clean.architecture.app_clean_architecture.infrastructure.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    ListarUsuarios listarUsuarios(RepositorioDeUsuario repositorioDeUsuario){
        return new ListarUsuarios(repositorioDeUsuario);
    }

    @Bean
    AlterarUsuario alterarUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new AlterarUsuario(repositorioDeUsuario);
    }

    @Bean
    ExcluirUsuario excluirUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new ExcluirUsuario(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJpa criarRepositorioDeUsuarioJpa(UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper){
        return new RepositorioDeUsuarioJpa(usuarioRepository, usuarioEntityMapper);
    }

    @Bean
    UsuarioEntityMapper retornaMapper(){
        return new UsuarioEntityMapper();
    }

}
