package com.zefuinha.jdbpaging.chunk;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.jdbpaging.dominio.Cliente;

@Configuration
public class JdbcPagingWriterConfig {

	@Bean
	public ItemWriter<Cliente> jdbcPagingWriter(){
		return cliente -> cliente.forEach(System.out::println);
	}
	
}
