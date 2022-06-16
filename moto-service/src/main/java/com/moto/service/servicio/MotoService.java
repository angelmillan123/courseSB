package com.moto.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entidades.Moto;
import com.moto.service.repository.MotoRepository;

@Service
public class MotoService {
	
	@Autowired
	private MotoRepository motoRepository;
	
	public List<Moto> getAll()
	{
		return motoRepository.findAll();
	}
	
	public Moto getMotoById(int id)
	{
		return motoRepository.findById(id).orElse(null);
	}
	
	
	public Moto save(Moto carro)
	{
		return motoRepository.save(carro);
	}
	
	public void deletAll()
	{
		motoRepository.deleteAll();
	}
	
	public void deleteById(int id)
	{
		motoRepository.deleteById(id);
	}

	public List<Moto> byUsuarioId(int usuarioId)
	{
		return motoRepository.findByUsuarioId(usuarioId);
	}
	
}
