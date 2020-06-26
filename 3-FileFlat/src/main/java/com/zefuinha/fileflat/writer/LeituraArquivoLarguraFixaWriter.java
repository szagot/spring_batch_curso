package com.zefuinha.fileflat.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.fileflat.dominio.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaWriter {

	@Bean
	public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter(){
		return items -> items.forEach(System.out::println);
	}
}
