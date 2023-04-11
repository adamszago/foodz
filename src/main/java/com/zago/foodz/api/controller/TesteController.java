package com.zago.foodz.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zago.foodz.domain.model.Restaurante;
import com.zago.foodz.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("/restaurantes/por-nome")
	public List<Restaurante> listarPorNomeETaxas(String nome
			, BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.find(nome, taxaInicial, taxaFinal);
	}
	
	@GetMapping("/restaurantes/por-criteria")
	public List<Restaurante> listarPorNomeETaxasCriteria(String nome
			, BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.find(nome, taxaInicial, taxaFinal);
	}
	
	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratisPorNome(String nome) {
		return restauranteRepository
				.findComFreteGratis(nome);
	}
	
	@GetMapping("/restaurantes/buscar-primeiro")
	public Optional<Restaurante> restaurantesPrimeiro() {
		return restauranteRepository
				.buscarPrimeiro();
	}
}
