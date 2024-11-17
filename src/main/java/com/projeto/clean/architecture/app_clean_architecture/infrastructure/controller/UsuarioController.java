package com.projeto.clean.architecture.app_clean_architecture.infrastructure.controller;


import com.projeto.clean.architecture.app_clean_architecture.application.usecases.AlterarUsuario;
import com.projeto.clean.architecture.app_clean_architecture.application.usecases.CriarUsuario;
import com.projeto.clean.architecture.app_clean_architecture.application.usecases.ExcluirUsuario;
import com.projeto.clean.architecture.app_clean_architecture.application.usecases.ListarUsuarios;
import com.projeto.clean.architecture.app_clean_architecture.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final AlterarUsuario alterarUsuario;
    private final ExcluirUsuario excluirUsuario;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios, AlterarUsuario alterarUsuario, ExcluirUsuario excluirUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.alterarUsuario = alterarUsuario;
        this.excluirUsuario = excluirUsuario;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto usuarioDto){
       Usuario salvo = criarUsuario.cadastrarUsuario(
                new Usuario(usuarioDto.cpf(), usuarioDto.nome(), usuarioDto.nascimento(), usuarioDto.email()));
       return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios(){
        return listarUsuarios.obterTodosUsuarios().stream()
                .map(usuario -> new UsuarioDto(usuario.getNome(), usuario.getCpf(), usuario.getNascimento(), usuario.getEmail()))
                .collect(Collectors.toList());
    }

    @PutMapping("/{cpf}")
    public UsuarioDto atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDto usuarioDto){
        Usuario usuarioAtualizado = alterarUsuario.alteraDadosUsuario(cpf, new Usuario(usuarioDto.cpf(), usuarioDto.nome(), usuarioDto.nascimento(), usuarioDto.email()));
        return new UsuarioDto(usuarioAtualizado.getCpf(), usuarioAtualizado.getNome(), usuarioAtualizado.getNascimento(), usuarioAtualizado.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void excluirUsuario(@PathVariable String cpf){
        excluirUsuario.excluirUsuario(cpf);
    }
}
