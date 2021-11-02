package marcoslsouza.com.github.conceitos_testes;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConceitosTestesApplication {
	
	// Retorna a mesma instancia do ModelMapper em toda a aplicacao
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConceitosTestesApplication.class, args);
	}

}
