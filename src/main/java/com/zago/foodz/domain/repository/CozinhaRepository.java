package com.zago.foodz.domain.repository;

import java.util.List;

import com.zago.foodz.domain.model.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> todas();
	Cozinha porId(Long id);
	Cozinha adicionar(Cozinha cozinha);
	void remover(Long id);
	

}
