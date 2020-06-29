package com.zefuinha.fileflatmultiplosformatos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivosMultiplosFormatosReaderConfig {

	// Nesse caso específico não identificamos o tipo de objeto porque não tem como
	// saber previamente o tipo da linha

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@StepScope
	@Bean
	public FlatFileItemReader arquivosMultiplosFormatosReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes, LineMapper lineMapper) {
		return new FlatFileItemReaderBuilder()
				// Nome
				.name("arquivosMultiplosFormatosReader")
				// Arquivo
				.resource(arquivoClientes)
				// Mapeador da linha personalizado
				.lineMapper(lineMapper)
				// Cria o leitor
				.build();

	}

}
