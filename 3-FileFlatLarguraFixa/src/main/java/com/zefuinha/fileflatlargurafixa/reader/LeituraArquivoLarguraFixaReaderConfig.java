package com.zefuinha.fileflatlargurafixa.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.zefuinha.fileflatlargurafixa.dominio.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaReaderConfig {

	@StepScope
	@Bean
	public FlatFileItemReader<Cliente> leituraArquivoLarguraFixaReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes) {
		return new FlatFileItemReaderBuilder<Cliente>()
				// Nome do reader
				.name("leituraArquivoLarguraFixaReader")
				// recurso: arquivo que será lido (por parâmetro)
				.resource(arquivoClientes)
				// Tipo: Arquivo de largura fixa
				.fixedLength()
				// Configurações de coluna
				.columns(new Range[] { new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43) })
				// Nomes das propriedades colunas
				.names(new String[] { "nome", "sobrenome", "idade", "email" })
				// Converte para um objeto de dominio
				.targetType(Cliente.class)
				// Cria o reader
				.build();
	}

}
