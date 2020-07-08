package com.zefuinha.jdbpaging.chunk;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.jdbpaging.dominio.Cliente;

@Configuration
public class JdbcPagingReaderConfig {

	@Bean
	public JdbcPagingItemReader<Cliente> jdbcPagingReader() {
		return null;
	}
	
}
