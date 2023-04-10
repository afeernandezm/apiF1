package com.openwebinars.rest.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openwebinars.rest.dto.CreatePilotoDTO;

import com.openwebinars.rest.servicios.Servicio;

import lombok.RequiredArgsConstructor;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class PilotoController {

	private final Servicio servicio;

	@GetMapping("/piloto")
	public ResponseEntity<?> obtenerTodos() {
		return servicio.obtenerPilotos();
	}

	@GetMapping("/piloto/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		return servicio.obtenerUnPiloto(id);
	}

	@PostMapping("/piloto")
	public ResponseEntity<?> nuevoProducto(@RequestBody CreatePilotoDTO nuevo) {
		return servicio.crearPiloto(nuevo);
	}

	@PutMapping("/piloto/{id}")

	public ResponseEntity<?> editarProducto(@RequestBody CreatePilotoDTO editar, @PathVariable Long id) {
		return servicio.editarPiloto(editar, id);
	}

	@DeleteMapping("/piloto/{id}")
	public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
		return servicio.borrarPiloto(id);
	}

}
