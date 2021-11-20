package org.serratec.ecommerce.entity;

import java.util.Date;

import javax.persistence.Entity;

import org.serratec.ecommerce.entity.enums.EstadoPagamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("pagamentoComBoleto")
public class PagamentoComBoleto extends Pagamento {
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataVencimento;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataPagamento;
	
	public PagamentoComBoleto()
	{
		
	}

	public PagamentoComBoleto(Long id, EstadoPagamento estado, Pedido pedido,Date dataPagamento, Date dataVencimento) {
		super(id, estado, pedido);
		this.dataPagamento=dataPagamento;
		this.dataVencimento=dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
