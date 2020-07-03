package com.zefuinha.xml.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.xml.dominio.Document;

@Configuration
public class XmlChunkConfig {
	
	@Autowired
	private StepBuilderFactory step;
	
	@Bean
	public Step xmlChunk(StaxEventItemReader<Document> reader, ItemWriter<Document> writer) {
		return step
				.get("xmlChunk")
				.<Document, Document>chunk(1)
				.reader(reader)
				.writer(writer)
				.build();			
	}

}
