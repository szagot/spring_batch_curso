package com.zefuinha.json.step.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.zefuinha.json.dominio.Produto;

@Configuration
public class ArquivoJsonReaderConfig {

	@Bean
	@StepScope
	public JsonItemReader<Produto> ArquivoJsonReader(@Value("#{jobParameters['json']}") String path) {
		return new JsonItemReaderBuilder<Produto>()
				.name("ArquivoJsonReader")
				.jsonObjectReader(new JacksonJsonObjectReader<>(Produto.class))
				// https://docs.spring.io/spring-batch/docs/current/reference/html/index-single.html#jsonReadingWriting
				// Usando FileSystemResource ao invés de ClassPathResource porque o arquivonão está na raiz do projeto
				.resource(new FileSystemResource(path))
				.build();
	}
	
}
