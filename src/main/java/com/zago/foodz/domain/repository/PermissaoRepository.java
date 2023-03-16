package com.zago.foodz.domain.repository;

import java.util.List;

import com.zago.foodz.domain.model.Permissao;

public interface PermissaoRepository {
	
	List<Permissao> todasPermissoes();
	Permissao porId(Long id);
	Permissao adicionar(Permissao permissao);
	void remover(Permissao permissao);
	

}
