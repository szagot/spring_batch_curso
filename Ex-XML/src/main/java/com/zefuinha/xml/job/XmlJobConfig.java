package com.zefuinha.xml.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class XmlJobConfig {

	@Autowired
	private JobBuilderFactory job;
	
	@Bean
	public Job XmlJob(Step step) {
		return job
				.get("XmlJob")
				.start(step)
				.build();
	}
	
}
