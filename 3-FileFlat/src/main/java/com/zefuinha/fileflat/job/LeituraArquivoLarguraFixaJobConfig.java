package com.zefuinha.fileflat.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class LeituraArquivoLarguraFixaJobConfig {

	@Autowired
	private JobBuilderFactory job;

	@Bean
	public Job leituraArquivoLarguraFixajob(Step leituraArquivoLarguraFixaStep) {
		return job
				.get("leituraArquivoLarguraFixaJob")
				.start(leituraArquivoLarguraFixaStep)
				// Removido o incremento de ID para garantir que o arquivo será lido só uma vez 
				//.incrementer(new RunIdIncrementer())
				.build();
	}

}
