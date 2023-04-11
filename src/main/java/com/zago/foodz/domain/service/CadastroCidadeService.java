package com.zago.foodz.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.zago.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.zago.foodz.domain.model.Cidade;
import com.zago.foodz.domain.model.Estado;
import com.zago.foodz.domain.repository.CidadeRepository;
import com.zago.foodz.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository repository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Optional<Estado> estado =  estadoRepository.findById(estadoId);
		if (estado.isEmpty()) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com o id %d", estadoId));
		}
		
		cidade.setEstado(estado.get());
		return repository.save(cidade);
	}
	
	public void remover(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException emptyDataAccess) {
			throw new EntidadeNaoEncontradaException (
					String.format("A Cidade de id %d não existe", id)); 
		} 
	}
	
}
