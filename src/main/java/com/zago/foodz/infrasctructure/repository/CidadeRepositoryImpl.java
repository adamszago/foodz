package com.zago.foodz.infrasctructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.zago.foodz.domain.model.Cidade;
import com.zago.foodz.domain.repository.CidadeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class CidadeRepositoryImpl implements CidadeRepository{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Cidade> todasCidades(){
		TypedQuery<Cidade> query =  manager.createQuery("from Cidade", Cidade.class);
		return query.getResultList();
	}
	
	@Transactional
	public Cidade adicionar(Cidade cidade) {
		return manager.merge(cidade);
	}
	
	public Cidade porId(Long id) {
		return manager.find(Cidade.class, id);
	}

	@Transactional
	public void remover(Long id) {
		Cidade cidade = porId(id);
		if (cidade == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(cidade);
	}

}
