package com.zefuinha.fileflat.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.fileflat.dominio.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaReader {

	@Bean
	public FlatFileItemReader<Cliente> leituraArquivoLarguraFixaReader(){
		return null;
	}
	
}
