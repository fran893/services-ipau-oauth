package com.app.ipau.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.ipau.commons.usuarios.models.entities.Usuario;

@FeignClient(name = "services-usuarios")
public interface UsuarioFeignClient {
	
	@PutMapping("/updateUser/{idUser}")
	public Usuario actualizar(@RequestBody Usuario usuario, @PathVariable Long idUser);
	
	@GetMapping("/getUsername/{username}")
	public Usuario getUsername(@PathVariable String username);

}
