package org.serratec.ecommerce.services;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.serratec.ecommerce.dto.ProdutoDTO;
import org.serratec.ecommerce.entity.Categoria;
import org.serratec.ecommerce.entity.Produto;
import org.serratec.ecommerce.repositories.ProdutoRepository;
import org.serratec.ecommerce.services.exceptions.DataIntegrityException;
import org.serratec.ecommerce.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;

	@Autowired
	CategoriaService serviceCategoria;

	@Autowired
	private S3Service s3service;

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

	public void delete(Long id) {
		buscar(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um produto que possua uma Categoria ");
		}

	}

	// converte o dto em objt
	public Produto fromDTO(ProdutoDTO objDto) {

		Categoria cat = serviceCategoria.buscar(objDto.getIdCategoria());

		Produto prod = new Produto(null, objDto.getNome(), objDto.getValor(), objDto.getDescricao(),
				objDto.getQtd_estoque(), new Date(), cat, null);

		prod.setUrlImagem(objDto.getUrlImg());

		cat.getProduto().add(prod);

		serviceCategoria.update(cat);
		return prod;

	}

	public Page<Produto> search(String nome, List<Long> ids, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		return null;
		// PageRequest pageRequest = new PageRequest
	}

	public URI fotoProduto(MultipartFile multi) {
		return s3service.uploadFile(multi);
	}

	public Produto findByNome(String nome) {
		return repo.findByNome(nome);
	}

	public Long count() {
		return repo.count();
	}

	public void salvar(List<Produto> produtos) {
		repo.saveAll(produtos);
	}

}
