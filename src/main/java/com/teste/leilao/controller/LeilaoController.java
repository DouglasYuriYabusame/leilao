package com.teste.leilao.controller;

import com.teste.leilao.Mensagem;
import com.teste.leilao.biz.LeilaoBiz;
import com.teste.leilao.entities.Leilao;
import com.teste.leilao.repositories.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("leilao")
public class LeilaoController {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @GetMapping("listar")
    public List<Leilao> listar() {
        List<Leilao> lista = leilaoRepository.findAll();
        return lista;
    }

    @PostMapping("incluir")
    public Mensagem salvar(@RequestBody Leilao leilao) {
        leilao.setIdLeilao(0);

        LeilaoBiz leilaoBiz = new LeilaoBiz();

        try {
            if (leilaoBiz.Leiloada(leilao)) {
                this.leilaoRepository.save(leilao);
                this.leilaoRepository.flush();
            } else {
                return leilaoBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> leilaoBiz.msg.mensagens.add(v.getMessage()));
            return leilaoBiz.msg;
        }
        leilaoBiz.msg.mensagens.add("OK");

        return leilaoBiz.msg;

    }
}