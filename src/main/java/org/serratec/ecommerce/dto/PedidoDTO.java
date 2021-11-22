package org.serratec.ecommerce.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.serratec.ecommerce.entity.Cliente;
import org.serratec.ecommerce.entity.Endereco;
import org.serratec.ecommerce.entity.ItemPedido;
import org.serratec.ecommerce.entity.Pagamento;
import org.serratec.ecommerce.entity.Pedido;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PedidoDTO {

	private Date data_pedido;

	private Long idcliente;

	private Long idProduto;

	private Pagamento pagamento;

	public PedidoDTO() {

	}

	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

}
