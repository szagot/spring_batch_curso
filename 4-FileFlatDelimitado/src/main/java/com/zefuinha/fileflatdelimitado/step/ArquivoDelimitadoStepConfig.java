package com.zefuinha.fileflatdelimitado.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.fileflatdelimitado.dominio.Cliente;

@Configuration
public class ArquivoDelimitadoStepConfig {

	@Autowired
	private StepBuilderFactory step;
	
	@Bean
	public Step arquivoDelimitadoStep(FlatFileItemReader<Cliente> reader, ItemWriter<Cliente> writer) {
		return step
				.get("ArquivoDelimitadoStep")
				.<Cliente, Cliente>chunk(1)
				.reader(reader)
				.writer(writer)
				.build();
	}
	
}
