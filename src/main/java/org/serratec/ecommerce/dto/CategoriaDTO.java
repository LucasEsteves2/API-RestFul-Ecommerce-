package org.serratec.ecommerce.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.serratec.ecommerce.entity.Categoria;
import javax.validation.constraints.NotEmpty;
public class CategoriaDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String banana;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Length(min=5, max=80, message="O Tamanho do nome deve ser entre 5 e 80 caracteres")
	private String nome;
	@Length(min=4, max=80, message="O Tamanho da Descrição deve ser entre 4 e 100 caracteres")
	private String descricao;
	
	public CategoriaDTO()
	{
		
	}
	
	public CategoriaDTO(Categoria obj)
	{
		nome=obj.getNome();
		descricao= obj.getDescricao();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
