package marcoslsouza.com.github.conceitos_testes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

// Cria um build para facilitar a criacao das instancias
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {

	private Long id;
	private String titulo;
	private String autor;
	private String isbn;
}
