package com.carro.service.controller;

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

import com.carro.service.entities.Carro;
import com.carro.service.servicio.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	@Autowired
	private CarroService carroService;

	@GetMapping
	public ResponseEntity<List<Carro>> listarUsuario() {
		List<Carro> carros = carroService.getAll();
		if (carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> obtenerUsuario(@PathVariable("id") int id)
	{
		Carro carro = carroService.getCarroById(id);
		if(carro == null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carro);
	}
	
	@PostMapping
	public ResponseEntity<Carro> guardarUsuario(@RequestBody Carro usuario)
	{
		Carro nuevoCarro = carroService.save(usuario);
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@DeleteMapping
	public ResponseEntity<Carro> eliminarUsuarios()
	{
		carroService.deletAll();
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Carro> eliminarUsuario(@PathVariable("id") int id)
	{
		Carro carro = carroService.getCarroById(id);
		if(carro == null)
		{
			return ResponseEntity.notFound().build();
		}
		carroService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarrosByUserId(@PathVariable("usuarioId") int id)
	{
		List<Carro> carros = carroService.byUsuarioId(id);
		if(carros.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(carros);
	}
}
