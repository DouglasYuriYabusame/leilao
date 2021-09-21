package com.teste.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teste.leilao.repositories.MedicoVeterinarioRepository;
import com.teste.leilao.Mensagem;
import com.teste.leilao.biz.AnimalBiz;
import com.teste.leilao.entities.Animal;
import com.teste.leilao.repositories.AnimalRepository;
import com.teste.leilao.repositories.LeilaoRepository;

import javax.validation.ConstraintViolationException;


@RestController
@RequestMapping("animal")
public class AnimalController {

	@Autowired
	private AnimalRepository animalRepositorio;
	
	@Autowired
	public LeilaoRepository leilaoRepositorio;
	
	@Autowired
	public MedicoVeterinarioRepository medicoVeterinarioRepositorio;
	
	@GetMapping("listar")
	public List<Animal> listar() {
	
		List<Animal> lista = animalRepositorio.findAll(); 
		return lista;
	}
	
	@PostMapping("incluir")	//rota
	public Mensagem salvar(@RequestBody Animal animal ) {
		
		animal.setIdAnimal(0);	
		AnimalBiz animalBiz = new AnimalBiz(leilaoRepositorio, medicoVeterinarioRepositorio);
		
		try {
			//validar todos os dominios e regras
		if (animalBiz.Validade(animal)) {
			this.animalRepositorio.save(animal);
			this.animalRepositorio.flush();
		} else {
			return animalBiz.msg; 	// retorna a mensagem de erro
		}
		}catch (ConstraintViolationException e) {
			e.getConstraintViolations().forEach(v -> animalBiz.msg.mensagens.add(v.getMessage()));
			return animalBiz.msg;
		}
	animalBiz.msg.mensagens.add("OK");
		
	return animalBiz.msg;
		
	}
}

