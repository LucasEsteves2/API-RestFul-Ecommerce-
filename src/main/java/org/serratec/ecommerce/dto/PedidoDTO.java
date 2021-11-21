package org.serratec.ecommerce.dto;

public class PedidoDTO {

	private long idCliente;
	private long idProduto;
	private Integer quantidade;
	
	
	
	public PedidoDTO() {
		
	}



	public long getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}



	public long getIdProduto() {
		return idProduto;
	}



	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}



	public Integer getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
	
	
	
}
