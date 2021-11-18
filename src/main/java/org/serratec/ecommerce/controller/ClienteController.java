package org.serratec.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import org.serratec.ecommerce.entity.Cliente;
import org.serratec.ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	public ClienteService clienteService;

	private static List<Cliente> listaClientes = new ArrayList<>();


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
		return cliente;
	}

	@GetMapping
	public ResponseEntity<?> lista() {
		listaClientes = clienteService.findAll();
		return ResponseEntity.ok(listaClientes);
	}

	@GetMapping("{/id}")
	public ResponseEntity<Cliente> buscaId(@PathVariable Long id) {
		ResponseEntity<Cliente> cliente = clienteService.buscaId(id);
		return cliente;
		
	}

	@PutMapping("{/id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        ResponseEntity<Cliente> clienteN = clienteService.buscaId(id);
        return clienteN;
		
	}

	@DeleteMapping("{id}")
	public ResponseEntity <Void> deletarPorId(@PathVariable Long id){
		ResponseEntity<Void> deleteCliente = clienteService.deletarPorId(id);
		return deleteCliente;
	}

}
