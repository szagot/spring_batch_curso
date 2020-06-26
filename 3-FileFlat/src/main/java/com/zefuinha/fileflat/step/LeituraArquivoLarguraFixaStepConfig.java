package com.zefuinha.fileflat.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.fileflat.dominio.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaStepConfig {

	@Autowired
	private StepBuilderFactory step;

	@Bean
	public Step leituraArquivoLarguraFixaStep(FlatFileItemReader<Cliente> leituraArquivoLarguraFixaReader,
			ItemWriter<Cliente> leituraArquivoLarguraFixaWriter) {
		return step
				.get("leituraArquivoLarguraFixaStep")
				// Chunk criado para cada registro. Se ocorrer um erro, ele continua a partir do registro com erro  
				.<Cliente, Cliente>chunk(1)
				.reader(leituraArquivoLarguraFixaReader)
				.writer(leituraArquivoLarguraFixaWriter)
				.build();
	}

}
