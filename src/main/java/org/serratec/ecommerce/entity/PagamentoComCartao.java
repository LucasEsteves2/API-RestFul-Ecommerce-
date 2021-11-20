package org.serratec.ecommerce.entity;

import javax.persistence.Entity;

import org.serratec.ecommerce.entity.enums.EstadoPagamento;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento{

	private Integer numeroDeParcelas;

	
	
	public PagamentoComCartao()
	{
		
		
	}



	public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido,Integer numeroDeParcelos) {
		super(id, estado, pedido);
		this.numeroDeParcelas=numeroDeParcelos;
	}



	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}



	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
