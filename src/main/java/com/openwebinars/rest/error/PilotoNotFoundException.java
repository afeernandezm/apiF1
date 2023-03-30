package com.openwebinars.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PilotoNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 43876691117560211L;

    public PilotoNotFoundException(Long id) {
        super("No se puede encontrar el piloto con la ID: " + id);
    }

    public PilotoNotFoundException() {
        super("No se puede encontrar ningún piloto");
    }
}
