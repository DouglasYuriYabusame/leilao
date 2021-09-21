package com.teste.leilao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name="leilao")
public class Leilao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idleilao")
    private int idLeilao;

    @Column(name = "nome",nullable = false)
    @Pattern(regexp = "[A-z].*[A-z].*", message = "O nome é invalido!")
    private String Nome;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(int idLeilao) {
        this.idLeilao = idLeilao;
    }




}
