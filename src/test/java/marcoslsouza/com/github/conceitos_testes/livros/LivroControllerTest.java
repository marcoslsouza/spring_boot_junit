package marcoslsouza.com.github.conceitos_testes.livros;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import marcoslsouza.com.github.conceitos_testes.dto.LivroDTO;
import marcoslsouza.com.github.conceitos_testes.model.Livro;
import marcoslsouza.com.github.conceitos_testes.service.LivroService;

/* Teste unitario */


// Cria um mini contexto de injecao de dependencia para rodar o teste
@ExtendWith(SpringExtension.class)

// Rodar com perfil de teste
@ActiveProfiles("test")

@WebMvcTest

// Configura um objeto para fazer as requisicoes
@AutoConfigureMockMvc
public class LivroControllerTest {
	
	// Definir a rota. Rota definida no controller
	static String LIVROS_API = "/api/livros";
	
	@Autowired
	// MockMvc simula como se fosse uma requisicao para a API
	MockMvc mvc;
	
	
	// Cria um mock no contexto de dependencia @ExtendWith
	@MockBean
	LivroService service;
	
	@Test
	@DisplayName("Deve criar um livro com sucesso")
	// Primeiro teste para a requisicao POST
	public void criarLivroTest() throws Exception {
		
		// Livro Salvo
		Livro livroSalvo = Livro.builder().id(10l).autor("Arthur").titulo("As aventuras").isbn("001").build();
		
		// Simular a acao do LivroService->save() retornando os dados de livroSalvo
		BDDMockito.given(service.save(Mockito.any(Livro.class)))
			.willReturn(livroSalvo);
		
		
		LivroDTO dto = LivroDTO.builder().autor("Arthur").titulo("As aventuras").isbn("001").build();
		
		// Converte o dto em JSON
		String json = new ObjectMapper().writeValueAsString(dto);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
			.post(LIVROS_API)
			.contentType(MediaType.APPLICATION_JSON) // Sera enviado JSON
			.accept(MediaType.APPLICATION_JSON) // Servidor aceita JSON
			.content(json); // JSON passado
		
		// Fazer a requisicao
		mvc
			.perform(request)
			.andExpect(MockMvcResultMatchers.status().isCreated()) // Verifica o status recebido
			.andExpect(MockMvcResultMatchers.jsonPath("id").value(10l)) // Verifica se o JSON de resposta e igual ao enviado. Verifica se o id nao esta vazio
			.andExpect(MockMvcResultMatchers.jsonPath("titulo").value(dto.getTitulo()))
			.andExpect(MockMvcResultMatchers.jsonPath("autor").value(dto.getAutor()))
			.andExpect(MockMvcResultMatchers.jsonPath("isbn").value(dto.getIsbn()));
	}
	
	@Test
	@DisplayName("Deve lancar erro de validacao quando nao houver dados suficiente para criacao do livro.")
	// Primeiro teste para a requisicao POST
	public void criarLivroInvalidoTest() {
		
	}
}
