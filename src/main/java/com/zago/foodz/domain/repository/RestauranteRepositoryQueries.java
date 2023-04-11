package com.zago.foodz.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.zago.foodz.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	public List<Restaurante> find(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

	public List<Restaurante> findComFreteGratis(String nome);
}
