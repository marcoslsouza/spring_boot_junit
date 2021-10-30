package marcoslsouza.com.github.conceitos_testes.livros;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

/* Teste unitario */


// Cria um mini contexto de injecao de dependencia para rodar o teste
@ExtendWith(SpringExtension.class)

// Rodar com perfil de teste
@ActiveProfiles("test")

@WebMvcTest

// Configura um objeto para fazer as requisicoes
@AutoConfigureMockMvc
public class LivrosControllerTest {
	
	// Definir a rota. Rota definida no controller
	static String LIVROS_API = "/api/livros";
	
	@Autowired
	// MockMvc simula como se fosse uma requisicao para a API
	MockMvc mvc;
	
	@Test
	@DisplayName("Deve criar um livro com sucesso")
	// Primeiro teste para a requisicao POST
	public void criarLivroTest() throws Exception {
		
		String json = new ObjectMapper().writeValueAsString(null);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
			.post(LIVROS_API)
			.contentType(MediaType.APPLICATION_JSON) // Sera enviado JSON
			.accept(MediaType.APPLICATION_JSON) // Servidor aceita JSON
			.content(json); // JSON passado
		
		// Fazer a requisicao
		mvc
			.perform(request)
			.andExpect(MockMvcResultMatchers.status().isCreated()) // Verifica o status recebido
			.andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty()) // Verifica se o JSON de resposta e igual ao enviado. Verifica se o id nao esta vazio
			.andExpect(MockMvcResultMatchers.jsonPath("titulo").value("Meu Livro"))
			.andExpect(MockMvcResultMatchers.jsonPath("autor").value("Autor"))
			.andExpect(MockMvcResultMatchers.jsonPath("isbn").value("12132222"));
	}
	
	@Test
	@DisplayName("Deve lancar erro de validacao quando nao houver dados suficiente para criacao do livro.")
	// Primeiro teste para a requisicao POST
	public void criarLivroInvalidoTest() {
		
	}
}
