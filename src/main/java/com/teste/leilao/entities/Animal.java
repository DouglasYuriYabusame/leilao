package com.teste.leilao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "animal")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idanimal")
	private int idAnimal;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "descricao", nullable = false, length = 50)
	private String descricao;

	@Column(name = "registro", nullable = false, length = 50)
	private String registro;

	@Min(value = 0, message = "O valor não pode ser abaixo de zero.")
	@Column(name = "preco", nullable = false, precision = 16, scale = 2)
	private Double preco;

	@Column(name = "idleilao", nullable = false)
	private Integer idLeilao;

	@Column(name = "idmedicoveterinario", nullable = false)
	private Integer idMedicoVeterinario;

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getIdLeilao() {
		return idLeilao;
	}

	public void setIdLeilao(Integer idLeilao) {
		this.idLeilao = idLeilao;
	}

	public Integer getIdMedicoVeterinario() {
		return idMedicoVeterinario;
	}

	public void setIdMedicoVeterinario(Integer idMedicoVeterinario) {
		this.idMedicoVeterinario = idMedicoVeterinario;
	}

}
