package ar.edu.unlam.pb2.tp.Clinica;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

public class TestClinica {
	/* aca van los private */
	private SistemaGestor sistema;
	private Cirujano cirujano;
	private Profesional pediatra;
	private Profesional pediatraDos;
	private Profesional cardiologo;
	private Paciente pacienteSinObra;
	private Paciente pacienteOsde;
	private Paciente pacienteSwiss;		

	@Before
	public void setup() {
		cirujano = new Cirujano("M001", "Juan", "Perez", 10000.0, 3, 2000.0);
		pediatra = new Pediatra("M002", "Ana", "Gomez", 8000.0);
		cardiologo = new Cardiologo("M003", "Luis", "Lopez", 10000.0);
		pediatraDos = new Pediatra("M004", "Sofia", "Ruiz", 0.0);		
		pacienteSinObra = new Paciente("11111111", "Carlos", "Diaz", ObraSocial.SIN_OBRA_SOCIAL);
		pacienteOsde = new Paciente("22222222", "Marta", "Soto", ObraSocial.OSDE);
		pacienteSwiss = new Paciente("33333333", "Pablo", "Vega", ObraSocial.SWISS_MEDICAL);
		
	}

	@Test
   public void deberiaPermitirRegistrarUnProfesionalCorrectamente() throws Exception {
		sistema = new SistemaGestor();

		boolean seRegistroProfesional = sistema.registrarProfesional(cirujano);
		boolean seRegistroPaciente = sistema.registrarPaciente(pacienteSinObra);

		assertTrue(seRegistroProfesional);
		assertTrue(seRegistroPaciente);
	}
	
	@Test(expected = HonorarioNegativoOCero.class)
	public void noDeberiaPermitirRegistrarUnProfesionalConDatosIncorrectos() throws Exception {
		sistema = new SistemaGestor();
		sistema.registrarProfesional(pediatraDos);
	}
 

	@Test(expected = ProfesionalExistenteException.class)
	public void noDeberiaPermitirRegistrarUnProfesionalConMatriculaDuplicada() throws Exception {
		sistema = new SistemaGestor();
		sistema.registrarProfesional(pediatra);
		sistema.registrarProfesional(new Cardiologo("M002", "Otro", "Medico", 500.0));
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
