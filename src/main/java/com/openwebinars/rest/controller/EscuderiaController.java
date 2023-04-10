package com.openwebinars.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openwebinars.rest.dto.CreateEscuderiaDTO;
import com.openwebinars.rest.servicios.Servicio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EscuderiaController {

    private final Servicio servicio;

    @GetMapping("/escuderia")
    public ResponseEntity<?> obtenerTodas() {
        return servicio.obtenerEscuderias();
    }

    @GetMapping("/escuderia/{id}")
    public ResponseEntity<?> obtenerUna(@PathVariable Long id) {
        return servicio.obtenerUnaEscuderia(id);
    }

    @PostMapping("/escuderia")
    public ResponseEntity<?> nuevaEscuderia(@RequestBody CreateEscuderiaDTO nueva) {
        return servicio.crearEscuderia(nueva);
    }

    @PutMapping("/escuderia/{id}")

    public ResponseEntity<?> editarEscuderia(@RequestBody CreateEscuderiaDTO editar, @PathVariable Long id) {
        return servicio.editarEscuderia(editar, id);
    }

    @DeleteMapping("/escuderia/{id}")
    public ResponseEntity<?> borrarEscuderia(@PathVariable Long id) {
        return servicio.borrarEscuderia(id);
    }

}
