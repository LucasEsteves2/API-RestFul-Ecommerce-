package org.serratec.ecommerce.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.ecommerce.dto.PedidoDTO;
import org.serratec.ecommerce.entity.Cliente;
import org.serratec.ecommerce.entity.ItemPedido;
import org.serratec.ecommerce.entity.PagamentoComBoleto;
import org.serratec.ecommerce.entity.Pedido;
import org.serratec.ecommerce.entity.Produto;
import org.serratec.ecommerce.entity.enums.EstadoPagamento;
import org.serratec.ecommerce.repositories.ItemPedidoRepository;
import org.serratec.ecommerce.repositories.PagamentoRepository;
import org.serratec.ecommerce.repositories.PedidoRepository;
import org.serratec.ecommerce.services.exceptions.DataIntegrityException;
import org.serratec.ecommerce.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	@Autowired
	private ClienteService clienteService;

	public List<Pedido> listarTosos() {
		return repo.findAll();
	}


	public Pedido listar(Long id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
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

	public void delete(Long id) {
		listar(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possivel excluir um pedido que ja tenha sido VALIDADO(REGRA DE NEGOCIo)!! ");

		}

	}

	public Long count() {
		return repo.count();
	}

	public Pedido fromDTO(PedidoDTO objDto) {

		Cliente cliente = clienteService.buscar(objDto.getIdcliente());
		Pedido pedido = new Pedido(null, objDto.getData_pedido(), cliente, cliente.getEnderecos().get(1));
		Produto produto = produtoService.buscar(objDto.getIdProduto());

		ItemPedido item = new ItemPedido(pedido, produto, null, null, null);

		pedido.setPagamento(objDto.getPagamento());
		pedido.setData_pedido(objDto.getData_pedido());
		pedido.setInstante(null);
		pedido.getItens().add(item);
		return pedido;

	}

}
