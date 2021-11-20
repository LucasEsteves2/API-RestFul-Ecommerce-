package org.serratec.ecommerce.dto;



import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.serratec.ecommerce.entity.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id_cadastro;
	
	@Length(min=5, max=80, message="O Tamanho do nome deve ser entre 5 e 80 caracteres")
	private String nome;
	
	@Length(min=5, max=80, message="O Tamanho da descrição deve ser entre 5 e 80 caracteres")
	private String descricao;

	public CategoriaDTO() {
		super();
	}
	
	public CategoriaDTO(Categoria obj)
		{
			setId_cadastro(obj.getId_categoria());
			nome=obj.getNome();
			descricao=obj.getDescricao();
			
		}

	public Long getId_cadastro() {
		return id_cadastro;
	}

	public void setId_cadastro(Long id_cadastro) {
		this.id_cadastro = id_cadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	
	
}
