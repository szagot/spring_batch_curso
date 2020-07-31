package com.zefuinha.jdbccursor.chunk;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

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
				// Faz o mapeamento das linhas para o objeto (Usando mapper customizado)
				.rowMapper(rowMapper())
				// Construção
				.build();
	}

	private RowMapper<Cliente> rowMapper() {
		
		return new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				// Simula uma exceção no último registro
				if(rs.getRow() == 11) {
					throw new SQLException(String.format("Encerrando a execução - Cliente inválido %s", rs.getString("email")));
				} else {
					// Se não teve problema, retorna o rowMapper do registro atual
					return clienteRowMapper(rs);
				}
			}

			private Cliente clienteRowMapper(ResultSet rs) throws SQLException {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setIdade(rs.getInt("idade"));
				cliente.setEmail(rs.getString("email"));
				
				return cliente;
			}
		
		};
	
	}
	
}
