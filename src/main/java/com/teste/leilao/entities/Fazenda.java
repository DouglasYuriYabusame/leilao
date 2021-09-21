package com.teste.leilao.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="fazenda")
public class Fazenda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idfazenda")
	private Integer idFazenda;
	
	@Column(name="nome", nullable = false)
	@Pattern(regexp="[A-z]{1,50}", message="O nome deve ter no minimo 1 caracter e no maximo 50!!")
	private String nome;
		
	@Column(name="idpessoa", nullable = false)
	private Integer idPessoa;

	public Integer getIdFazenda() {
		return idFazenda;
	}

	public void setIdFazenda(Integer idFazenda) {
		this.idFazenda = idFazenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
}