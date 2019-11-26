package com.oliveira.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveira.api.security.entities.Usuario;
import com.oliveira.api.security.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> buscaPorEmail(String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}

}
