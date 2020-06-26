package com.zefuinha.fileflat.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.fileflat.dominio.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {

	@Bean
	public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter(){
//		return items -> items.forEach(System.out::println);
		return items -> {
			for(Cliente cliente: items) {
				// Se o nome do cliente for Maria, simula uma falha
				if(cliente.getNome().equals("Maria")) {
					throw new Exception();
				} else {
					System.out.println(cliente);
				}
			}
		};
	}
}
