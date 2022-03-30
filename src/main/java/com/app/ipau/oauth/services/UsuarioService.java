package com.app.ipau.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.ipau.commons.usuarios.models.entities.Usuario;
import com.app.ipau.oauth.clients.UsuarioFeignClient;

@Service
public class UsuarioService implements UserDetailsService, IUsuarioService {
	
	@Autowired
	private UsuarioFeignClient client;

	@Override
	public Usuario findByUsername(String username) {
		return client.getUsername(username);
	}

	@Override
	public Usuario update(Usuario usuario, Long id) {
		return client.actualizar(usuario, id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Usuario usuario = client.getUsername(username);
			System.out.println("********************* USUARIO *********************** " + usuario.getEmail());
			List<GrantedAuthority> authorities = usuario.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
			return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
					authorities);
		}catch(Exception e) {
			e.printStackTrace();
			String error = "Error en el login, no existe el usuario " + username + " en el sistema";
			System.out.println("ERROR AL BUSCAR USUARIO *********************** "+error);
			throw new UsernameNotFoundException(
					"Error en el login, no existe el usuario " + username + " en el sistema");
		}
	}

}
