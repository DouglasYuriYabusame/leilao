package com.teste.leilao.biz;

import org.springframework.beans.factory.annotation.Autowired;

import com.teste.leilao.Mensagem;
import com.teste.leilao.entities.Venda;
import com.teste.leilao.repositories.AnimalRepository;
import com.teste.leilao.repositories.PessoaRepository;
public class VendaBiz {
	
	public Mensagem msg;
	
	@Autowired
	public PessoaRepository pessoaRepositorio;
	
	@Autowired
	public AnimalRepository animalRepositorio;
	
	public VendaBiz(PessoaRepository pessoaRepo, AnimalRepository animalRepo) {
		this.pessoaRepositorio = pessoaRepo;
		this.animalRepositorio = animalRepo;
		msg = new Mensagem();
	}
	
	public Boolean Validade (Venda venda) {
		
		boolean result = true;
		msg = new Mensagem();
	
	if (pessoaRepositorio.findById( venda.getIdcomprador()).isEmpty()) {
   	 msg.mensagens.add("A pessoa escolhida nao é valida");
   	 result = false;
    }
	
	if (pessoaRepositorio.findById( venda.getIdvendedor()).isEmpty()) {
	   	 msg.mensagens.add("A pessoa escolhida nao é valida");
	   	 result = false;
	    }
	
	if (animalRepositorio.findById( venda.getIdanimal()).isEmpty()) {
   	 msg.mensagens.add("O animal escolhido nao é valido");
   	 result = false;
    }
	
	return result;
		
	}	
	
	public Mensagem getMsg() {
		return msg;
	}
	
	public PessoaRepository getPessoaRepositorio() {
		return pessoaRepositorio;
	}

	public void setPessoaRepositorio(PessoaRepository pessoaRepositorio) {
		this.pessoaRepositorio = pessoaRepositorio;
	}
	
	public AnimalRepository getAnimalRepositorio() {
		return animalRepositorio;
	}

	public void setAnimalRepositorio(AnimalRepository animalRepositorio) {
		this.animalRepositorio = animalRepositorio;
	}
	

}
