package marcoslsouza.com.github.conceitos_testes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marcoslsouza.com.github.conceitos_testes.cliente.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class MeuResource {

	@GetMapping("/{id}")
	public Cliente obterDadosDoCliente(@PathVariable Long id) {
		
		System.out.println(String.format("Id recebido pela URL: %d", id));
		
		Cliente cliente = new Cliente("Fulano", "000.000.000-00");
		
		return cliente;
	}
}
