package com.teste.leilao.controller;

import com.teste.leilao.Mensagem;
import com.teste.leilao.biz.PessoaBiz;
import com.teste.leilao.entities.Pessoa;
import com.teste.leilao.repositories.PessoaRepository;
import com.teste.leilao.repositories.TipoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TipoPessoaRepository tipoPessoaRepository;

    @GetMapping
    @RequestMapping("listar")
    public List<Pessoa> Get() {
        return pessoaRepository.findAll();
    }


    @PostMapping
    @RequestMapping("incluir")
    public Mensagem add(@RequestBody Pessoa pessoa) {
        PessoaBiz pessoaBiz = new PessoaBiz(tipoPessoaRepository);
        pessoa.setIdPessoa(0);

        try {

            if (pessoaBiz.Validade(pessoa)) {
                this.pessoaRepository.save(pessoa);
                this.pessoaRepository.flush();
            } else {
                return PessoaBiz.msg;
            }
        } catch (Exception e) {
            PessoaBiz.msg.mensagens.add(e.getMessage());
            return PessoaBiz.msg;
        }

        return PessoaBiz.msg;


    }
}
