package com.openwebinars.rest.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Escuderia {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String logo;

    @OneToMany
    @JoinColumn(name = "escuderia_id")
    private List<Piloto> pilotos;
}
