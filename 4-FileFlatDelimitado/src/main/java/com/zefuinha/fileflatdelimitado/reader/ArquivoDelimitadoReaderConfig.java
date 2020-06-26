package com.zefuinha.fileflatdelimitado.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.zefuinha.fileflatdelimitado.dominio.Cliente;

@Configuration
public class ArquivoDelimitadoReaderConfig {

	@StepScope
	@Bean
	public FlatFileItemReader<Cliente> arquivoDelimitadoReader(
			@Value("#{jobParameters['arquivoCliente']}") Resource arquivoCliente) {
		return new FlatFileItemReaderBuilder<Cliente>()
				// Nome do reader
				.name("arquivoDelimitadoReader")
				// Arquivo a ser lido
				.resource(arquivoCliente)
				// Tipo do Flat: Delimitado
				.delimited()
				// Nomes dos campos (Devem ser os mesmos da classe)
				.names(new String[] { "nome", "sobrenome", "idade", "email" })
				// Objeto da conversão
				.targetType(Cliente.class)
				// Constroi o reader
				.build();
	}

}
