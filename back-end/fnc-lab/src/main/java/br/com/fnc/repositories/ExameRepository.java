package br.com.fnc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fnc.domain.Exame;



@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer>{
	
	
}
