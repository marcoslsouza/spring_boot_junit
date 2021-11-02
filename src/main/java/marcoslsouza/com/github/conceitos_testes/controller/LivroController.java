package marcoslsouza.com.github.conceitos_testes.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import marcoslsouza.com.github.conceitos_testes.dto.LivroDTO;
import marcoslsouza.com.github.conceitos_testes.model.Livro;
import marcoslsouza.com.github.conceitos_testes.service.LivroService;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

	private LivroService service;
	private ModelMapper modelMapper;

	@Autowired
	public LivroController(LivroService service, ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LivroDTO criar(@RequestBody LivroDTO dto) {
		
		// Para gerar o JSON com valores estaticos para teste 
		// LivroDTO dto = LivroDTO.builder().id(11l).autor("Autor").titulo("Meu Livro").isbn("12132222").build();
		
		/*Livro entidade = Livro.builder()
				.autor(dto.getAutor())
				.titulo(dto.getTitulo())
				.isbn(dto.getIsbn())
				.build();*/
		
		// Pega DTO e passa para Livro
		Livro entidade = this.modelMapper.map(dto, Livro.class);
		
		entidade = service.save(entidade);
		
		/*return LivroDTO.builder()
				.id(entidade.getId())
				.autor(entidade.getAutor())
				.titulo(entidade.getTitulo())
				.isbn(entidade.getIsbn())
				.build();*/
		
		// Pega Livro e passa para DTO
		return this.modelMapper.map(entidade, LivroDTO.class);
	}
}
