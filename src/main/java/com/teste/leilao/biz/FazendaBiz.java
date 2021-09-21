package com.teste.leilao.biz;

import com.teste.leilao.Mensagem;
import com.teste.leilao.entities.Fazenda;
import com.teste.leilao.repositories.PessoaRepository;

import javax.validation.*;

import java.util.Set;

public class FazendaBiz {
    public Mensagem msg;

    private PessoaRepository pessoaRepository;
 
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    public FazendaBiz(PessoaRepository pessoaRepository) {
        msg = new Mensagem();
        this.pessoaRepository = pessoaRepository;
    }

    public Boolean Validade(Fazenda fazenda) {

        Set<ConstraintViolation<Fazenda>> constraintViolationSet = validator.validate(fazenda);

        Boolean result = true;
        if (fazenda.getNome().isEmpty()) {
            msg.mensagens.add("O nome da fazenda não pode ser vazio");
            result = false;
        }
        if (fazenda.getNome().startsWith("PP")) {
            msg.mensagens.add("O nome da fazenda é inválido");
            result = false;
        }
        if (pessoaRepository.findById(fazenda.getIdPessoa()).isEmpty()) {
            msg.mensagens.add("Id inexistente");
            result = false;
        }      
        if(!constraintViolationSet.isEmpty()){
            ConstraintViolationException exceptionConstraint = new ConstraintViolationException(constraintViolationSet);
            msg.mensagens.add(exceptionConstraint.getMessage());
            result = false;
        }
        if(result == true){
            msg.mensagens.add("OK");
        }


        return result;

    }

}
