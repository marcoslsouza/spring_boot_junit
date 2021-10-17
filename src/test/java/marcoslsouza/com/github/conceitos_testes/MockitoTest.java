package marcoslsouza.com.github.conceitos_testes;

//import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;

// import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MockitoTest {
	
	@Mock
	List<String> lista;
	
	// Roda BeforeEach() antes de todos os metodos.
	@BeforeEach
	public void BeforeEach() {
		// O Mockito ler todos os atributos @Mock desta classe e cria os Mocks.
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void primeiroTesteMockito() {
		
		// List<String> lista = Mockito.mock(ArrayList.class);
		
		Mockito.when(lista.size()).thenReturn(20);
		
		int size = lista.size();
		
		lista.add("");
		
		// Verificar se chamou o metodo size.
		// Mockito.times(1) -> Verifica se o metodo size foi chamado 1 vez.
		// Mockito.never() -> Quando nao quer que o metodo seja chamado.
		Mockito.verify(lista, Mockito.times(1)).size();
		
		// Verificar as ordens que os metodos foram chamados
		InOrder inOrder = Mockito.inOrder(lista);
		inOrder.verify(lista).size();
		inOrder.verify(lista).add("");
		
		assertThat(size).isEqualTo(20);
		
		//Assertions.assertEquals(20, 20);
	}
}
