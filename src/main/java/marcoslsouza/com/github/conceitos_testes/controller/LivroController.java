package marcoslsouza.com.github.conceitos_testes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import marcoslsouza.com.github.conceitos_testes.dto.LivroDTO;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LivroDTO criar(@RequestBody LivroDTO dto) {
		
		// Para gerar o JSON com valores estaticos para teste 
		// LivroDTO dto = LivroDTO.builder().id(11l).autor("Autor").titulo("Meu Livro").isbn("12132222").build();
		
		
		
		return dto;
	}
}
