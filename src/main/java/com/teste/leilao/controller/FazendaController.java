package com.teste.leilao.controller;

import java.util.List;


import com.teste.leilao.Mensagem;
import com.teste.leilao.biz.FazendaBiz;
import com.teste.leilao.entities.Fazenda;
import com.teste.leilao.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.leilao.repositories.FazendaRepository;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("fazenda")
public class FazendaController {


    @Autowired
    private FazendaRepository fazendaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;
  

    @GetMapping("listar")
    public List<Fazenda> listar(){

        List<Fazenda> lista = fazendaRepository.findAll();
        return lista;

    }

    @PostMapping("incluir")
    public Mensagem salvar(@RequestBody Fazenda fazenda ) {

        fazenda.setIdFazenda(0);
        FazendaBiz fazendaBiz = new FazendaBiz(pessoaRepository);

        try {

            if (fazendaBiz.Validade(fazenda)) {
                this.fazendaRepository.save(fazenda);
                this.fazendaRepository.flush();
            } else {
                return fazendaBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> fazendaBiz.msg.mensagens.add(v.getMessage()));
            return fazendaBiz.msg;
        }

        return fazendaBiz.msg;

    }

}

