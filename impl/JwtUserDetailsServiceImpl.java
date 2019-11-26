package com.oliveira.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oliveira.api.security.entities.Usuario;

@Service
public class JwtUserDetailsServiceImpl {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws  UsernameNotFoundException {
		Optional<Usuario> funcionario = usuarioService.buscaPorEmail(username);
		
		if (funcionario.isPresent()) {
			return JwtUserFactory.create(funcionario.get());
		}
		
		throw new UsernameNotFoundException("Email não encontrado");
	}

}
