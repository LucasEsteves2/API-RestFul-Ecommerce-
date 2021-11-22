package org.serratec.ecommerce.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.ecommerce.dto.ClienteDTO;
import org.serratec.ecommerce.dto.ClienteNewDTO;
import org.serratec.ecommerce.entity.Cliente;
import org.serratec.ecommerce.entity.Endereco;
import org.serratec.ecommerce.repositories.ClienteRepository;
import org.serratec.ecommerce.repositories.EnderecoRepository;
import org.serratec.ecommerce.security.UserSS;
import org.serratec.ecommerce.services.exceptions.AuthorizationException;
import org.serratec.ecommerce.services.exceptions.DataIntegrityException;
import org.serratec.ecommerce.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ClienteService {
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private ClienteRepository repo;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private S3Service s3Service;

	public Cliente listar(Long id) {
		Optional<Cliente> obj = repo.findById(id);
		// lançando exception
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

	}

	public List<Cliente> findAll()
	{
		return repo.findAll();
	}
	
	public Cliente buscar(Long id) {
		Optional<Cliente> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

	}

	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;

	}

	public Cliente update(Cliente obj) {
		Cliente novoObj = buscar(obj.getId());

		// atualiza somente os campos nome e-email
		upddateData(novoObj, obj);

		return repo.save(novoObj);
	}

	public void delete(Long id) {
		buscar(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir porque há pedidos relacionados ");

		}

	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null, null, null);
	}

	public Cliente fromDTO(ClienteNewDTO objDto) {

		Cliente cliente = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpf(),
				objDto.getNome_usuario(), pe.encode(objDto.getSenha()), objDto.getData_nasc(), null);
		Endereco endereco = new Endereco(null, objDto.getRua(), objDto.getComplemento(), objDto.getBairro(),
				objDto.getCep(), objDto.getNumero(), cliente, objDto.getCidade());

		cliente.getEnderecos().add(endereco);
		cliente.getTelefones().add(objDto.getTelefone1());

		// verificando se o cliente possui +de 1 telefone
		if (objDto.getTelefone2() != null) {

			cliente.getTelefones().add(objDto.getTelefone2());

		}
		return cliente;

	}

	private void upddateData(Cliente novoObj, Cliente obj) {
		novoObj.setNome(obj.getNome());
		novoObj.setEmail(obj.getEmail());

	}

	public List<ClienteDTO> clientes() {

		List<Cliente> lista = new ArrayList<>();
		lista = repo.findAll();

		List<ClienteDTO> listaDTO = new ArrayList<>();

		for (Cliente x : lista) {

			listaDTO.add(new ClienteDTO(x));
		}

		return listaDTO;

	}

	public Long count() {
		return repo.count();
	}

	public URI fotoProduto(MultipartFile multi) {

	

		UserSS user = UserService.authenticated();
		if (user == null) throw new AuthorizationException("Acesso negado!");
		

	
		URI uri = s3Service.uploadFile(multi);
		Cliente cli = buscar(user.getId());
		cli.setUrlFotoPerfil(uri.toString());

		repo.save(cli);

		return uri;
	
	}

}
