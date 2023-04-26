package com.zago.foodz.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zago.foodz.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>
												, RestauranteRepositoryQueries
												, JpaSpecificationExecutor<Restaurante> {

	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	@Query("from Restaurante r join fetch r.cozinha")
	List<Restaurante> findAll();
	
	@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> buscarPorNomeECozinha(String nome, @Param("id")Long cozinhaId);
	
	
	
}
