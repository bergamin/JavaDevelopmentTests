package br.com.bergamin.urnaeletronica.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Voto {
	
	@ManyToOne
	private Restaurante restaurante;
	@Temporal(TemporalType.DATE)
	private Calendar dataVoto;
	
}
