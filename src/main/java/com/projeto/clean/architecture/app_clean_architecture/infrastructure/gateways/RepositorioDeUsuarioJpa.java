package com.projeto.clean.architecture.app_clean_architecture.infrastructure.gateways;



import com.projeto.clean.architecture.app_clean_architecture.application.gateways.RepositorioDeUsuario;
import com.projeto.clean.architecture.app_clean_architecture.domain.entities.usuario.Usuario;
import com.projeto.clean.architecture.app_clean_architecture.infrastructure.persistence.UsuarioEntity;
import com.projeto.clean.architecture.app_clean_architecture.infrastructure.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repository;
    private final UsuarioEntityMapper usuarioEntityMapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper usuarioEntityMapper) {
        this.repository = repository;
        this.usuarioEntityMapper = usuarioEntityMapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = usuarioEntityMapper.toEntity(usuario);
        repository.save(entity);
        return usuarioEntityMapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll().stream()
                .map(usuarioEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario alterarUsuario(String cpf, Usuario usuario) {
        UsuarioEntity usuarioEntity = repository.findByCpf(cpf);
        if(usuarioEntity != null){
            var usuarioAtualzado = usuarioEntityMapper.toEntity(usuario);
            usuarioAtualzado.setId(usuarioEntity.getId());
            repository.save(usuarioAtualzado);
            return usuarioEntityMapper.toDomain(usuarioAtualzado);
        }
        return null;
    }

    @Override
    public void excluirUsuario(String cpf) {
        UsuarioEntity usuarioEntity = repository.findByCpf(cpf);
        repository.deleteById(usuarioEntity.getId());
    }
}
