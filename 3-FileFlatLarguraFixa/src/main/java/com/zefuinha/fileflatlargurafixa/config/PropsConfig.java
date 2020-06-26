package com.zefuinha.fileflatlargurafixa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

/**
 * Externaliza o arquivo de configuração (application.properties)
 */

@Configuration
public class PropsConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer config() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		// Define onde está o arquivo de configuração do Batch
		configurer.setLocation(new FileSystemResource("../application.properties"));
		
		return configurer;
	}
	
}

