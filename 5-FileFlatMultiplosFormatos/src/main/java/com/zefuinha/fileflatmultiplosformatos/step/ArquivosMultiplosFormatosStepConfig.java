package com.zefuinha.fileflatmultiplosformatos.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivosMultiplosFormatosStepConfig {

	@Autowired
	private StepBuilderFactory step;
	
	@Bean
	public Step arquivosMultiplosFormatosStep(FlatFileItemReader reader, ItemWriter writer) {
		return step
				.get("arquivosMultiplosFormatosStep")
				.chunk(1)
				.reader(reader)
				.writer(writer)
				.build();
	}
	
}
