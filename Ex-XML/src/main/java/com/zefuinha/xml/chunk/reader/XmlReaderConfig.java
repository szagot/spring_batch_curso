package com.zefuinha.xml.chunk.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.zefuinha.xml.dominio.CustData;
import com.zefuinha.xml.dominio.Document;

/**
 * TODO: Está igual à documentação, porém não funciona. Mesmo colocando o mesmo arquivo e o mesmos leitores.
 * 
 * https://docs.spring.io/spring-batch/docs/current/reference/html/index-single.html#xmlReadingWriting
 */

@Configuration
public class XmlReaderConfig {

	@Bean
	public StaxEventItemReader<Document> xmlReader() {
		return new StaxEventItemReaderBuilder<Document>()
				.name("xmlReader")
				.resource(new FileSystemResource("files/teste.xml"))
				.addFragmentRootElements("document")
				.unmarshaller(documentMarshaller())
				.build();
	}

	@SuppressWarnings("rawtypes")
	@Bean
	public XStreamMarshaller documentMarshaller() {
		Map<String, Class> aliases = new HashMap<>();
		
		aliases.put("document", Document.class);
		aliases.put("VendorId", String.class);
		aliases.put("DocTypeId", String.class);
		aliases.put("AccNo", String.class);
		aliases.put("StmtDate", String.class);
		aliases.put("CustData", CustData.class);
		aliases.put("Name", String.class);
		aliases.put("Phone", String.class);
		
		XStreamMarshaller marshaller = new XStreamMarshaller();
		
		marshaller.setAliases(aliases);
		
		return marshaller;
	}

}
