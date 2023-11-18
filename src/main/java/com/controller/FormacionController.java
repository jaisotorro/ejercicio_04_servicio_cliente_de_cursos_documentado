package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Formacion;
import com.service.FormacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Servicio de formaciones", description="Servicio de consulta y creación de formaciones")
public class FormacionController {
	
	@Autowired
	FormacionService formacionService;

	@Operation(summary="Busca todas las formaciones", description="Busca todas las formaciones existentes. No recibe parámetros")
	@GetMapping(value="formaciones",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> devuelveAllFormaciones() {
		return formacionService.getAllFormaciones();
	}
	
	@Operation(summary="Crea una nueva formación", description="Recibe una formación en el body de la petición y la da de alta")
	@PostMapping(value="formacion",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String creaFormacion(@RequestBody Formacion formacion) {
		return formacionService.createFormacion(formacion);
	}
	
	
}
