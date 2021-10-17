package marcoslsouza.com.github.conceitos_testes;

import java.util.ArrayList;
import java.util.List;

//import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockitoTest {

	@Test
	public void primeiroTesteMockito() {
		
		List<String> lista = Mockito.mock(ArrayList.class);
		
		Mockito.when(lista.size()).thenReturn(20);
		
		int size = lista.size();
		
		assertThat(size).isEqualTo(20);
		
		//Assertions.assertEquals(20, 20);
	}
}
