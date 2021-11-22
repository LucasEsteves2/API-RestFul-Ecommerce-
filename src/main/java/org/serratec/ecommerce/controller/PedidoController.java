package org.serratec.ecommerce.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.serratec.ecommerce.dto.ProdutoDTO;
import org.serratec.ecommerce.entity.Cliente;
import org.serratec.ecommerce.entity.Pedido;
import org.serratec.ecommerce.entity.Produto;
import org.serratec.ecommerce.entity.Pedido;
import org.serratec.ecommerce.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoService service;


	

	@ApiOperation(value = "Busca pedido pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> listar(@PathVariable Long id) {

		System.out.println();
		Pedido obj = service.listar(id);

		return ResponseEntity.ok(obj);

	}
	@ApiOperation(value = "Insere um novo Pedido")
	@PostMapping()
	public ResponseEntity<Pedido> insert(@Valid @RequestBody Pedido obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "Remove Pedido")
	@DeleteMapping(value = ("/{id}"))
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}

	@ApiOperation(value = "Retorna a quantidade de Pedidos")
	@GetMapping("/count")

	public ResponseEntity<?> count() {

		return ResponseEntity.ok(service.count());

	}

}
