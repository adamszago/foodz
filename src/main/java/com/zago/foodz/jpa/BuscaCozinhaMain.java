package com.zago.foodz.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.zago.foodz.FoodzApplication;
import com.zago.foodz.domain.model.Cozinha;
import com.zago.foodz.domain.repository.CozinhaRepository;

public class BuscaCozinhaMain {

	public static void main(String[] args) {

		ApplicationContext context = new SpringApplicationBuilder(FoodzApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cadCozinha = context.getBean(CozinhaRepository.class);
		
		Cozinha c1 = cadCozinha.porId(2L);
		System.out.println(c1.getNome());
		
		
	}

}
