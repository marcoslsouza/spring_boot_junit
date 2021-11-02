package marcoslsouza.com.github.conceitos_testes.livros.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import marcoslsouza.com.github.conceitos_testes.model.Livro;
import marcoslsouza.com.github.conceitos_testes.repository.LivroRepository;
import marcoslsouza.com.github.conceitos_testes.service.LivroService;
import marcoslsouza.com.github.conceitos_testes.service.impl.BookServiceImpl;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class LivroServiceTest {

	LivroService service;
	
	@MockBean
	LivroRepository repository;
	
	@BeforeEach
	public void setUp() {
		this.service = new BookServiceImpl(this.repository);
	}
	
	@Test
	@DisplayName("Deve salvar um livro")
	public void salvarLivroTest() {
		// Cenario
		Livro livro = Livro.builder().isbn("123").autor("Fulano").titulo("As aventuras").build();
		Mockito.when(this.repository.save(livro))
			.thenReturn(Livro.builder().id(11l).isbn("123").titulo("As Aventuras").autor("Fulano").build());
		
		// Execucao
		Livro salvarLivro = this.service.salvar(livro);
		
		// Verificacao
		assertThat(salvarLivro.getId()).isNotNull();
		assertThat(salvarLivro.getIsbn()).isEqualTo("123");
		assertThat(salvarLivro.getTitulo()).isEqualTo("As Aventuras");
		assertThat(salvarLivro.getAutor()).isEqualTo("Fulano");
	}
}
