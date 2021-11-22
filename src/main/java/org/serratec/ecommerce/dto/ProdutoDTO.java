package org.serratec.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.serratec.ecommerce.entity.Categoria;
import org.serratec.ecommerce.entity.Produto;

import com.fasterxml.jackson.annotation.JsonFormat;
public class ProdutoDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;


	@Length(min=5, max=80, message="O Tamanho do nome deve ser entre 5 e 80 caracteres")
	private String nome;
	@NotNull(message = " Valor Não pode ser nulo")
	private Double valor;
	@Length(min=5, max=80, message="O Tamanho da descrição deve ser entre 5 e 80 caracteres")
	private String descricao;
	@NotNull(message = " A quantidade Estoque Não pode ser nulo")
	private Integer qtd_estoque;
	
	private String urlImg;
	
	private Long idCategoria;
	
	
	
	public ProdutoDTO()
	{
		
	}
	public ProdutoDTO(Produto obj)
	{
		nome=obj.getNome();
		descricao= obj.getDesc();
		
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getQtd_estoque() {
		return qtd_estoque;
	}


	public void setQtd_estoque(Integer qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}



	public Long getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	
	
	
	
	
}
