package com.oliveira.api.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.oliveira.api.security.entities.Usuario;
import com.oliveira.api.security.enums.PerfilEnum;

public class JwtUserFactory {
	
	private JwtUserFactory() {
		
	}

	/**
	 * Converte e gera um JwtUser com base nos dados de um funcionario.
	 * 
	 * @param usuario
	 * @return
	 */
	public static JwtUser crate(Usuario usuario) {
		return new JwtUser(usuario.getId(), usuario.getEmail(), usuario.getSenha(), 
				mapToGrantedAuthorities(usuario.getPerfil()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(com.oliveira.api.enums.PerfilEnum perfilEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities;
	}
	
}
