package com.zago.foodz.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.zago.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.zago.foodz.domain.model.Cozinha;
import com.zago.foodz.domain.model.Restaurante;
import com.zago.foodz.domain.repository.CozinhaRepository;
import com.zago.foodz.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository repository;
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha =  cozinhaRepository.porId(cozinhaId);
		if (cozinha == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cozinha com o id %d", cozinhaId));
		}
		
		restaurante.setCozinha(cozinha);
		return repository.adicionar(restaurante);
	}
	
	public void remover(Long id) {
		try {
			repository.remover(id);
		} catch (EmptyResultDataAccessException emptyDataAccess) {
			throw new EntidadeNaoEncontradaException (
					String.format("O Restaurante de id %d não existe", id)); 
		} 
	}
	
}
