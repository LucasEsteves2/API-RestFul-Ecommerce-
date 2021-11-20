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
import org.springframework.stereotype.Service;


	@Service
	public class CategoriaService {
	    @Autowired
	    private CategoriaRepository CategoriaRepository;
	    
	    // GET - BUSCAR TODOS
	    public List<Categoria> listartodos(){
			return CategoriaRepository.findAll();
		}
	    
	    //GET - PEGAR POR ID
	    public Categoria pegar(Long id_categoria) {
	    	Optional<Categoria> categoria =  CategoriaRepository.findById(id_categoria);
	    	
	    	// Lançando exception
			return categoria.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id_categoria + ", Tipo: " + Categoria.class.getName()));
	    }
	    
	    //POST - ADICIONAR
	    public Categoria inserir(Categoria categoria){
			CategoriaRepository.save(categoria);
			return categoria;
		}
	    
	    //PUT - TROCAR POR ID
	    public Categoria atualizarPeloId(Long id_categoria, Categoria categoriaConsulta){
	    	Categoria categoria = pegar(id_categoria);
	        categoria.setNome(categoriaConsulta.getNome());
	        categoria.setDescricao(categoriaConsulta.getDescricao());
	        return CategoriaRepository.save(categoria);
	    }

	    //DELETE - DELETAR
	    public void deletarPorId( Long id_categoria){
	    	pegar(id_categoria);
	    	try {
	     CategoriaRepository.deleteById(id_categoria);
	    	} catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possivel excluir uma categoria que possua produtos!! ");
			}	   
	    	
	    }
	 // Converte o DTO em Objeto
		public Categoria fromDTO(CategoriaDTO objDTO) {
			return new Categoria(objDTO.getId_cadastro(), objDTO.getNome(), objDTO.getDescricao(), null);

		}
}
