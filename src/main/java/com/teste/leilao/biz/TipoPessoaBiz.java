package com.teste.leilao.biz;

import com.teste.leilao.Mensagem;
import com.teste.leilao.entities.TipoPessoa;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

public class TipoPessoaBiz {

    public Mensagem msg;

    public Boolean Leiloada(@Valid TipoPessoa tipopessoa){
        boolean result = true;
        msg = new Mensagem();

        if(tipopessoa.getTipoPessoa().isEmpty()){
            msg.mensagens.add("O tipo pessoa não pode ser vazio");
            result = false;
        }
        if(tipopessoa.getTipoPessoa().length() < 5){
            msg.mensagens.add("O TipoPessoa deve conter mais que cinco caracteres");
            result = false;
        }
        return result;
    }
}
