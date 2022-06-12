package com.usuario.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.service.entities.Usuario;
import com.usuario.service.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAll()
	{
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuarioById(int id)
	{
		return usuarioRepository.findById(id).orElse(null);
	}
	
	
	public Usuario save(Usuario usuario)
	{
		return usuarioRepository.save(usuario);
	}
	
	public void deletAll()
	{
		usuarioRepository.deleteAll();
	}
	
	public void deleteById(int id)
	{
		usuarioRepository.deleteById(id);
	}
}
