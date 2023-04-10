package com.openwebinars.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePilotoDTO {
    private String nombre;
    private int numero;
    private Long idEscuderia;
}
