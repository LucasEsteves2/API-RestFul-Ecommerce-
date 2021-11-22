package org.serratec.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.ecommerce.entity.Cliente;
import org.serratec.ecommerce.entity.Endereco;
import org.serratec.ecommerce.services.ClienteService;
import org.serratec.ecommerce.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/security")
public class WebSecurityController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	EnderecoService enderecoService;

	@ApiOperation(value = "Retorna todos as info de clientes (voce precisa estar autenticado)")
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> lista() {
		List<Cliente> cli = new ArrayList<Cliente>();

		cli = clienteService.findAll();
		return ResponseEntity.ok(cli);

	}
	//aa

	@ApiOperation(value = "Busca cliente por Cidade(precisa estar autenticado)")

	@GetMapping("/{cidade}")
	public ResponseEntity<List<Cliente>> findCidade(@PathVariable String cidade) {

		List<Endereco> end = new ArrayList();
		end = enderecoService.findCidade(cidade);

		List<Cliente> cli = new ArrayList<Cliente>();
		
		for (Endereco x : end) {
			
			cli.add(x.getCliente());
		}

		return ResponseEntity.ok(cli);

	}

	@ApiOperation(value = "Retorna uma lista com todos os endereços cadastrados(preicsa estar autenticado")
	@GetMapping("/endereco")
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> end = new ArrayList<>();
		end = enderecoService.findAll();

		return ResponseEntity.ok(end);

	}

}
