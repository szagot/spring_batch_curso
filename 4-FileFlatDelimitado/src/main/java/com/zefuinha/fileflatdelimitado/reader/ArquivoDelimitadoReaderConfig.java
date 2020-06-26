package com.zefuinha.fileflatdelimitado.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.fileflatdelimitado.dominio.Cliente;

@Configuration
public class ArquivoDelimitadoReaderConfig {

	@Bean
	public FlatFileItemReader<Cliente> arquivoDelimitadoReader(){
		// TODO: fazer o reader
		return null;
	}
	
}
