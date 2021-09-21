package com.teste.leilao.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tipopessoa")
public class TipoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipopessoa")
    private int idTipoPessoa;

    @Column(name="tipopessoa", nullable = false)
    @Pattern(regexp="[A-z]{10,50}", message="O nome deve ter entre 10 e 50 caracteres")
    private String TipoPessoa;

    public int getIdTipoPessoa() {
        return idTipoPessoa;
    }

    public void setIdTipoPessoa(int idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }

    public String getTipoPessoa() {
        return TipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        TipoPessoa = tipoPessoa;
    }
}
