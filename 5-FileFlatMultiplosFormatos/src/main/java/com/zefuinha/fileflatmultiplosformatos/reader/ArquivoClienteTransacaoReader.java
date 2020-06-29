package com.zefuinha.fileflatmultiplosformatos.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.zefuinha.fileflatmultiplosformatos.dominio.Cliente;
import com.zefuinha.fileflatmultiplosformatos.dominio.Transacao;

/**
 * Faz a analise dos registros para adicionar as transações no cliente
 * 
 * @author szago
 *
 */
public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente> {

	private Object objetoAtual;

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		// Se o objeto atual ainda está vazio, faz a leitura dele
		if (objetoAtual == null) {
			objetoAtual = null; // TODO: ler
		}
		
		// Pega o objeto atual, convertendo para o tipo cliente
		Cliente cliente = (Cliente) objetoAtual;
		objetoAtual = null;
		
		// Se o objeto não estiver vazio
		if(cliente != null) {
			// Dá uma espiada (peek) nos próximos objetos, pegando as transações do cliente
			while(peek() instanceof Transacao) {
				// Adiciona a transação ao cliente
				cliente.getTransacoes().add((Transacao) objetoAtual);
			}
		}
		
		return cliente;
	}

	private Transacao peek() {
		// Faz a leitura do próximo item
		objetoAtual = new Transacao(); // TODO: ler
		
		return (Transacao) objetoAtual;
	}

}
