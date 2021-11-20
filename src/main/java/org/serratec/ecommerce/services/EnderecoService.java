package org.serratec.ecommerce.services;

import java.util.Optional;

import org.serratec.ecommerce.entity.Endereco;
import org.serratec.ecommerce.repositories.EnderecoRepository;
import org.serratec.ecommerce.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;

	public Endereco listar(Long id) {
		Optional<Endereco> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado"));

	}

}
