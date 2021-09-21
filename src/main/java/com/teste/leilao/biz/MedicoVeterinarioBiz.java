package com.teste.leilao.biz;


import com.teste.leilao.Mensagem;
import com.teste.leilao.entities.MedicoVeterinario;

public class MedicoVeterinarioBiz {

    public Mensagem msg;

    public MedicoVeterinarioBiz() {
        msg = new Mensagem();
    }

    public Boolean Validade(MedicoVeterinario medicoveterinario) {

        boolean result = true;
        if (medicoveterinario.getNome().isEmpty()) {
            msg.mensagens.add("O nome do Médico não pode ser vazio");
            result = false;
        }
        if (medicoveterinario.getNome().startsWith("PP")) {
            msg.mensagens.add("O nome do médico é inválido");
            result = false;
        }

        return result;

    }

}
