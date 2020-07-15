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
		aliases.put("PayDetails", String.class);
		aliases.put("NumberOfPages", String.class);
		aliases.put("Skipped", String.class);
		aliases.put("CustData", CustData.class);
		aliases.put("Name", String.class);
		aliases.put("Phone", String.class);
		aliases.put("City", String.class);
		aliases.put("Region", String.class);
		aliases.put("PostalCode", String.class);
		aliases.put("Country", String.class);
		aliases.put("Addr", String.class);
		
		// Aqui referencia o nome da lista de itens dentro da classe Trade
		Map<Class<?>,String> implicitCollections = new HashMap<Class<?>, String>();
		implicitCollections.put(CustData.class, "Addrs");
	 
		XStreamMarshaller marshaller = new XStreamMarshaller();

		// Aqui adiciona a coleção implícita
		marshaller.setImplicitCollections(implicitCollections);
		marshaller.setAliases(aliases);
		
		return marshaller;
	}

}
