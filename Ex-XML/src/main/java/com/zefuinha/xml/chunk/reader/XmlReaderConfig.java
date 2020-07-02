package com.zefuinha.xml.chunk.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.xml.dominio.Document;

@Configuration
@StepScope
public class XmlReaderConfig {

	@Bean
	public StaxEventItemReader<Document> XmlReader() {
		return null;
	}

}
