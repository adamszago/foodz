package com.zago.foodz.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zago.foodz.domain.exception.EntidadeEmUsoException;
import com.zago.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.zago.foodz.domain.model.Estado;
import com.zago.foodz.domain.repository.EstadoRepository;
import com.zago.foodz.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CadastroEstadoService estadoService;
	
	@GetMapping
	public List<Estado> listar(){
		return estadoRepository.todosEstados();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> porId(@PathVariable Long id) {
		Estado estado = estadoRepository.porId(id);
		if (estado != null) {
			return ResponseEntity.ok(estado);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado salvar(@RequestBody Estado estado) {
		return estadoService.salvar(estado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long id
			, @RequestBody Estado estado) {
		Estado estadoAtual = estadoRepository.porId(id);
		if (estadoAtual != null) {
			BeanUtils.copyProperties(estado, estadoAtual, "id"); //Faz o mesmo que cozinhaAtual.setNome(cozinha.getNome());
			estadoService.salvar(estadoAtual);
			return ResponseEntity.ok(estadoAtual);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Estado> remover(@PathVariable Long id) {
		try {
			estadoService.remover(id);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} 
		
	}
}