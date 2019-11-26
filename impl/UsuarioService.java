package com.oliveira.api.security.services.impl;

import java.util.Optional;

import com.oliveira.api.security.entities.Usuario;

public interface UsuarioService {

	/**
	 * Busca e retorna um usuario dado um email.
	 * 
	 * @param email
	 * @return
	 */
	Optional<Usuario> buscaPorEmail(String email);
}
