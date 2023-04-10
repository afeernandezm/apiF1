package com.openwebinars.rest.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EscuderiaDTO {
    private String nombre;
    private String logo;
    private List<String> nombresPilotos;
}
