package com.teste.leilao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idvenda")
	private Integer idVenda;
	
	@Column(name="idcomprador", nullable = false)
	private Integer idcomprador;
	
	@Column(name="idvendedor", nullable = false)
	private Integer idvendedor;
	
	@Column(name="idanimal", nullable = false)
	private Integer idanimal;

	public Integer getId() {
		return idVenda;
	}

	public void setId(Integer id) {
		this.idVenda = id;
	}

	public Integer getIdcomprador() {
		return idcomprador;
	}

	public void setIdcomprador(Integer idcomprador) {
		this.idcomprador = idcomprador;
	}

	public Integer getIdvendedor() {
		return idvendedor;
	}

	public void setIdvendedor(Integer idvendedor) {
		this.idvendedor = idvendedor;
	}

	public Integer getIdanimal() {
		return idanimal;
	}

	public void setIdanimal(Integer idanimal) {
		this.idanimal = idanimal;
	}
	
}
