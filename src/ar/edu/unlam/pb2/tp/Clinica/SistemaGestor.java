package ar.edu.unlam.pb2.tp.Clinica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

	public Turno agendarTurno(Paciente paciente, Profesional profesional, LocalDate fecha)
			throws TurnoInvalidoException, ProfesionalNoEncontradoException, TurnoOcupadoException {
		validarTurno(paciente, profesional, fecha);

		Turno turno = new Turno(paciente, profesional, fecha);
		agendas.get(profesional.getMatricula()).put(fecha, turno);
		return turno;
	}

	private void validarTurno(Paciente paciente, Profesional profesional, LocalDate fecha)
			throws TurnoInvalidoException, ProfesionalNoEncontradoException, TurnoOcupadoException {
		if (paciente == null || profesional == null || profesional.getMatricula() == null || fecha == null) {
			throw new TurnoInvalidoException("Estas pasando un dato que esta nulo");
		}
		if (!this.profesionales.containsKey(profesional.getMatricula())) {
			throw new ProfesionalNoEncontradoException("El profesional no esta registrado");
		}
		if (fecha.isBefore(LocalDate.now())) {
			throw new TurnoInvalidoException("La fecha no puede ser anterior a hoy");
		}
		if (this.agendas.get(profesional.getMatricula()).containsKey(fecha)) {
			throw new TurnoOcupadoException("El profesional ya tiene un turno en esa fecha");
		}

	}

	public Turno obtenerProximoTurno(Profesional profesional) throws ProfesionalNoEncontradoException {
		TreeMap<LocalDate, Turno> agenda = obtenerAgenda(profesional);

		if (agenda.isEmpty()) {
			return null;
		}
		return agenda.firstEntry().getValue();

	}

	private TreeMap<LocalDate, Turno> obtenerAgenda(Profesional profesional) throws ProfesionalNoEncontradoException {
		if (profesional == null || !this.agendas.containsKey(profesional.getMatricula())) {
			throw new ProfesionalNoEncontradoException("El profesional no esta registrado");
		}
		return this.agendas.get(profesional.getMatricula());

	}

	public ArrayList<Turno> obtenerTurnosDeUnProfesional(Profesional profesional)
			throws ProfesionalNoEncontradoException {
		TreeMap<LocalDate, Turno> agenda = obtenerAgenda(profesional);

		return new ArrayList<Turno>(agenda.values());

	}

	public ArrayList<Turno> obtenerTurnosEnRango(Profesional profesional, LocalDate inicio, LocalDate fin)
			throws TurnoInvalidoException, ProfesionalNoEncontradoException {
		if (inicio == null || fin == null) {
			throw new TurnoInvalidoException("Algun parametro esta nulo");
		}
		if (inicio.isAfter(fin)) {
			throw new TurnoInvalidoException("La fecha de inicio no puede ser posterior a la de fin");
		}
		TreeMap<LocalDate, Turno> agenda = obtenerAgenda(profesional);

		return new ArrayList<Turno>(agenda.subMap(inicio, true, fin, true).values());
	}

}
