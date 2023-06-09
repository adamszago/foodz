package com.zago.foodz.api.controller;

import com.zago.foodz.domain.model.Cidade;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

	@Column(name="endereco_cep")
	private String cep;
	
	@Column(name="endereco_logradouro")
	private String logradouro;
	
	@Column(name="endereco_numero")
	private String numero;
	
	@Column(name="endereco_complemento")
	private String complemento;
	
	@ManyToOne
	@JoinColumn(name = "endereco_cidade_id")
	private Cidade cidade;
	
	
}
