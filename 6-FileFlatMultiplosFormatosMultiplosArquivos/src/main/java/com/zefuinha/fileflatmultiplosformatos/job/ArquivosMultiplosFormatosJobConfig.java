package com.zefuinha.fileflatmultiplosformatos.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ArquivosMultiplosFormatosJobConfig {
	
	@Autowired
	private JobBuilderFactory job;
	
	@Bean
	public Job arquivosMultiplosFormatosJob(Step step) {
		return job
				.get("arquivosMultiplosFormatosJob")
				.start(step)
				.build();
	}

}
