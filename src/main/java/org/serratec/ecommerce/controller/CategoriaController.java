package org.serratec.ecommerce.controller;

import java.util.List;

import org.serratec.ecommerce.entity.Categoria;
import org.serratec.ecommerce.services.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService CategoriaService;


	@GetMapping
	public List<Categoria> listarTodos(){
		return CategoriaService.listartodos();
	}
	
	@GetMapping("/{id_categoria}")
	public ResponseEntity<Categoria> pesquisarPorId(@PathVariable Integer id_categoria){
		Categoria categoria = CategoriaService.pegar(id_categoria);
		if(null != categoria) {
			return ResponseEntity.ok(categoria);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria criar(@RequestBody Categoria categoria){
		categoria = CategoriaService.inserir(categoria);
		return categoria;
	}
	
	@PutMapping("/{id_categoria}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Integer id_categoria, @RequestBody Categoria categoriaConsulta){
		Categoria categoria = CategoriaService.atualizarPeloId(id_categoria, categoriaConsulta );
        return ResponseEntity.ok(categoria);
      
    }
	@DeleteMapping("{id_categoria}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id_categoria){
		CategoriaService.deletarPorId(id_categoria);
		return ResponseEntity.noContent().build();
	}
}

