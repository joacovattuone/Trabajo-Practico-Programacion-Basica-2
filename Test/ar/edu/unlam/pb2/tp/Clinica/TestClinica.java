package ar.edu.unlam.pb2.tp.Clinica;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

public class TestClinica {
	/* aca van los private */
	private SistemaGestor sistema;
	private Persona paciente;
	private Persona medico;
	private Turno turno;

	@Before
	public void setUp() {
		
		paciente = new Paciente(12564985, "Joaquin", "Perez", "joaq.Perez@gmail.com", 5000.0, TipoObraSocial.PAMI,
				LocalDate.of(2002, Month.JANUARY, 5));
		
		medico = new Medico(22658102, "Marta", "Gonzales", "marta.Gonzales@gmail.com", 0.0, "MC-2036",
				TipoEspecialidad.OTORRINOLARINGOLOGIA, 5);

	}

	@Test
   public void deberiaPermitirRegistrarUnProfesionalCorrectamente() {
		fail("Not yet implemented");
	}

	@Test
	public void noDeberiaPermitirRegistrarUnProfesionalConDatosIncorrectos()  {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaPermitirRegistrarUnPacienteCorrectamente() {
		fail("Not yet implemented");
	}

	@Test
	public void noDeberiaPermitirRegistrarUnPacienteConElMismoDni() {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaCalcularElHonorarioFinalDeUnCirujanoConCosto() {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaCalcularElCostoDelTurnoConDescuentoSiElPacienteTieneObraSocial () {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaPermitirAgendarUnTurnoCorrectamente() {
		fail("Not yet implemented");
	}

	@Test
	public void noDeberiaPermitirAgendarDosTurnosEnElMismoHorario() {
		fail("Not yet implemented");
	}

	@Test
	public void noDeberiaPermitirAgendarUnTurnoConProfesionalNoRegistrado() {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaObtenerElProximoTurnoSegunOrdenCronologico() {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaObtenerLosTurnosDeUnProfesionalOrdenadosPorFecha () {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaObtenerLosProfesionalesOrdenadosPorHonorarioFinalYEnCasoDeEmpatePorMatricula () {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaCalcularLaRecaudacionTotalDeLaClinica() {
		fail("Not yet implemented");
	}



}
