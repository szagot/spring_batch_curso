package com.zefuinha.jdbpaging.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.jdbpaging.dominio.Cliente;

@Configuration
public class JdbcPagingChunkConfig {

	@Autowired
	private StepBuilderFactory step;
	
	@Bean
	public Step jdbcPagingChunk(JdbcPagingItemReader<Cliente> reader, ItemWriter<Cliente> writer) {
		return step
				.get("jdbcPagingChunk")
				.<Cliente,Cliente>chunk(1)
				.reader(reader)
				.writer(writer)
				.build();
				
				
				
	}
	
}
