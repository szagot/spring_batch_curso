package com.zefuinha.json.step.reader;

import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.json.dominio.Produto;

@Configuration
public class ArquivoJsonReaderConfig {

	@Bean
	public JsonItemReader<Produto> ArquivoJsonReader(){
		return null;
	}
	
}
