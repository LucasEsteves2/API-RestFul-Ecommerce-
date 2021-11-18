package org.serratec.ecommerce.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido {

	
	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_pedido;

	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	
	private Endereco enderecoEntegra;
	
	
	private Pagamento pagamento;

	private Set<ItemPedido> itens = new HashSet<>();
	
	public Pedido()
	{
		
	}

	public Pedido(Long id, Date instante, Cliente cliente, Endereco enderecoEntegra ) {
		super();
		this.id = id;
		this.data_pedido = instante;
		this.cliente = cliente;
		this.enderecoEntegra = enderecoEntegra;
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInstante() {
		return data_pedido;
	}

	public void setInstante(Date instante) {
		this.data_pedido = instante;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoEntegra() {
		return enderecoEntegra;
	}

	public void setEnderecoEntegra(Endereco enderecoEntegra) {
		this.enderecoEntegra = enderecoEntegra;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
	
	
}
