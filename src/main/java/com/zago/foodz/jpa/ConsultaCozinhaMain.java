package com.zago.foodz.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.zago.foodz.FoodzApplication;
import com.zago.foodz.domain.model.Cozinha;
import com.zago.foodz.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {

		ApplicationContext context = new SpringApplicationBuilder(FoodzApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cadCozinha = context.getBean(CozinhaRepository.class);
		
		List<Cozinha> cozinhas = cadCozinha.todas();
		for (Cozinha cozinha : cozinhas) {
			System.out.println(cozinha.getNome());
		}
		
		
		
	}

}
