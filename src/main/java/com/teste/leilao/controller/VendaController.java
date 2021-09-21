package com.teste.leilao.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.leilao.Mensagem;
import com.teste.leilao.biz.VendaBiz;
import com.teste.leilao.entities.Venda;
import com.teste.leilao.repositories.AnimalRepository;
import com.teste.leilao.repositories.PessoaRepository;
import com.teste.leilao.repositories.VendaRepository;





@RestController
@RequestMapping("venda")
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepositorio;
	
	@Autowired
	private PessoaRepository pessoaRepositorio;
	
	@Autowired 
	private AnimalRepository animalRepositorio;
	
	@GetMapping("listar")
	public List<Venda> listar(){
		
		List<Venda> lista = vendaRepositorio.findAll();
		return lista;
		
	}
	
	@PostMapping("incluir")
	public Mensagem salvar(@Valid @RequestBody Venda venda ) {
		
		VendaBiz vendaBiz = new VendaBiz(pessoaRepositorio,animalRepositorio);
		
		try {
            if(vendaBiz.Validade(venda)){
                this.vendaRepositorio.save(venda);
                this.vendaRepositorio.flush();
            }else{
                return vendaBiz.msg;
            }
		}catch (ConstraintViolationException e) {
			e.getConstraintViolations().forEach(v -> vendaBiz.msg.mensagens.add(v.getMessage()));
			return vendaBiz.msg;
		}
		vendaBiz.msg.mensagens.add("OK");
        return vendaBiz.msg;
	
	}
}
