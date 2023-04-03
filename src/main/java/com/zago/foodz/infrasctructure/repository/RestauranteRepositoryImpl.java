package com.zago.foodz.infrasctructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.zago.foodz.domain.model.Restaurante;
import com.zago.foodz.domain.repository.RestauranteRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Restaurante> todas(){
		TypedQuery<Restaurante> query =  manager.createQuery("from Restaurante", Restaurante.class);
		return query.getResultList();
	}
	
	@Transactional
	public Restaurante adicionar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
	
	public Restaurante porId(Long id) {
		return manager.find(Restaurante.class, id);
	}

	@Transactional
	public void remover(Long id) {
		Restaurante restaurante = porId(id);
		if (restaurante == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(restaurante);
	}
	

}
