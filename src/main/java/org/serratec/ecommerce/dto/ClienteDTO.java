package org.serratec.ecommerce.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.serratec.ecommerce.entity.Cliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Length(min=5, max=150, message="O Tamanho do nome deve ser entre 5 e 150 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Email(message = "Email invalido")
	private String email;

	public ClienteDTO() {

	}

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
