package marcoslsouza.com.github.conceitos_testes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marcoslsouza.com.github.conceitos_testes.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
