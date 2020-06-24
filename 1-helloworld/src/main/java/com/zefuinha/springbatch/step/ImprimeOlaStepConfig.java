package com.zefuinha.springbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeOlaStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderfactory;

	/**
	 * Etapa do JOB
	 * 
	 * @return
	 */
	@Bean
	public Step olaMundoStep(Tasklet olaMundoTasklet) {
		return stepBuilderfactory
				// Nome da etapa
				.get("stepOlaMundo")
				// Tarefa simples a ser executada
				.tasklet(olaMundoTasklet)
				// Cria o Step
				.build();
	}

}
