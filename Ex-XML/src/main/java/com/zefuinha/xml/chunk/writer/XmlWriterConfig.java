package com.zefuinha.xml.chunk.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.xml.dominio.Document;

@Configuration
public class XmlWriterConfig {

	@Bean
	public ItemWriter<Document> xmlWriter() {
		// Imprimindo apenas número da conta
		return documents -> documents.forEach(document -> System.out.println(document.getAccNo()));
	}

}
