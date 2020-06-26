package com.zefuinha.fileflatdelimitado.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.fileflatdelimitado.dominio.Cliente;


@Configuration
public class ArquivoDelimitadoWriterConfig {
	
	@Bean
	public ItemWriter<Cliente> arquivoDelimitadoWriter(){
		return clientes -> clientes.forEach(System.out::println);
	}

}
