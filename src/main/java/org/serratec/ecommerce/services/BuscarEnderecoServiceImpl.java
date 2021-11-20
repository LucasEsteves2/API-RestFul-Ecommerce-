package org.serratec.ecommerce.services;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.serratec.ecommerce.entity.Endereco;
import org.serratec.ecommerce.repositories.EnderecoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarEnderecoServiceImpl {
	
	private static final org.jboss.logging.Logger LOG = org.jboss.logging.Logger.  //remover após teste
			getLogger(BuscarEnderecoServiceImpl.class);

	@Autowired
	private EnderecoRepositories EnderecoRepositories; 
	
	public List<Endereco> buscarTodosOsEnderecos(){
		LOG.info("Servico para buscar todos os enderecos sendo executado.");
		List<Endereco> listEndereco = EnderecoRepositories.findAll();
		return listEndereco;
	}
{
		
	}

}
