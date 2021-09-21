package com.teste.leilao.biz;

import com.teste.leilao.Mensagem;
import com.teste.leilao.entities.Leilao;

import javax.validation.Valid;

public class LeilaoBiz {

    public Mensagem msg;

    public LeilaoBiz(){
        msg = new Mensagem();
    }

    public Boolean Leiloada(@Valid Leilao leilao) {

        Boolean result = true;
        msg = new Mensagem();

        if (leilao.getNome().isEmpty()) {
            msg.mensagens.add("O nome não pode ser vazio");
            result = false;

            if (leilao.getNome().length() < 5) {
                msg.mensagens.add("O nome não pode ter menos que 5 caracteres ");
                result = false;
            }

        }
        return result;
    }
}
