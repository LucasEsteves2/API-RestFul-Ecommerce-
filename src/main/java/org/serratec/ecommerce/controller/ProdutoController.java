package org.serratec.ecommerce.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.serratec.ecommerce.dto.ProdutoDTO;
import org.serratec.ecommerce.entity.Produto;
import org.serratec.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService service;

	// LISTA TODOS OS PRODUTOS SEM SEUS PEDIDOS
	@GetMapping
	public ResponseEntity<?> listarProdutos() {
		List<Produto> list = service.listar();

		return ResponseEntity.ok(list);

	}

	// LISTA PRODUTO POR ID
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscar(@PathVariable Long id) {

		Produto cat = service.buscar(id);

		return ResponseEntity.ok(cat);

	}

	@PostMapping()
	public ResponseEntity<Produto> insert(@Valid @RequestBody ProdutoDTO objDto) {
		// convertendo o dto em uma classe
		Produto obj = service.fromDTO(objDto);
		obj = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		// retorna o uri eo codigo http
		return ResponseEntity.created(uri).build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@RequestBody ProdutoDTO objDto, @PathVariable Long id) {
		Produto obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = ("/{id}"))
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}

}
