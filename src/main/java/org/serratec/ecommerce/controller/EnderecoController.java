package org.serratec.ecommerce.controller;

import java.util.List;

import org.serratec.ecommerce.entity.Endereco;
import org.serratec.ecommerce.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereços")
public class EnderecoController {

	@Autowired
	EnderecoService service;

	@GetMapping
	public List<Endereco> findAll() {
		return service.findAll();
	}

	@GetMapping("/{cidade}")
	public List<Endereco> findCidade(@PathVariable String cidade) {

		return service.findCidade(cidade);

	}

}
