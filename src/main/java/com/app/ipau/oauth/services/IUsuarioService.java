package com.app.ipau.oauth.services;

import com.app.ipau.commons.usuarios.models.entities.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);
	
	public Usuario update(Usuario usuario,Long id);

}
