package marcoslsouza.com.github.conceitos_testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrimeiroTeste {
	
	private Calculadora calc;
	
	@BeforeEach
	public void criaCalculadora() {
		this.calc = new Calculadora();
	}

	/************** Somar *************/
	@Test
	public void deveSomarDoisNumeros() {
		
		// Cenario
		int numero_1 = 10;
		int numero_2 = 5;
		
		// execucao
		int resultado = calc.somar(numero_1, numero_2);
		
		// Verificacoes
		assertEquals(15, resultado);
	}
	
	@Test
	public void naoDeveSomarNumerosNegativos() {
		
		// Cenario
		int numero_1 = -10;
		int numero_2 = 5;
		
		// execucao/Verificacoes
		assertThrows(RuntimeException.class, () -> calc.somar(numero_1, numero_2));
	}

	/************** Subtrair *************/
	@Test
	public void deveSubtrairDoisNumeros() {
		
		// Cenario
		int numero_1 = 10;
		int numero_2 = 5;
		
		// execucao
		int resultado = calc.subtrair(numero_1, numero_2);
		
		// Verificacoes
		assertEquals(5, resultado);
	}
	
	/************** Multiplicar *************/
	@Test
	public void deveMultiplicarDoisNumeros() {
		
		// Cenario
		int numero_1 = 10;
		int numero_2 = 5;
		
		// execucao
		int resultado = calc.multiplicar(numero_1, numero_2);
		
		// Verificacoes
		assertEquals(50, resultado);
	}
	
	/************** Dividir *************/
	@Test
	public void deveDividirDoisNumeros() {
		
		// Cenario
		int numero_1 = 10;
		int numero_2 = 5;
		
		// execucao
		double resultado = calc.dividir(numero_1, numero_2);
		
		// Verificacoes
		assertEquals(2d, resultado);
	}
	
	@Test
	public void naoDeveDividirPorZero() {
		
		// Cenario
		int numero_1 = 4;
		int numero_2 = 0;
		
		// execucao / Verificacoes
		assertThrows(RuntimeException.class, () -> calc.dividir(numero_1, numero_2));
	}

}

class Calculadora {
	int somar(int num1, int num2) {
		if(num1 < 0 || num2 < 0)
			throw new RuntimeException("Não é permitido somar numeros negativos!");
		return num1 + num2;
	}
	
	int subtrair(int num1, int num2) {
		return num1 - num2;
	}
	
	int multiplicar(int numero_1, int numero_2) {
		return numero_1 * numero_2;
	}


	double dividir(int numero_1, int numero_2) {
		if(numero_1 == 0 || numero_2 == 0)
			throw new RuntimeException("Não é permitido multiplicar por zero!");
		return numero_1 / numero_2;
	}

}

