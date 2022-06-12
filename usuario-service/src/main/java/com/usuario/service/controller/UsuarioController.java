package com.usuario.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entities.Usuario;
import com.usuario.service.servicio.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuariosService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuario(){
		List<Usuario>usuarios = usuariosService.getAll();
		if(usuarios.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id)
	{
		Usuario usuario = usuariosService.getUsuarioById(id);
		if(usuario == null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario)
	{
		Usuario nuevoUsuario = usuariosService.save(usuario);
		return ResponseEntity.ok(nuevoUsuario);
	}
	
	@DeleteMapping
	public ResponseEntity<Usuario> eliminarUsuarios()
	{
		usuariosService.deletAll();
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> eliminarUsuario(@PathVariable("id") int id)
	{
		Usuario usuario = usuariosService.getUsuarioById(id);
		if(usuario == null)
		{
			return ResponseEntity.notFound().build();
		}
		usuariosService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
