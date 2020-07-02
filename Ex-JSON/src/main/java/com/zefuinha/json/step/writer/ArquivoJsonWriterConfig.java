package com.zefuinha.json.step.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.json.dominio.Produto;

@Configuration
public class ArquivoJsonWriterConfig {

	@Bean
	public ItemWriter<Produto> ArquivoJsonWriter(){
		return produtos -> produtos.forEach(System.out::println);
	}
	
}
