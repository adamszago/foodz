package com.zago.foodz.infrasctructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zago.foodz.domain.model.Estado;
import com.zago.foodz.domain.repository.EstadoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Estado> todosEstados(){
		TypedQuery<Estado> query =  manager.createQuery("from Estado", Estado.class);
		return query.getResultList();
	}
	
	@Transactional
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}
	
	public Estado porId(Long id) {
		return manager.find(Estado.class, id);
	}

	@Transactional
	public void remover(Estado estado) {
		estado = porId(estado.getId());
		manager.remove(estado);
	}

}
