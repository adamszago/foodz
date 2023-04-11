package com.zago.foodz.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zago.foodz.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long>{
	
	List<Cozinha> findByNome(String nome);
}
