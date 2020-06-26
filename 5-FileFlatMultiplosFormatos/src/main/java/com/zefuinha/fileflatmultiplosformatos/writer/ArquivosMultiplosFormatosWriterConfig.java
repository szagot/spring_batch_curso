package com.zefuinha.fileflatmultiplosformatos.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ArquivosMultiplosFormatosWriterConfig {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public ItemWriter arquivosMultiplosFormatosWriter() {
		return items -> items.forEach(System.out::println);
	}
	
}
