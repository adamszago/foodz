package com.zago.foodz.domain.repository;

import java.util.List;

import com.zago.foodz.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> todosEstados();
	Estado porId(Long id);
	Estado adicionar(Estado estado);
	void remover(Long id);
	

}
