package marcoslsouza.com.github.conceitos_testes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, Cliente cliente) {
		return ResponseEntity.ok().body(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete() {
		return ResponseEntity.noContent().build();
	}
}
