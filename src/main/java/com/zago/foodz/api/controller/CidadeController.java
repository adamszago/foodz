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

import com.zago.foodz.domain.exception.EntidadeNaoEncontradaException;
import com.zago.foodz.domain.model.Cidade;
import com.zago.foodz.domain.repository.CidadeRepository;
import com.zago.foodz.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private CadastroCidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> listar(){
		return cidadeRepository.todasCidades();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> porId(@PathVariable Long id) {
		Cidade cidade = cidadeRepository.porId(id);
		if (cidade != null) {
			return ResponseEntity.ok(cidade);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
		try {
			cidade =  cidadeService.salvar(cidade); 
			
			return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id
			, @RequestBody Cidade cidade) {
		try {
			Cidade cidadeAtual = cidadeRepository.porId(id);
			if (cidadeAtual != null) {
				BeanUtils.copyProperties(cidade, cidadeAtual, "id"); //Faz o mesmo que cozinhaAtual.setNome(cozinha.getNome());
				cidadeService.salvar(cidadeAtual);
				return ResponseEntity.ok(cidadeAtual);
			}
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cidade> remover(@PathVariable Long id) {
		try {
			cidadeService.remover(id);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} 
	}
}
