package com.teste.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.leilao.entities.Venda;



public interface VendaRepository extends JpaRepository<Venda, Integer> {

}
