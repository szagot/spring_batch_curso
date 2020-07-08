package com.zefuinha.jdbpaging.chunk;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.zefuinha.jdbpaging.dominio.Cliente;

@Configuration
public class JdbcPagingReaderConfig {

	@Bean
	public JdbcPagingItemReader<Cliente> jdbcPagingReader(
			// Banco da Aplicação
			@Qualifier("appDataSource")
			DataSource dataSource,
			// Injeção do gerador de query para o paginador
			PagingQueryProvider queryProvider
	) {
		return new JdbcPagingItemReaderBuilder<Cliente>()
				// Nome
				.name("jdbcPagingReader")
				// BD
				.dataSource(dataSource)
				// Gerador de consulta injetado
				.queryProvider(queryProvider)
				// Tamanho da página
				.pageSize(1)
				// Mapeando as linhas no objeto Cliente
				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
				// Gerando leitor
				.build();
	}
	
	@Bean
	public SqlPagingQueryProviderFactoryBean queryProvider(
			// Banco da Aplicação
			@Qualifier("appDataSource")
			DataSource dataSource
	) {
		SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
		// BD
		queryProvider.setDataSource(dataSource);
		// Area do select
		queryProvider.setSelectClause("select *");
		// Area do from
		queryProvider.setFromClause("from cliente");
		// Chave de ordenação (para garantir integridade do retorno em cada página)
		queryProvider.setSortKey("email");
		
		return queryProvider;
	}
	
}
