package com.notas.core.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	private static final Log logger = LogFactory.getLog(NotaService.class);
	
	public boolean crear(Nota nota) {
		logger.info("CREANDO NOTA");
		try {
			repositorio.save(nota);
			logger.info("NOTA CREADA");
			return true;
		}catch(Exception ex) {
			logger.error("HUBO UN ERROR AL CREAR NOTA");
			return false;
		}
	}
	
	public boolean actualizar(Nota nota) {
		logger.info("ACTULIZANDO NOTA");
		try {
			repositorio.save(nota);
			logger.info("NOTA ACTUALIZADA");
			return true;
		}catch(Exception ex) {
			logger.error("HUBO UN ERROR AL ACTUALIZAR NOTA");
			return false;
		}
	}
	
	public boolean borrar(long id) {
		logger.info("BORRANDO NOTA");
		try {
			Nota nota = repositorio.findById(id);
			repositorio.delete(nota);
			logger.info("NOTA BORRADA");
			return true;
		}catch(Exception ex) {
			logger.error("HUBO UN ERROR AL BORRAR NOTA");
			return false;
		}
	}
	
	public boolean borrar(String nombre, long id) {
		logger.info("BORRANDO NOTA");
		try {
			Nota nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);
			logger.info("NOTA BORRADA");
			return true;
		}catch(Exception ex) {
			logger.error("HUBO UN ERROR AL BORRAR NOTA");
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
		logger.info("LISTANDO NOTA");
		List<MNota> notas  = null;
		notas = convertidor.convertirLista(repositorio.findAll());
		logger.info("NOTA LISTADA");
		return notas;
	}
}
