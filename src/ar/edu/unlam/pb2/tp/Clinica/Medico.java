package ar.edu.unlam.pb2.tp.Clinica;

public class Medico extends Persona {

	/* ATRIBUTO */
	private String matricula;
	private TipoEspecialidad tipoEspecialidad;
	private Integer antiguedadAnios;
	/*Ver el tema de la licencia*/
	
	/* CONSTRUCTOR */
	public Medico(Integer dni, String nombre, String apellido, String email, Double monto,String matricula,TipoEspecialidad tipoEspecialidad,Integer antiguedad) {
		super(dni, nombre, apellido, email, monto);
		this.matricula=matricula;
		this.tipoEspecialidad=tipoEspecialidad;
		this.antiguedadAnios=antiguedad;
	}

	@Override
	public Double calcularCosto() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoEspecialidad getTipoEspecialidad() {
		return tipoEspecialidad;
	}

	public void setTipoEspecialidad(TipoEspecialidad tipoEspecialidad) {
		this.tipoEspecialidad = tipoEspecialidad;
	}

	public Integer getAntiguedadAnios() {
		return antiguedadAnios;
	}

	public void setAntiguedadAnios(Integer antiguedad) {
		this.antiguedadAnios = antiguedad;
	}
	
}
