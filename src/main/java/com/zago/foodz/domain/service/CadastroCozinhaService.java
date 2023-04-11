package com.zago.foodz.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.zago.foodz.domain.exception.EntidadeEmUsoException;
import com.zago.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.zago.foodz.domain.model.Cozinha;
import com.zago.foodz.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}
	
	public List<Cozinha> buscarPorNome(String nome) {
		return cozinhaRepository.findByNome(nome);
	}
	 
	public void remover(Long id) {
		try {
			cozinhaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException emptyDataAccess) {
			throw new EntidadeNaoEncontradaException (
					String.format("A cozinha de id %d não existe", id)); 
		} catch (DataIntegrityViolationException dataIntegrityException) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d está em uso e não pode ser removida", id));
		} 
		
	}
}
