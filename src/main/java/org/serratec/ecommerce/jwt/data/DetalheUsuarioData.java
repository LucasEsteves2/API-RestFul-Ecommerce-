package org.serratec.ecommerce.jwt.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import expertostech.autenticacao.jwt.model.UsuarioModel;

public class DetalheUsuarioData implements UserDetails {

	private Optional<UsuarioModel> usuario;
	
	
	public DetalheUsuarioData(Optional<UsuarioModel> usuario) {
		this.usuario=usuario;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usuario.orElse(new UsuarioModel()).getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario.orElse(new UsuarioModel()).getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
