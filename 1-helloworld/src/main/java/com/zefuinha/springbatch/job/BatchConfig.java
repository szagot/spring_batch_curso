/**
 * https://medium.com/@giu.drawer/spring-batch-para-desenvolvimento-de-jobs-1674ec5b9a20
 * 
 * @EnableBatchProcessing: Essa anotação permite que o Spring monte toda a estrutura necessária para executar o batch. 
 * Todos aqueles componentes que vimos na arquitetura do Spring Batch serão configurados automaticamente, 
 * precisaremos apenas alterar o que desejarmos para a nossa aplicação (e.g. Banco de dados).
 * 
 * jobBuilderFactory e stepBuilderFactory: Injetamos esses componentes para construir de forma fluente o job e seus steps. 
 * 
 * step(): Injeta (@Bean) e configura os steps do job. No nosso exemplo, é criada uma simples tasklet que imprime o Hello World. 
 * 
 * job(): Esse método é injetado com o @Bean para retornar o job que será construído a partir dos steps configurados.
 */

package com.zefuinha.springbatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderfactory;

	@Bean
	public Job jobOlaMundo(Step olaMundoStep) {
		return jobBuilderfactory
				// Nome do JOB
				.get("jobOlaMundo")
				// Etapa do JOB (lógica)
				.start(olaMundoStep)
				// Adiciona automaticamente um ID a cada execução, permitindo o JOB executar
				// mais de uma vez. Não usar se precisar que o Batch continue de onde parou em
				// caso de falha
				.incrementer(new RunIdIncrementer())
				// Constroi o JOB
				.build();
	}

}
