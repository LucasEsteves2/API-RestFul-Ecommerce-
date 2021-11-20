package org.serratec.ecommerce.services;

import java.util.Optional;

import org.serratec.ecommerce.entity.Endereco;
import org.serratec.ecommerce.exception.EnderecoNotFoundException;
import org.serratec.ecommerce.repositories.EnderecoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarEnderecoPorID {

	@Autowired
	private EnderecoRepositories enderecoRepositories;
	
	public Endereco buscarPorId(Long id) throws EnderecoNotFoundException {
		Optional<Endereco> optionalEndereco = getOptional(id);
		Endereco endereco = null;
		if(!optionalEndereco.isPresent()) {
			throw new EnderecoNotFoundException(
					"Endereco não encontrado através do ID: " + id);
		}else {
			endereco = optionalEndereco.get();
		}
		return endereco;
	}

	private Optional<Endereco> getOptional(Long id) {
		Optional<Endereco> optionalEndereco = enderecoRepositories.findById(id);
		return optionalEndereco;
	}
	
	public void deletarPorId(Long id) throws EnderecoNotFoundException {
		
		Optional<Endereco> optionalEndereco=getOptional(id);
		if(!optionalEndereco.isPresent()) {
			throw new EnderecoNotFoundException(
					"Endereco não encontrado através do ID: " + id);
		}else {
		
		enderecoRepositories.delete(optionalEndereco.get());
		}
	}
}
