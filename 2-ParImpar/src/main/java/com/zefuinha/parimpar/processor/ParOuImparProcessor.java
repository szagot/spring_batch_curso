package com.zefuinha.parimpar.processor;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParOuImparProcessor {
	/**
	 * Processador
	 *
	 * Usando a function pronta para o processadopr do proprio spring batch
	 * 
	 * @return
	 */
	@Bean
	public FunctionItemProcessor<Integer, String> parImparProcessor() {
		return new FunctionItemProcessor<Integer, String>
		// Para cada item lido no Iterator do Leitor, é Par ou impar?
		(item -> (item % 2 == 0) ? String.format("Item %s é Par", item) : String.format("Item %s é Ímpar", item));
	}
}
