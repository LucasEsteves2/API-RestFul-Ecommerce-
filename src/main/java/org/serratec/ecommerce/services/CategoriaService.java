package org.serratec.ecommerce.services;


import java.util.List;

import org.serratec.ecommerce.entity.Categoria;
import org.serratec.ecommerce.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;


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
	    public Categoria pegar(Integer id_categoria) {
	    	return CategoriaRepository.findById(id_categoria).get();
	    }
	    
	    //POST - ADICIONAR
	    public Categoria inserir(Categoria categoria){
			CategoriaRepository.save(categoria);
			return categoria;
		}
	    
	    //PUT - TROCAR POR ID
	    public Categoria atualizarPeloId(Integer id_categoria, Categoria categoriaConsulta){
	    	Categoria categoria = pegar(id_categoria);
	        categoria.setNome(categoriaConsulta.getNome());
	        categoria.setDescricao(categoriaConsulta.getDescricao());
	        return CategoriaRepository.save(categoria);
	    }

	    //DELETE - DELETAR
	    public void deletarPorId( Integer id_categoria){
	    	//pegar(id_categoria);
	     CategoriaRepository.deleteById(id_categoria);
	   
	    }
}
