package ar.edu.unlam.pb2.tp.Clinica;

import java.util.Objects;

public class Paciente implements Descontable {
	 
	private String dni;
	private String nombre;
	private String apellido;
	private ObraSocial obraSocial;
 
	public Paciente(String dni, String nombre, String apellido, ObraSocial obraSocial) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.obraSocial = obraSocial;
	}
 
	@Override
	public Double calcularDescuento(Double valor) {
		Double porcentaje = 0.0;
		switch (this.obraSocial) {
		case OSDE:
			porcentaje = 40.0;
			break;
		case SWISS_MEDICAL:
			porcentaje = 30.0;
			break;
		case GALENO:
			porcentaje = 20.0;
			break;
		default:
			porcentaje = 0.0;
			break;
		}
		return valor * porcentaje / 100;
	}
 
	public String getDni() {
		return dni;
	}
 
	public String getNombre() {
		return nombre;
	}
 
	public String getApellido() {
		return apellido;
	}
 
	public ObraSocial getObraSocial() {
		return obraSocial;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(dni, other.dni);
	}

	

}
