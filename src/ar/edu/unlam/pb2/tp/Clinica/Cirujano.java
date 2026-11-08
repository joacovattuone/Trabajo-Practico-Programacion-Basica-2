package ar.edu.unlam.pb2.tp.Clinica;

public class Cirujano extends Profesional implements Operable {
	 
	private Integer cantidadDeOperaciones;
	private Double valorPorOperacion;
 
	public Cirujano(String matricula, String nombre, String apellido, Double honorarioBase,
					int cantidadDeOperaciones, double valorPorOperacion) {
		super(matricula, nombre, apellido, honorarioBase);
		this.cantidadDeOperaciones = cantidadDeOperaciones;
		this.valorPorOperacion = valorPorOperacion;
	}
 
	@Override
	public Double calcularCostoOperacion() {
		return cantidadDeOperaciones * valorPorOperacion;
	}
 
	@Override
	public Double calcularHonorarioFinal() {
		return getHonorarioBase() + calcularCostoOperacion();
	}
 
	public int getCantidadDeOperaciones() {
		return cantidadDeOperaciones;
	}
 
	public double getValorPorOperacion() {
		return valorPorOperacion;
	}
}