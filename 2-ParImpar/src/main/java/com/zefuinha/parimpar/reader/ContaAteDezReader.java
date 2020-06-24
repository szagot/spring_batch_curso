package com.zefuinha.parimpar.reader;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContaAteDezReader {
	/**
	 * Leitor
	 * 
	 * Usando o Iterator pronto para o ItemReader do proprio spring batch
	 * 
	 * @return
	 */
	@Bean
	public IteratorItemReader<Integer> contaDezReader() {
		// Criando lista para facilitar o exemplo
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Retornando o iterator da lista
		return new IteratorItemReader<Integer>(numeros.iterator());
	}
}
