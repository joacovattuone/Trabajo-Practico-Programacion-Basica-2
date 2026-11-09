package ar.edu.unlam.pb2.tp.Clinica;

import java.time.LocalDate;

public class Turno {
	 
	private final Paciente paciente;
	private final Profesional profesional;
	private final LocalDate fecha;
	private EstadoTurno estado;
	
 
	public Turno(Paciente paciente, Profesional profesional, LocalDate fecha) {
		this.paciente = paciente;
		this.profesional = profesional;
		this.fecha = fecha;
		this.estado = EstadoTurno.PROGRAMADO;
	}
 
	public Double calcularCosto() {
		Double honorario = profesional.calcularHonorarioFinal();
		return honorario - paciente.calcularDescuento(honorario);
	}
 
	public Paciente getPaciente() {
		return paciente;
	}
 
	public Profesional getProfesional() {
		return profesional;
	}
 
	public LocalDate getFecha() {
		return fecha;
	}
 
	public EstadoTurno getEstado() {
		return estado;
	}
 
	void setEstado(EstadoTurno estado) {
		this.estado = estado;
	}
}
