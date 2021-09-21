package com.teste.leilao.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicoveterinario")
public class MedicoVeterinario {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name= "idmedicoveterinario")
	private Integer idmedicoveterinario;
	
	@Column(name= "nome")
	private String nome;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "telefone")
	private String telefone;

	public Integer getIdmedicoveterinario() {
		return idmedicoveterinario;
	}

	public void setIdmedicoveterinario(Integer idmedicoveterinario) {
		this.idmedicoveterinario = idmedicoveterinario;
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

	
}
