package com.teste.leilao.repositories;

import com.teste.leilao.entities.MedicoVeterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.leilao.entities.MedicoVeterinario;

@Repository
public interface MedicoVeterinarioRepository extends JpaRepository<MedicoVeterinario,Integer> {

}
