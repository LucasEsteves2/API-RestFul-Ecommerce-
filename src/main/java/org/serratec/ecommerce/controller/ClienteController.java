package org.serratec.ecommerce.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.serratec.ecommerce.dto.CategoriaDTO;
import org.serratec.ecommerce.dto.ClienteDTO;
import org.serratec.ecommerce.dto.ClienteNewDTO;
import org.serratec.ecommerce.entity.Categoria;
import org.serratec.ecommerce.entity.Cliente;
import org.serratec.ecommerce.entity.Produto;
import org.serratec.ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = ("/clientes"))
public class ClienteController {

	@Autowired
	ClienteService service;

	@ApiOperation(value = "Retorna uma Lista de clientes sem os dados pessoais(cpf,senha)")
	@GetMapping
	public ResponseEntity<?> listarProdutos() {
		List<ClienteDTO> list = service.clientes();

		return ResponseEntity.ok(list);

	}

	@ApiOperation(value = "Busca por ID")
	@GetMapping("{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		Cliente obj = service.listar(id);

		return ResponseEntity.ok(obj);

	}

	@ApiOperation(value = "Remove Cliente")
	@DeleteMapping(value = ("/{id}"))
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}

	@ApiOperation(value = "Insere um novo Cliente")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto) {
		Cliente obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		// retorna o uri eo codigo http
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Atualiza Cliente")
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@Validated @RequestBody ClienteDTO objDto, @PathVariable Long id) {

		Cliente obj = service.fromDTO(objDto);
		obj.setId(id);
		service.update(obj);

		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Retorna a quantidade de Clientes cadastrados")
	@GetMapping("/count")

	public ResponseEntity<?> count() {

		return ResponseEntity.ok(service.count());

	}

	
	@ApiOperation(value = "Adiciona uma Foto de perfil( Amazon S3 bucket )")
	@PostMapping(value = "/imagem")
	public ResponseEntity<?> foto(@RequestParam(name = "file") MultipartFile file) {
		URI uri = service.fotoProduto(file);
		// retorna o uri eo codigo http
		return ResponseEntity.created(uri).build();

	}
	

	
}
