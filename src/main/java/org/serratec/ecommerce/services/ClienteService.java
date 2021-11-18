package org.serratec.ecommerce.services;

import java.util.List;
import java.util.Optional;
import org.serratec.ecommerce.entity.Cliente;
//import org.serratec.ecommerce.exception.EmailException;
import org.serratec.ecommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	//private BCryptPasswordEncoder passwordEncoder;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	

	
	public ResponseEntity<Cliente> buscaId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	

	public ResponseEntity<Cliente> atualizar(Long id, Cliente cliente) {

		Optional<Cliente> clienteN = clienteRepository.findById(id);

		if (clienteN.isPresent()) {
			if (null != cliente.getNome_completo()) {
				clienteN.get().setNome_completo(cliente.getNome_completo());
			}
			if (null != cliente.getNome_usuario()) {
				clienteN.get().setNome_usuario(cliente.getNome_usuario());
			}
			if (null != cliente.getEmail()) {
				clienteN.get().setEmail(cliente.getEmail());
			}
			if (null != cliente.getSenha()) {
				clienteN.get().setSenha(cliente.getSenha());
			}
			if (null != cliente.getCpf()) {
				clienteN.get().setCpf(cliente.getCpf());
			}
			if (null != cliente.getData_nasc()) {
				clienteN.get().setData_nasc(cliente.getData_nasc());
			}
			if (null != cliente.getTelefone()) {
				clienteN.get().setTelefone(cliente.getTelefone());
			}
		} else {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente = clienteRepository.save(clienteN.get()));
	}
	

	public ResponseEntity<Void> deletarPorId(Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}


	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}
	
	
}
