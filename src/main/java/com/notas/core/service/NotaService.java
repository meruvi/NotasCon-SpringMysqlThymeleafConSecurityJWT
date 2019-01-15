package com.notas.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.notas.core.converter.Convertidor;
import com.notas.core.entity.Nota;
import com.notas.core.repository.NotaRepositorio;

import com.notas.core.model.MNota;

@Service("servicio")
public class NotaService {

	@Autowired
	@Qualifier("repositorio")
	private NotaRepositorio repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	public boolean crear(Nota nota) {
		try {
			repositorio.save(nota);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	public boolean actualizar(Nota nota) {
		try {
			repositorio.save(nota);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	public boolean borrar(String nombre, long id) {
		try {
			Nota nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	public MNota findByNombreTitulo(String nombre, String titulo){
		try {
			MNota mnota = new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
			return mnota;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public List<MNota> obtener(){
		List<MNota> notas  = null;
		notas = convertidor.convertirLista(repositorio.findAll());
		return notas;
	}
}
