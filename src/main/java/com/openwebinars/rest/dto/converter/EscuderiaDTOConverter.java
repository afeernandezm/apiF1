package com.openwebinars.rest.dto.converter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.openwebinars.rest.dto.EscuderiaDTO;
import com.openwebinars.rest.modelo.Escuderia;
import com.openwebinars.rest.modelo.Piloto;
import com.openwebinars.rest.modelo.PilotoRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EscuderiaDTOConverter {
    private final ModelMapper modelMapper;
    private final PilotoRepositorio pilotoRepositorio;

    public EscuderiaDTO convertToDto(Escuderia escuderia) {
        EscuderiaDTO escuderiaDTO = modelMapper.map(escuderia, EscuderiaDTO.class);
        List<String> nombresPilotos = new ArrayList();
        for (Piloto piloto : escuderia.getPilotos()) {
            nombresPilotos.add(piloto.getNombre());
        }
        escuderiaDTO.setNombresPilotos(nombresPilotos);
        return escuderiaDTO;
    }
}
