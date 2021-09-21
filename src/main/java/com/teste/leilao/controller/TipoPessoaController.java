package com.teste.leilao.controller;

import com.teste.leilao.Mensagem;
import com.teste.leilao.biz.TipoPessoaBiz;
import com.teste.leilao.entities.TipoPessoa;
import com.teste.leilao.repositories.TipoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("tipopessoa")
public class TipoPessoaController {

    @Autowired
    private TipoPessoaRepository tipoPessoaRepository;

    @GetMapping("listar")
    public List<TipoPessoa> listar(){
        List<TipoPessoa> lista = tipoPessoaRepository.findAll();
        return lista;
    }

    @PostMapping("incluir")
    public Mensagem salvar(@RequestBody TipoPessoa tipoPessoa){
        tipoPessoa.setIdTipoPessoa(0);
        TipoPessoaBiz tipoPessoaBiz = new TipoPessoaBiz();

        try {
            if(tipoPessoaBiz.Leiloada(tipoPessoa)){
                this.tipoPessoaRepository.save(tipoPessoa);
                this.tipoPessoaRepository.flush();
            }else{
                return tipoPessoaBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> tipoPessoaBiz.msg.mensagens.add(v.getMessage()));
            return tipoPessoaBiz.msg;
        }
        tipoPessoaBiz.msg.mensagens.add("OK");
        return tipoPessoaBiz.msg;
    }
}
