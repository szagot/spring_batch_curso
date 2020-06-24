package com.zefuinha.parimpar;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory job;

	@Autowired
	private StepBuilderFactory step;

	@Bean
	public Job imprimeParImpar() {

		return job.get("imprimeParImpar").start(imprimeParImparStep()).incrementer(new RunIdIncrementer()).build();

	}

	private Step imprimeParImparStep() {
		return step
				// Nome do Step
				.get("imprimeParImparStep")
				// Tipo Chunk: <Leitura, Escrita>chunk(tamanho)
				.<Integer, String>chunk(1)
				// Leitor
				.reader(contaAteDezReader())
				// Processador
				.processor(parOuImparProcessor())
				// Escritor
				.writer(imprimeWriter())
				// Constroi o Step
				.build();
	}

	/**
	 * Leitor
	 * 
	 * Usando o Iterator pronto para o ItemReader do proprio spring batch
	 * 
	 * @return
	 */
	private IteratorItemReader<Integer> contaAteDezReader() {
		// Criando lista para facilitar o exemplo
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Retornando o iterator da lista
		return new IteratorItemReader<Integer>(numeros.iterator());
	}

	/**
	 * Processador
	 *
	 * Usando a function pronta para o processadopr do proprio spring batch
	 * 
	 * @return
	 */
	private FunctionItemProcessor<Integer, String> parOuImparProcessor() {
		return new FunctionItemProcessor<Integer, String>
		// Para cada item lido no Iterator do Leitor, é Par ou impar?
		(item -> (item % 2 == 0) ? String.format("Item %s é Par", item) : String.format("Item %s é Ímpar", item));
	}

	/**
	 * Escritor
	 * 
	 * @return
	 */
	private ItemWriter<String> imprimeWriter() {
		// Para cada item processado, faz a impressão do mesmo
		return itens -> itens.forEach(System.out::println);
	}

}
