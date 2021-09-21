package com.teste.leilao;

import java.util.ArrayList;
import java.util.List;

public class Mensagem {
	
	public List<String> mensagens;

	public Mensagem() {
		mensagens = new ArrayList<>();
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}
}
