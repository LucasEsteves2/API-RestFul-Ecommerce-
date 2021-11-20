package org.serratec.ecommerce.controller;

import java.util.List;

import org.serratec.ecommerce.entity.Endereco;
import org.serratec.ecommerce.exception.EnderecoNotFoundException;
import org.serratec.ecommerce.repositories.EnderecoRepositories;
import org.serratec.ecommerce.services.BuscarEnderecoPorID;
import org.serratec.ecommerce.services.BuscarEnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepositories EnderecoRepositories; 
	
	@Autowired
		private BuscarEnderecoServiceImpl serviceBuscar;
	
	@Autowired
	private BuscarEnderecoPorID serviceBuscarPorId;

	@GetMapping(path = "/endereco")
	public List<Endereco> buscarEnderecoPorId(){
		return  serviceBuscar.buscarTodosOsEnderecos();
	}
	
	@GetMapping(path = "/endereco/id/{id}")
	public Endereco buscarEnderecoPorId(
			@PathVariable (name = "id", required = true) Long id) throws EnderecoNotFoundException{
		return serviceBuscarPorId.buscarPorId(id);
	}
	
	@PostMapping(path = "endereco/save")
	public void salvarEndereco(@RequestBody Endereco endereco) {
		EnderecoRepositories.save(endereco);
	}
	
	@DeleteMapping(path = "endereco/delete/{id}")
	public void deleteEndereco(@PathVariable(name = "id", required = true) Long id) throws EnderecoNotFoundException {
		serviceBuscarPorId.deletarPorId(id);
	}
	}
