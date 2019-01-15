package com.notas.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notas.core.entity.Nota;
import com.notas.core.service.NotaService;

@RestController
@RequestMapping("/v1")
public class NotaController {
	
	@Autowired
	@Qualifier("servicio")
	NotaService service;

	@PutMapping("/nota")
	public boolean agregarNota(@RequestBody @Valid Nota nota) {
		return service.crear(nota);
	}
	
	@PostMapping("/nota")
	public boolean actualizarNota(@RequestBody @Valid Nota nota) {
		return service.actualizar(nota);
	}
	
	@DeleteMapping("/nota/{id}")
	public boolean borrarNota(@PathVariable("id") long id) {
		return service.borrar(id);
	}
}
