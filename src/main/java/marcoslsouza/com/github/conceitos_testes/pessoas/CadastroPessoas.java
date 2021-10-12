package marcoslsouza.com.github.conceitos_testes.pessoas;

import java.util.ArrayList;
import java.util.List;

import marcoslsouza.com.github.conceitos_testes.pessoas.exceptions.CadastroVazioException;
import marcoslsouza.com.github.conceitos_testes.pessoas.exceptions.PessoaSemNomeException;

public class CadastroPessoas {

	private List<Pessoa> pessoas;
	
	public CadastroPessoas() {
		this.pessoas = new ArrayList<>();
	}

	public List<Pessoa> getPessoas() {
		// TODO Auto-generated method stub
		return this.pessoas;
	}

	public void adicionar(Pessoa pessoa) {
		if(pessoa.getNome() == null)
			throw new PessoaSemNomeException();
		this.pessoas.add(pessoa);
	}

	public void remover(Pessoa pessoa) {
		if(!this.pessoas.contains(pessoa))
			throw new CadastroVazioException();
		this.pessoas.remove(pessoa);
	}

}
