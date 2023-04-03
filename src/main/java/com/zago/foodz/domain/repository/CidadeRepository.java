package com.zago.foodz.domain.repository;

import java.util.List;

import com.zago.foodz.domain.model.Cidade;

public interface CidadeRepository {
	
	List<Cidade> todasCidades();
	Cidade porId(Long id);
	Cidade adicionar(Cidade cidade);
	void remover(Long id);
	

}
