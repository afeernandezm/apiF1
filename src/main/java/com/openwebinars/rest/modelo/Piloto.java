package com.openwebinars.rest.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Piloto {

	@Id
	@GeneratedValue
	private Long id;

	private String nombre;

	private float numero;

	@ManyToOne
	@JoinColumn(name = "escuderia_id")
	private Escuderia escuderia;

}
