package com.teste.leilao.repositories;

import com.teste.leilao.entities.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Integer> {

}
