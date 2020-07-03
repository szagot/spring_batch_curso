package com.zefuinha.jdbccursor.chunk;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.zefuinha.jdbccursor.dominio.Cliente;

@Configuration
public class JdbcChunkReaderConfig {

	/**
	 * @param dataSource \@Qualifier("appDataSource") -> Pega o banco de dados da classe config.DataSourceConfig
	 * @return
	 */
	@Bean
	public JdbcCursorItemReader<Cliente> jdbcChunkReader(@Qualifier("appDataSource") DataSource dataSource){
		return new JdbcCursorItemReaderBuilder<Cliente>()
				.name("jdbcChunkReader")
				// Banco de dados
				.dataSource(dataSource)
				// Consulta
				.sql("select * from cliente")
				// Faz o mapeamento das linhas para o objeto
				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
				// Construção
				.build();
	}
	
}
