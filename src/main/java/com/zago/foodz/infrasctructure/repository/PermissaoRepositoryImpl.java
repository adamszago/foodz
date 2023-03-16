package com.zago.foodz.infrasctructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zago.foodz.domain.model.Permissao;
import com.zago.foodz.domain.repository.PermissaoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Permissao> todasPermissoes(){
		TypedQuery<Permissao> query =  manager.createQuery("from Permissao", Permissao.class);
		return query.getResultList();
	}
	
	@Transactional
	public Permissao adicionar(Permissao permissao) {
		return manager.merge(permissao);
	}
	
	public Permissao porId(Long id) {
		return manager.find(Permissao.class, id);
	}

	@Transactional
	public void remover(Permissao permissao) {
		permissao = porId(permissao.getId());
		manager.remove(permissao);
	}

}
