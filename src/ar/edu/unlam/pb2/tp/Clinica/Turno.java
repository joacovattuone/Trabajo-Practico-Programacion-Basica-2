package ar.edu.unlam.pb2.tp.Clinica;

import java.time.LocalDate;

public class Turno {

	/*Atributos*/
	private Integer idTurno;
	protected Paciente paciente;
	protected Medico medico;
	private LocalDate fechaTurno;
	private TipoTurno tipoTurno;
	private Double valorConsulta;
	
	/*Constructor*/
	public Turno(Integer idTurno, Paciente paciente, Medico medico, LocalDate fechaTurno,TipoTurno tipoTurno, Double valorConsulta) {
		this.idTurno = idTurno;
		this.paciente = paciente;
		this.medico = medico;
		this.fechaTurno = fechaTurno;
		this.tipoTurno=tipoTurno;
		this.valorConsulta=valorConsulta;
	}
	
	/*Getter y Setters*/

	public Integer getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public LocalDate getFechaTurno() {
		return fechaTurno;
	}

	public void setFechaTurno(LocalDate fechaTurno) {
		this.fechaTurno = fechaTurno;
	}

	public TipoTurno getTipoTurno() {
		return tipoTurno;
	}

	public void setTipoTurno(TipoTurno tipoTurno) {
		this.tipoTurno = tipoTurno;
	}
	
	
}
