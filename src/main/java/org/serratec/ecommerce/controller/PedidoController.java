package org.serratec.ecommerce.controller;

import java.net.URI;

import javax.validation.Valid;

import org.serratec.ecommerce.entity.Pedido;
import org.serratec.ecommerce.entity.Pedido;
import org.serratec.ecommerce.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoService service;

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> listar(@PathVariable Long id) {

		System.out.println();
		Pedido obj = service.listar(id);

		return ResponseEntity.ok(obj);

	}

	@PostMapping()
	public ResponseEntity<Pedido> insert(@Valid @RequestBody Pedido obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

}
