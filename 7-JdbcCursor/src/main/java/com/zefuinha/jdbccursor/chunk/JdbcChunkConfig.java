package com.zefuinha.jdbccursor.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.jdbccursor.dominio.Cliente;

@Configuration
public class JdbcChunkConfig {

	@Autowired
	private StepBuilderFactory step;
	
	@Bean
	public Step jdbcStep(JdbcCursorItemReader<Cliente> reader, ItemWriter<Cliente> writer) {
		return step
				.get("jdbcStep")
				.<Cliente, Cliente>chunk(1)
				.reader(reader)
				.writer(writer)
				.build();
	}
	
}
