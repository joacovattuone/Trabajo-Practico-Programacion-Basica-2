package ar.edu.unlam.pb2.tp.Clinica;

public abstract class Profesional {
	 
	private String matricula;
	private String nombre;
	private String apellido;
	private Double honorarioBase;
 
	public Profesional(String matricula, String nombre, String apellido, Double honorarioBase) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.honorarioBase = honorarioBase;
	}
 
	public abstract Double calcularHonorarioFinal();
 
	public String getMatricula() {
		return matricula;
	}
 
	public String getNombre() {
		return nombre;
	}
 
	public String getApellido() {
		return apellido;
	}
 
	public Double getHonorarioBase() {
		return honorarioBase;
	}
}
