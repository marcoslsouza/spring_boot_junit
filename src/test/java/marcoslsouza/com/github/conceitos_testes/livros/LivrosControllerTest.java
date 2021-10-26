package marcoslsouza.com.github.conceitos_testes.livros;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/* Teste unitario */


// Cria um mini contexto de injecao de dependencia para rodar o teste
@ExtendWith(SpringExtension.class)

// Rodar com perfil de teste
@ActiveProfiles("test")

@WebMvcTest

// Configura um objeto para fazer as requisicoes
@AutoConfigureMockMvc
public class LivrosControllerTest {
	
	@Autowired
	// MockMvc simula como se fosse uma requisicao para a API
	MockMvc mvc;
	
	@Test
	@DisplayName("Deve criar um livro com sucesso")
	// Primeiro teste para a requisicao POST
	public void criarLivroTest() {
		
	}
	
	@Test
	@DisplayName("Deve lancar erro de validacao quando nao houver dados suficiente para criacao do livro.")
	// Primeiro teste para a requisicao POST
	public void criarLivroInvalidoTest() {
		
	}
}
