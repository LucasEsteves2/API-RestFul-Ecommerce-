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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService service;

	@ApiOperation(value = "Retorna uma lista com todos os Produtos")
	@GetMapping
	public ResponseEntity<?> listarProdutos() {
		List<Produto> list = service.listar();

		return ResponseEntity.ok(list);

	}

	@ApiOperation(value = "Busca por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscar(@PathVariable Long id) {

		Produto obj = service.buscar(id);

		return ResponseEntity.ok(obj);

	}

	@ApiOperation(value = "Busca um produto pelo Nome")
	@GetMapping(value = "/nome")
	public ResponseEntity<Produto> buscarNome(@RequestParam(value = "value") String nome) {
		Produto obj = service.findByNome(nome);
		return ResponseEntity.ok(obj);

	}

	@ApiOperation(value = "Insere um novo Produto")
	@PostMapping()
	public ResponseEntity<Produto> insert(@Valid @RequestBody ProdutoDTO objDto) {
		// convertendo o dto em uma classe
		Produto obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "Atualiza Produto ")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@RequestBody ProdutoDTO objDto, @PathVariable Long id) {
		Produto obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Remove Produto")
	@DeleteMapping(value = ("/{id}"))
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}

	@ApiOperation(value = "Adiciona imagens no servidor Amazon S3(bucket privado)")
	@PostMapping(value = "/imagem")
	public ResponseEntity<Produto> foto(@RequestParam(name = "file") MultipartFile file) {
		URI uri = service.fotoProduto(file);
		// retorna o uri eo codigo http
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "Retorna a quantidade de produtos")
	@GetMapping("/count")

	public ResponseEntity<?> count() {

		return ResponseEntity.ok(service.count());

	}
	
	
	

}