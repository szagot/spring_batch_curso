package com.zefuinha.fileflatmultiplosformatos.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.fileflatmultiplosformatos.reader.ArquivoClienteTransacaoReader;

@Configuration
public class ArquivosMultiplosFormatosStepConfig {

	@Autowired
	private StepBuilderFactory step;
	
	@Bean
	public Step arquivosMultiplosFormatosStep(FlatFileItemReader reader, ItemWriter writer) {
		return step
				.get("arquivosMultiplosFormatosStep")
				.chunk(1)
				// Leitor especializado em inserir as transações no cliente
				.reader(new ArquivoClienteTransacaoReader(reader))
				.writer(writer)
				.build();
	}
	
}
