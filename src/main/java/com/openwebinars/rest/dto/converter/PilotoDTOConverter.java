package com.openwebinars.rest.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.openwebinars.rest.dto.PilotoDTO;
import com.openwebinars.rest.modelo.Piloto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PilotoDTOConverter {
    private final ModelMapper modelMapper;

    public PilotoDTO convertToDto(Piloto piloto) {
        return modelMapper.map(piloto, PilotoDTO.class);
    }
}
