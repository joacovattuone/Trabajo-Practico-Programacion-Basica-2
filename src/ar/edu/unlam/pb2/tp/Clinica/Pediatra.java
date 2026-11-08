package ar.edu.unlam.pb2.tp.Clinica;

public class Pediatra extends Profesional {	 
	
 
	public Pediatra(String matricula, String nombre, String apellido, Double honorarioBase) {
		super(matricula, nombre, apellido, honorarioBase);
	}
 
	@Override
	public Double calcularHonorarioFinal() {
		return getHonorarioBase() * (1 + 0.10);
	}
}