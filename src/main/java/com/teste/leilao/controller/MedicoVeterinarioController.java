package com.teste.leilao.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.leilao.Mensagem;
import com.teste.leilao.biz.MedicoVeterinarioBiz;
import com.teste.leilao.entities.MedicoVeterinario;
import com.teste.leilao.repositories.MedicoVeterinarioRepository;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("medicoveterinario")
public class MedicoVeterinarioController<AnimalRepository, Animal> {


    @Autowired
    private MedicoVeterinarioRepository medicoveterinarioRepository;

  

    @GetMapping("listar")
    public List<MedicoVeterinario> listar(){

        List<MedicoVeterinario> lista = medicoveterinarioRepository.findAll();
        return lista;

    }

    @PostMapping("incluir")
    public Mensagem salvar(@RequestBody MedicoVeterinario medicoveterinario ) {

    	medicoveterinario.setIdmedicoveterinario(0);
    	MedicoVeterinarioBiz medicoveterinarioBiz = new MedicoVeterinarioBiz();

        try {

            if (medicoveterinarioBiz.Validade(medicoveterinario)) {
                this.medicoveterinarioRepository.save(medicoveterinario);
                this.medicoveterinarioRepository.flush();
            } else {
                return medicoveterinarioBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> medicoveterinarioBiz.msg.mensagens.add(v.getMessage()));
            return medicoveterinarioBiz.msg;
        }
        medicoveterinarioBiz.msg.mensagens.add("OK");

        return medicoveterinarioBiz.msg;

    }

}

