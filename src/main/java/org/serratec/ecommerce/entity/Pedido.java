package org.serratec.ecommerce.entity;

import java.util.Date;
import java.util.HashSet;
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

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data_pedido;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data_entega;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data_envio;
	private String status;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	
	@OneToMany(mappedBy = "id.pedido")
	//garantindo que nao se repita
	Set<ItemPedido> itens = new HashSet<ItemPedido>();
	
	


	public Pedido() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}

	public Date getData_entega() {
		return data_entega;
	}

	public void setData_entega(Date data_entega) {
		this.data_entega = data_entega;
	}

	public Date getData_envio() {
		return data_envio;
	}

	public void setData_envio(Date data_envio) {
		this.data_envio = data_envio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

}
