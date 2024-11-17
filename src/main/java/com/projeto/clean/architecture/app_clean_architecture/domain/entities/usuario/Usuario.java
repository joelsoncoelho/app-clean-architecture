package com.projeto.clean.architecture.app_clean_architecture.domain.entities.usuario;

import com.projeto.clean.architecture.app_clean_architecture.domain.Endereco;
import com.projeto.clean.architecture.app_clean_architecture.util.ValidarData;
import com.projeto.clean.architecture.app_clean_architecture.util.ValidarEmail;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class Usuario {

    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    private Endereco endereco;

    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        if(cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            throw new IllegalArgumentException("Cpf no padrão errado.");
        }
        /*
       if(nome == null || !nome.matches("[A-Z][a-z]{1,}")){
            throw new IllegalArgumentException("Nome é inválido.");
        }
    */
        if(nascimento == null || !ValidarData.isValidDataNascimento(nascimento.toString())){
            throw new DateTimeParseException("abcd", nascimento != null ? nascimento.toString() : null, 8);
        }

        // Calcula a idadeDoUsuario com base na data de nascimento e a data atual
        int idadeDoUsuario = Period.between(nascimento, LocalDate.now()).getYears();
        if(idadeDoUsuario < 18){
            throw new IllegalArgumentException("Usuário deve ter pelo menos 18 anos de idade!");
        }

        if( email == null || !ValidarEmail.emailValido(email) && !email.isEmpty()){
            throw new IllegalArgumentException("E-mail inválido.");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}