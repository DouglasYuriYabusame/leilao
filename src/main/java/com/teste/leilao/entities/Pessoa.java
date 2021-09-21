package com.teste.leilao.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Pessoa {
    @Id
    @Column(name="idpessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPessoa;

    @Column(name = "nome", nullable = false)
    @Pattern(regexp = "^[A-z]{1,50}$", message = "Nome Invalido")
    private String nome;
    @Column(name = "Email")
    @Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "Email Invalido")
    private String email;

    @Column(name = "Telefone")
    private String telefone;

    @Column(name = "idtipopessoa")
    private int idtipopessoa;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdtipopessoa() {
        return idtipopessoa;
    }

    public void setIdtipopessoa(int idtipopessoa) {
        this.idtipopessoa = idtipopessoa;
    }
}
