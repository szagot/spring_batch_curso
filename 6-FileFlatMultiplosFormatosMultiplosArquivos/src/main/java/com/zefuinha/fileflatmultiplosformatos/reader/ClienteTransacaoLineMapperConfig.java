package com.zefuinha.fileflatmultiplosformatos.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zefuinha.fileflatmultiplosformatos.dominio.Cliente;
import com.zefuinha.fileflatmultiplosformatos.dominio.Transacao;

@Configuration
public class ClienteTransacaoLineMapperConfig {

	/**
	 * PatternMatchingCompositeLineMapper é capaz de usar um padrão para descobrir
	 * com linemapper aplicar a cada linha
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public PatternMatchingCompositeLineMapper lineMapper() {

		PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();

		// Como dividir a linha em tokens (palavras)
		lineMapper.setTokenizers(tokenizers());
		// Mapeia os tokens em um objeto de dominio apropriado
		lineMapper.setFieldSetMappers(fieldSetMappers());

		return lineMapper;

	}

	/**
	 * Cria um Map que indoca qual LineTokenizer usar de acordo com o tipo
	 */
	private Map<String, LineTokenizer> tokenizers() {
		Map<String, LineTokenizer> tokenizers = new HashMap<>();
		
		// Se a linha começar com "0", trata-se de um cliente
		tokenizers.put("0*", clienteLineTokenizer());
		
		// Se a linha começar com "1", trata-se de uma transação
		tokenizers.put("1*", transacaoLineTokenizer());
		
		return tokenizers;
	}

	/**
	 * Tokenizer para Cliente
	 */
	private LineTokenizer clienteLineTokenizer() {
		// Delimitador
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		// Nomes dos campos
		lineTokenizer.setNames("nome", "sobrenome", "idade", "email");
		// Adiciona campos, ignorando o primeiro que é só o identificador (posição 0)
		lineTokenizer.setIncludedFields(1, 2, 3, 4);

		return lineTokenizer;
	}

	/**
	 * Tokenizer para Transação
	 */
	private LineTokenizer transacaoLineTokenizer() {
		// Delimitador
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		// Nomes dos campos
		lineTokenizer.setNames("id", "descricao", "valor");
		// Adiciona campos, ignorando o primeiro que é só o identificador (posição 0)
		lineTokenizer.setIncludedFields(1, 2, 3);

		return lineTokenizer;
	}

	/**
	 * Mapeando de acordo com o tipo de tojen
	 */
	@SuppressWarnings("rawtypes")
	private Map<String, FieldSetMapper> fieldSetMappers() {
		Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();

		// Adicionando mapeador para cliente
		fieldSetMappers.put("0*", fieldSetMapper(Cliente.class));

		// Adicionando mapeador para transação
		fieldSetMappers.put("1*", fieldSetMapper(Transacao.class));

		return fieldSetMappers;
	}

	/**
	 * Define o objeto de dominio a ser usado para esse FieldSetMapper
	 * 
	 * @param classe
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private FieldSetMapper fieldSetMapper(Class classe) {
		BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();

		// Define o objeto de dominio a ser usado
		fieldSetMapper.setTargetType(classe);

		return fieldSetMapper;
	}

}
