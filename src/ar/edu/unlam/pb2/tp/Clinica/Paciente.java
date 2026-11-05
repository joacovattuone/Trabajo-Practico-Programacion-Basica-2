package ar.edu.unlam.pb2.tp.Clinica;

import java.time.LocalDate;

public class Paciente extends Persona {
	/* ATRIBUTOS */
	private TipoObraSocial tipoObraSocial;
	private LocalDate fechaNac;

	/* CONSTRUCTOR */
	public Paciente(Integer dNI, String nombre, String apellido, String email, Double monto,TipoObraSocial tipoObraSocial,LocalDate fechaNac) {
		super(dNI, nombre, apellido, email, monto);
		this.tipoObraSocial=tipoObraSocial;
		this.fechaNac=fechaNac;

	}

	@Override
	public Double calcularCosto() {
		return null;
	}

	public TipoObraSocial getTipoObraSocial() {
		return tipoObraSocial;
	}

	public void setTipoObraSocial(TipoObraSocial tipoObraSocial) {
		this.tipoObraSocial = tipoObraSocial;
	}

	public LocalDate getEdad() {
		return fechaNac;
	}

	public void setEdad(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

}
