package com.openwebinars.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EscuderiaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 43876691117560211L;

    public EscuderiaNotFoundException(Long id) {
        super("No se puede encontrar la categoria con la ID: " + id);
    }

    public EscuderiaNotFoundException() {
        super("No se puede encontrar ninguna categoría");
    }
}
