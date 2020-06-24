package com.zefuinha.parimpar.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeWriter {
	/**
	 * Escritor
	 * 
	 * @return
	 */
	@Bean
	public ItemWriter<String> printWriter() {
		// Para cada item processado, faz a impressão do mesmo
		return itens -> itens.forEach(System.out::println);
	}
}
