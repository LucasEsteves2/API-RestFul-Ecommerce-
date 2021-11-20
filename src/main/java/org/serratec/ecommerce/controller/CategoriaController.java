package org.serratec.ecommerce.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.serratec.ecommerce.dto.CategoriaDTO;
import org.serratec.ecommerce.entity.Categoria;
import org.serratec.ecommerce.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService service;

	@ApiOperation(value="Retorna todas as Categorias")
	@GetMapping()
	public ResponseEntity<List<CategoriaDTO>> categorias() {

		// pegando todas as categorias
		List<Categoria> list = service.categorias();
		// atribuindo com lambda (poderia usar uma foreach
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);

	}

	@ApiOperation(value="Busca uma categoria pelo Id e retorna seus produtos associados")
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> listar(@PathVariable Long id) {
		Categoria cat = service.buscar(id);
		return ResponseEntity.ok(cat);

	}
	@ApiOperation(value="Remove Categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
			@ApiResponse(code = 404, message = "Código inexistente") } )
	@DeleteMapping(value = ("/{id}"))
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	@ApiOperation(value="Insere uma nova Categoria")
	@PostMapping()
	public ResponseEntity<Categoria> insert(@Valid @RequestBody CategoriaDTO objDto) {
		// convertendo o dto em uma classe
		Categoria obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	
	@ApiOperation(value="Atualiza Categoria")
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@Validated @RequestBody CategoriaDTO objDto, @PathVariable Long id) {

		Categoria obj = service.fromDTO(objDto);
		obj.setId(id);
		service.update(obj);

		return ResponseEntity.noContent().build();
	}

}
