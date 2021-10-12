package marcoslsouza.com.github.conceitos_testes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import marcoslsouza.com.github.conceitos_testes.pessoas.CadastroPessoas;
import marcoslsouza.com.github.conceitos_testes.pessoas.Pessoa;
import marcoslsouza.com.github.conceitos_testes.pessoas.exceptions.CadastroVazioException;
import marcoslsouza.com.github.conceitos_testes.pessoas.exceptions.PessoaSemNomeException;

public class CadastroPessoaTest {
	
	@Test
	public void deveCriarOCadastroDePessoas() {
		
		// Cenario
		CadastroPessoas cadastro = new CadastroPessoas();
		
		// Verificacao
		// Primeiro requisito: Cadastro fazio.
		Assertions.assertThat(cadastro.getPessoas()).isEmpty();
	}
	
	@Test
	public void deveAdicionarUmaPessoa() {
		
		// Cenario
		CadastroPessoas cadastro = new CadastroPessoas();
		Pessoa pessoa = new Pessoa();
		
		// Execucao
		pessoa.setNome("teste");
		cadastro.adicionar(pessoa);
		
		// Verificacao
		// Deve garantir que a pessoa sera adicionada
		Assertions.assertThat(cadastro.getPessoas())
			.isNotEmpty()
			.hasSize(1)
			.contains(pessoa);
	}

	@Test
	public void naoDeveAdicionarPessoaComNomeVazio() {
		// Cenario
		CadastroPessoas cadastro = new CadastroPessoas();
		Pessoa pessoa = new Pessoa();
		
		// Verificacao
		assertThrows(PessoaSemNomeException.class, () -> cadastro.adicionar(pessoa));
	}
	
	@Test
	public void deveRemoverUmaPessoa() {
		
		// Cenario
		CadastroPessoas cadastro = new CadastroPessoas();
		Pessoa pessoa = new Pessoa();
		
		// Execucao
		pessoa.setNome("Maria");
		cadastro.adicionar(pessoa);
		cadastro.remover(pessoa);
		
		// Execucao
		// Verifica se a lista esta vazia, pois adicionou somente uma pessoa.
		assertThat(cadastro.getPessoas()).isEmpty();
	}
	
	@Test
	public void deveLancarErroAoTentarRemoverPessoaInexistente() {
		// Cenario
		CadastroPessoas cadastro = new CadastroPessoas();
		Pessoa pessoa = new Pessoa();
		
		// Verificacao
		assertThrows(CadastroVazioException.class, () -> cadastro.remover(pessoa));
	}
}
