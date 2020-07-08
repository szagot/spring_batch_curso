package com.zefuinha.jdbpaging.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JdbcPagingJobConfig {
	
	@Autowired
	private JobBuilderFactory job;
	
	@Bean
	public Job jdbcPagingJob(Step step) {
		return job
				.get("jdbcPagingJob")
				.start(step)
				.build();
				
	}

}
