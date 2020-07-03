package com.zefuinha.jdbccursor.chunk;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.jdbccursor.dominio.Cliente;

@Configuration
public class JdbcChunkWriterConfig {

	@Bean
	public ItemWriter<Cliente> jdbcChunkWriter() {
		return cliente -> cliente.forEach(System.out::println);
	}

}
