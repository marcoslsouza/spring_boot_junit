package marcoslsouza.com.github.conceitos_testes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marcoslsouza.com.github.conceitos_testes.model.Livro;
import marcoslsouza.com.github.conceitos_testes.repository.LivroRepository;
import marcoslsouza.com.github.conceitos_testes.service.LivroService;

@Service
public class BookServiceImpl implements LivroService {

	private LivroRepository repository;
	
	@Autowired
	public BookServiceImpl(LivroRepository repository) {
		this.repository = repository;
	}

	@Override
	public Livro salvar(Livro livro) {
		return this.repository.save(livro);
	}

}
