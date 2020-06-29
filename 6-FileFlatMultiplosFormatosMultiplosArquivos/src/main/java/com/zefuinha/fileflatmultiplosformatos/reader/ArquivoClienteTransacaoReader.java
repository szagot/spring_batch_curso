package com.zefuinha.fileflatmultiplosformatos.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

import com.zefuinha.fileflatmultiplosformatos.dominio.Cliente;
import com.zefuinha.fileflatmultiplosformatos.dominio.Transacao;

/**
 * Faz a analise dos registros para adicionar as transações no cliente
 * 
 * @author szago
 *
 */
public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente> {

	// Objeto que está sendo lido
	private Object objetoAtual;

	// Objeto para delegar a função de leitura
	private ItemStreamReader<Object> delegate;

	/**
	 * Construtor para delegar a leitura dos objetos ao leitor já existente
	 */
	public ArquivoClienteTransacaoReader(ItemStreamReader<Object> delegate) {
		this.delegate = delegate;
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		delegate.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		delegate.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		delegate.close();
	}

	@Override
	public Cliente read() throws Exception {

		// Se o objeto atual ainda está vazio, faz a leitura dele
		if (objetoAtual == null) {
			objetoAtual = delegate.read();
		}

		// Pega o objeto atual, convertendo para o tipo cliente
		Cliente cliente = (Cliente) objetoAtual;
		objetoAtual = null;

		// Se o objeto não estiver vazio
		if (cliente != null) {
			// Dá uma espiada (peek) nos próximos objetos, pegando as transações do cliente
			while (peek() instanceof Transacao) {
				// Adiciona a transação ao cliente
				cliente.getTransacoes().add((Transacao) objetoAtual);
			}
		}

		return cliente;
	}

	private Object peek() throws Exception {
		// Faz a leitura do próximo item
		objetoAtual = delegate.read();

		return objetoAtual;
	}

}
