package com.teste.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.teste.leilao.entities.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
