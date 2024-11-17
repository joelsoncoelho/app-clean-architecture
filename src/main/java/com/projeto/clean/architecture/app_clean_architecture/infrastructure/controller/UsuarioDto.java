package com.projeto.clean.architecture.app_clean_architecture.infrastructure.controller;

import java.time.LocalDate;

public record UsuarioDto(String nome, String cpf, LocalDate nascimento, String email) { }
