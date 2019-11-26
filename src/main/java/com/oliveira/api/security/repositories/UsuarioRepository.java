package com.oliveira.api.security.repositories;

import javax.transaction.Transactional;

import com.oliveira.api.security.entities.Usuario;

@Transactional(readOnly = true)
public class UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail (String email);

}
