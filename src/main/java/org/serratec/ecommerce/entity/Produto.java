package org.serratec.ecommerce.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	private String qtd_estoque;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data_Cadastro;
	
	private Double valor_unitario;
	private String imagem;

	//private categoria
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	@JsonIgnore

	@OneToMany(mappedBy = "id.pedido")
	Set<ItemPedido> itens = new HashSet<ItemPedido>();

	
	
	public Produto()
	{
		
	}

	@JsonIgnore
	//pegando a lista de pedidos do produto
	public List<Pedido> getPedidos()
	{
		List<Pedido> lista = new ArrayList<Pedido>();
		for (ItemPedido x : itens) {
			lista.add(x.getPedido());
			
		}
		return lista;
	}
	 
	public Set<ItemPedido> getItens() {
		return itens;
	}


	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
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


	public String getQtd_estoque() {
		return qtd_estoque;
	}


	public void setQtd_estoque(String qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}


	public Date getData_Cadastro() {
		return data_Cadastro;
	}


	public void setData_Cadastro(Date data_Cadastro) {
		this.data_Cadastro = data_Cadastro;
	}


	public Double getValor_unitario() {
		return valor_unitario;
	}


	public void setValor_unitario(Double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
	
	
	
	
}
