package ar.edu.unlam.pb2.tp.Clinica;

public abstract class Persona {

	/*ATRIBUTOS*/
	private Integer dni;
	private String nombre;
	private String apellido;
	private String email;
	private Double monto;
	
	
	/*CONSTRUCTOR*/
	public Persona(Integer dni, String nombre, String apellido, String email, Double monto) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.monto = monto;
		
	}
	/*Metodo abstracto*/
	public abstract Double calcularCosto();

	/*GETTER Y SETTER */
	public Integer getDni() {
		return dni;
	}
	
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Double getMonto() {
		return monto;
	}
	
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	
	
	
}
