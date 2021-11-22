package org.serratec.ecommerce.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
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
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(name = "valor_unitario")
	private Double valor;
	private String descricao;
	
	private Integer qtd_estoque;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_cadastro;
	
	private String urlImagem;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();

	public Produto() {

	}

	public Produto(java.lang.Long id, String nome, Double valor, String descricao, Integer qtd_estoque,
			Date data_cadastro, Categoria categoria, Set<ItemPedido> itens) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
		this.qtd_estoque = qtd_estoque;
		this.data_cadastro = data_cadastro;
		this.categoria = categoria;
		this.itens = itens;
	}

	public Produto(Long id, String nome, Double valor, String desc) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.descricao = desc;
	}

	@JsonIgnore
	public List<Pedido> getPedidos() {
		List<Pedido> lista = new ArrayList<>();
		for (ItemPedido x : itens) {
			lista.add(x.getPedido());
		}
		return lista;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void Long(Long id) {
		this.id = id;
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

	public String getDesc() {
		return descricao;
	}

	public void setDesc(String desc) {
		this.descricao = desc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public Integer getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(Integer qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

}
