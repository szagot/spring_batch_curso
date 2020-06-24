package com.zefuinha.parimpar.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeParImparStep {
	@Autowired
	private StepBuilderFactory step;

	@Bean
	public Step parImparStep(IteratorItemReader<Integer> contaDezReader, FunctionItemProcessor<Integer, String> parImparProcessor, ItemWriter<String> printWriter) {
		return step
				// Nome do Step
				.get("imprimeParImparStep")
				// Tipo Chunk: <Leitura, Escrita>chunk(tamanho)
				// Tamanho: Até quantos itens podem ser armazenados na memória para cada pedaço.
				// Isso vai depender da memória, e de quantos pedaços vc está disposto a perder em caso de falha.
				// Neste exemplo, por serem 10 números, vamos dividir os commits ao banco de dados pela metade
				.<Integer, String>chunk(5)
				// Leitor
				.reader(contaDezReader)
				// Processador
				.processor(parImparProcessor)
				// Escritor
				.writer(printWriter)
				// Constroi o Step
				.build();
	}
}
