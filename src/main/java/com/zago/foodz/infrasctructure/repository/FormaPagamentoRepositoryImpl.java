package com.zago.foodz.infrasctructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zago.foodz.domain.model.FormaPagamento;
import com.zago.foodz.domain.repository.FormaPagamentoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaPagamento> todasFormasPagamento() {
		TypedQuery<FormaPagamento> query =  manager.createQuery("from FormaPagamento", FormaPagamento.class);
		return query.getResultList();
	}

	@Override
	public FormaPagamento porId(Long id) {
		return manager.find(FormaPagamento.class, id);
	}

	@Override
	public FormaPagamento adicionar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}

	@Override
	public void remover(FormaPagamento formaPagamento) {
		manager.remove(formaPagamento);

	}

}
