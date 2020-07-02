package com.zefuinha.json.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.json.dominio.Produto;

@Configuration
public class ArquivoJsonStepConfig {

	@Autowired
	private StepBuilderFactory step;
	
	@Bean
	public Step ArquivoJsonStep(JsonItemReader<Produto> reader, ItemWriter<Produto> writer) {
		return step
				.get("ArquivoJsonStep")
				.<Produto, Produto>chunk(1)
				.writer(writer)
				.reader(reader)
				.build();
	}
	
}
