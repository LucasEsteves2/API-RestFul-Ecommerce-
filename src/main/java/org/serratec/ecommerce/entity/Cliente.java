package org.serratec.ecommerce.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;



@Entity
@Table(name = "cliente", schema = "public")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Preencha o nome de usuario")
	@Column(name = "nome_usuario")
	@Size(max = 20)
	private String nome_usuario;
	
	@NotBlank(message = "Preencha o nome completo")
	@Column(name = "nome_completo")
	@Size(max = 50)
	private String nome_completo;
	
	@NotBlank(message = "Informe um E-mail")
	@Email(message = "E-mail Inválido")
	@Column(name = "email")
	@Size(max = 50)
	private String email;
	
	@NotBlank(message = "Informe uma senha")
	@Column(name = "senha")
	@Size(min = 8)
	private String senha;
	
	@NotBlank(message = "Informe um CPF válido")
	@CPF(message = "CPF Inválido")
	@Column(name = "cpf")
	@Size(max = 15)
	private String cpf;
	
	@Column(name = "data_nasc", unique = true, nullable = false)
	private LocalDate data_nasc;
	
	@Column(name = "telefone")
	@Size(max = 20)
	private String telefone;
	
	public Cliente() {
		
	}
	
	public Cliente(Long id, String nome_usuario, String nome_completo, String email, String senha, String cpf,
			LocalDate data_nasc, String telefone) {
		
		this.id = id;
		this.nome_usuario = nome_usuario;
		this.nome_completo = nome_completo;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.data_nasc = data_nasc;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome_usuario=" + nome_usuario + ", nome_completo=" + nome_completo + ", email="
				+ email + ", senha=" + senha + ", cpf=" + cpf + ", data_nasc=" + data_nasc + ", telefone=" + telefone
				+ "]";
	}
	
}
