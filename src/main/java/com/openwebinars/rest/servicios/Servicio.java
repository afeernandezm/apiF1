package com.openwebinars.rest.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.openwebinars.rest.dto.CreateEscuderiaDTO;
import com.openwebinars.rest.dto.CreatePilotoDTO;
import com.openwebinars.rest.dto.EscuderiaDTO;
import com.openwebinars.rest.dto.PilotoDTO;
import com.openwebinars.rest.dto.converter.EscuderiaDTOConverter;
import com.openwebinars.rest.dto.converter.PilotoDTOConverter;
import com.openwebinars.rest.error.EscuderiaNotFoundException;
import com.openwebinars.rest.error.PilotoNotFoundException;
import com.openwebinars.rest.modelo.Escuderia;
import com.openwebinars.rest.modelo.EscuderiaRepositorio;
import com.openwebinars.rest.modelo.Piloto;
import com.openwebinars.rest.modelo.PilotoRepositorio;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;

@Service
@RequiredArgsConstructor
public class Servicio {

    @Autowired
    private final PilotoRepositorio pilotoRepositorio;
    @Autowired
    private final PilotoDTOConverter pilotoDTOConverter;
    @Autowired
    private final EscuderiaRepositorio escuderiaRepositorio;
    @Autowired
    private EscuderiaDTOConverter escuderiaDTOConverter;

    public ResponseEntity<?> obtenerPilotos() {
        List<Piloto> result = pilotoRepositorio.findAll();
        if (result.isEmpty()) {
            throw new PilotoNotFoundException();
        } else {
            // return ResponseEntity.ok(result);
            List<PilotoDTO> dtoList = result.stream().map(pilotoDTOConverter::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    public ResponseEntity<?> crearPiloto(CreatePilotoDTO nuevo) {

        Piloto nuevoPiloto = new Piloto();
        nuevoPiloto.setNombre(nuevo.getNombre());
        nuevoPiloto.setNumero(nuevo.getNumero());
        Escuderia escuderia = escuderiaRepositorio.findById(nuevo.getIdEscuderia()).orElse(null);
        nuevoPiloto.setEscuderia(escuderia);

        return ResponseEntity.status(HttpStatus.CREATED).body(pilotoRepositorio.save(nuevoPiloto));
    }

    public ResponseEntity<?> editarPiloto(CreatePilotoDTO editar, Long id) {
        Piloto nuevoPiloto = new Piloto();
        nuevoPiloto.setId(id);
        nuevoPiloto.setNombre(editar.getNombre());
        nuevoPiloto.setNumero(editar.getNumero());
        Escuderia escuderia = escuderiaRepositorio.findById(editar.getIdEscuderia()).orElse(null);
        nuevoPiloto.setEscuderia(escuderia);

        return ResponseEntity.status(HttpStatus.CREATED).body(pilotoRepositorio.save(nuevoPiloto));
    }

    public ResponseEntity<?> obtenerUnPiloto(Long id) {
        Piloto result = pilotoRepositorio.findById(id).orElseThrow(() -> new PilotoNotFoundException(id));
        PilotoDTO piloto = new PilotoDTO();

        piloto = pilotoDTOConverter.convertToDto(result);
        return ResponseEntity.ok(piloto);

    }

    public ResponseEntity<?> borrarPiloto(Long id) {
        pilotoRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /////////////////////////// ESCUDERIAS////////////////////////////////////////
    public ResponseEntity<?> obtenerEscuderias() {
        List<Escuderia> result = escuderiaRepositorio.findAll();
        if (result.isEmpty()) {
            throw new EscuderiaNotFoundException();
        } else {
            // return ResponseEntity.ok(result);
            List<EscuderiaDTO> resultDTO = new ArrayList<>();
            for (Escuderia escuderia : result) {
                resultDTO.add(escuderiaDTOConverter.convertToDto(escuderia));
            }
            return ResponseEntity.ok(resultDTO);
        }
    }

    public ResponseEntity<?> crearEscuderia(CreateEscuderiaDTO nueva) {
        Escuderia nuevaEscuderia = new Escuderia();
        nuevaEscuderia.setNombre(nueva.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(escuderiaRepositorio.save(
                nuevaEscuderia));
    }

    public ResponseEntity<?> editarEscuderia(CreateEscuderiaDTO editar, Long id) {
        Escuderia nuevaEscuderia = new Escuderia();
        nuevaEscuderia.setId(id);
        nuevaEscuderia.setNombre(editar.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(escuderiaRepositorio.save(
                nuevaEscuderia));
    }

    public ResponseEntity<?> obtenerUnaEscuderia(Long id) {
        Escuderia result = escuderiaRepositorio.findById(id).orElseThrow(() -> new EscuderiaNotFoundException(id));
        EscuderiaDTO escuderia = new EscuderiaDTO();

        escuderia = escuderiaDTOConverter.convertToDto(result);
        return ResponseEntity.ok(escuderia);

    }

    public ResponseEntity<?> borrarEscuderia(Long id) {
        escuderiaRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
