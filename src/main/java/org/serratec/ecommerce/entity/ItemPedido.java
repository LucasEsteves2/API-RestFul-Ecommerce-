package org.serratec.ecommerce.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido {

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPk id = new ItemPedidoPk();

	private String preco_venda;
	private String quantidade;

	public ItemPedido() {

	}

	public ItemPedido(Pedido pedido, Produto produto, String preco_venda, String quantidade) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.preco_venda = preco_venda;
		this.quantidade = quantidade;
	}
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public ItemPedidoPk getId() {
		return id;
	}

	public void setId(ItemPedidoPk id) {
		this.id = id;
	}

	public String getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(String preco_venda) {
		this.preco_venda = preco_venda;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
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
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}

}
