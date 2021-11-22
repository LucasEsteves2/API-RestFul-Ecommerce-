package org.serratec.ecommerce.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteNewDTO {

	// CLIENTE
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Length(min = 5, max = 80, message = "O Tamanho do nome deve ser entre 5 e 80 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatorio")
	@Email(message = "Email invalido")
	@Column(unique = true)
	private String email;

	@CPF
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cpf;


	@NotEmpty(message = "Preenchimento obrigatorio")
	private String nome_usuario;

	@NotEmpty(message = "Preenchimento obrigatorio")
	private String senha;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data_nasc;

	// ENDERECO
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String rua;
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String complemento;
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String bairro;

	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cep;

	private Integer numero;
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cidade;
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String telefone1;
	private String telefone2;

	public ClienteNewDTO() {

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
