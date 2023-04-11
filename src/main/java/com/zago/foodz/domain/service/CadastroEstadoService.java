package com.zago.foodz.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.zago.foodz.domain.exception.EntidadeEmUsoException;
import com.zago.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.zago.foodz.domain.model.Estado;
import com.zago.foodz.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void remover(Long id) {
		try {
			estadoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException emptyDataAccess) {
			throw new EntidadeNaoEncontradaException (
					String.format("O estado de id %d não existe", id)); 
		} catch (DataIntegrityViolationException dataIntegrityException) {
			throw new EntidadeEmUsoException(
					String.format("Estado de código %d está em uso e não pode ser removido", id));
		} 
		
	}
}
