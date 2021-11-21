package org.serratec.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.serratec.ecommerce.dto.CategoriaDTO;
import org.serratec.ecommerce.entity.Categoria;
import org.serratec.ecommerce.repositories.CategoriaRepository;
import org.serratec.ecommerce.services.exceptions.DataIntegrityException;
import org.serratec.ecommerce.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;

	public List<Categoria> categorias() {
		return repo.findAll();
	}

	public Categoria buscar(Long id) {
		Optional<Categoria> obj = repo.findById(id);

		// lançando exception
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));

	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);

	}

	public Categoria update(Categoria obj) {
		Categoria novoObj = buscar(obj.getId());

		// atualiza somente os campos nome e-email
		upddateData(novoObj, obj);

		return repo.save(novoObj);
	}

	public void delete(Long id) {
		buscar(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos ");

		}

	}

	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(null, objDto.getNome(), objDto.getDescricao());
	}

	private void upddateData(Categoria novoObj, Categoria obj) {
		novoObj.setNome(obj.getNome());
		novoObj.setDescricao(obj.getDescricao());

	}

	public Categoria buscarNome(String nome) {
		Categoria obj = repo.findByNome(nome);

		if (obj != null) {
			return obj;
		} else {
			throw new ObjectNotFoundException(
					"Categoria não encontrada! Nome: " + nome + ", Tipo: " + Categoria.class.getName());
		}
	}
	
	
	
	public Long count() {
		return repo.count();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage,
			String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
				Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
