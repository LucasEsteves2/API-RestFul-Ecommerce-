package org.serratec.ecommerce.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.ecommerce.entity.ItemPedido;
import org.serratec.ecommerce.entity.PagamentoComBoleto;
import org.serratec.ecommerce.entity.Pedido;
import org.serratec.ecommerce.entity.enums.EstadoPagamento;
import org.serratec.ecommerce.repositories.ItemPedidoRepository;
import org.serratec.ecommerce.repositories.PagamentoRepository;
import org.serratec.ecommerce.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public Pedido listar(Long id) {
		Optional<Pedido> cat = repo.findById(id);
		return cat.orElse(null);
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getData_pedido());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.buscar(ip.getProduto().getId()).getValor());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}

}
