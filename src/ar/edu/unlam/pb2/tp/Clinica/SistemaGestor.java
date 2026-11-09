package ar.edu.unlam.pb2.tp.Clinica;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class SistemaGestor {

	private HashSet<Paciente> pacientes;
	private HashMap<String, Profesional> profesionales;
	private HashMap<String, TreeMap<LocalDate, Turno>> agendas;

	public SistemaGestor() {
		this.pacientes = new HashSet<Paciente>();
		this.profesionales = new HashMap<String, Profesional>();
		this.agendas = new HashMap<String, TreeMap<LocalDate, Turno>>();
	}

	public boolean registrarProfesional(Profesional profesional)
			throws DatosInvalidosException, ProfesionalExistenteException, HonorarioNegativoOCero {
		validarProfesional(profesional);

		this.profesionales.put(profesional.getMatricula(), profesional);
		this.agendas.put(profesional.getMatricula(), new TreeMap<LocalDate, Turno>());
		return true;
	}

	private void validarProfesional(Profesional profesional)
			throws DatosInvalidosException, ProfesionalExistenteException, HonorarioNegativoOCero {
		if (profesional == null || profesional.getMatricula() == null || profesional.getNombre() == null
				|| profesional.getApellido() == null || profesional.getHonorarioBase() == null) {
			throw new DatosInvalidosException("Los datos del profesional no pueden ser nulos");
		}
		if (profesional.getHonorarioBase() <= 0) {
			throw new DatosInvalidosException("El honorario base debe ser mayor a 0");
		}
		if (profesionales.containsKey(profesional.getMatricula())) {
			throw new ProfesionalExistenteException(
					"Ya existe un profesional con la matricula " + profesional.getMatricula());
		}

	}

	public boolean registrarPaciente(Paciente paciente)
			throws DatosInvalidosException, PacienteExistenteException, DniInvalidoException {
		validarPaciente(paciente);

		this.pacientes.add(paciente);
		return true;
	}

	private void validarPaciente(Paciente paciente)
			throws DatosInvalidosException, PacienteExistenteException, DniInvalidoException {
		if (paciente == null || paciente.getDni() == null || paciente.getNombre() == null
				|| paciente.getApellido() == null || paciente.getObraSocial() == null) {
			throw new DatosInvalidosException("Algun parametro esta nulo");
		}
		if (paciente.getDni() < 10000000 || paciente.getDni() > 99999999) {
			throw new DniInvalidoException("El dni tiene que tener 8 caracteres");
		}
		if (this.pacientes.contains(paciente)) {
			throw new PacienteExistenteException("Este dni ya existe");
		}
	}

}
