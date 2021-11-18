package org.serratec.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.serratec.ecommerce.dto.ProdutoDTO;
import org.serratec.ecommerce.entity.Produto;
import org.serratec.ecommerce.repositories.ProdutoRepository;
import org.serratec.ecommerce.services.exceptions.DataIntegrityException;
import org.serratec.ecommerce.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;

	public List<Produto> listar() {
		return repo.findAll();
	}

	public Produto buscar(Long id) {
		Optional<Produto> obj = repo.findById(id);

		// lançando exception
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));

	}

	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);

	}

	public Produto update(Produto obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}


}
