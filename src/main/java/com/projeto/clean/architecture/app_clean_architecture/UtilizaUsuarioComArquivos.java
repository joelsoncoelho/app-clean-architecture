package com.projeto.clean.architecture.app_clean_architecture;



import com.projeto.clean.architecture.app_clean_architecture.domain.entities.usuario.Usuario;
import com.projeto.clean.architecture.app_clean_architecture.infrastructure.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivos {
    public static void main(String[] args) {

        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(
                new Usuario("546.150.010-29","Venom Snake", LocalDate.parse("2000-10-15"), "venom@gmail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(
                new Usuario("546.150.010-29", "Venom Snake", LocalDate.parse("2000-10-15"), "venom@gmail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(
                new Usuario("365.076.070-37","Liquid Snake", LocalDate.parse("2000-10-15"),"liquid@gmail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(
                new Usuario("059.644.760-40", "Solidus Snake", LocalDate.parse("2000-10-15"),
                        "solidus@gmail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(
                new Usuario("647.100.030-84", "Big Boss" , LocalDate.parse("2000-10-15"), "bigboss@gmail.com"));

        //System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());

        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuario.txt");

    }
}
