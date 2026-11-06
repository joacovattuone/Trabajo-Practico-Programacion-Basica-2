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
	public void deberiaRegistrarPacienteYMedico() {
		fail("Not yet implemented");
	}

	@Test
	public void noDeberiaRegistrarConIdDuplicado() {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaCalcularCostoCorrectamente() {
		fail("Not yet implemented");
	}

	@Test
	public void noDeberiaEncontrarMedicoConMatriculaInexistente() {
		fail("Not yet implemented");
	}

	@Test
	public void obtenerMontoTotalObtenidoPorUnMedicoEnUnDia() {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaAplicarDescuentoPorTipoObraSocial() {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaOrdenarPacientePorApellidoDescendente() {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaAgendarTurnoAPacienteCorrectamente() {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaReprogramarTurnoDePaciente() {
		fail("Not yet implemented");
	}

	@Test
	public void noDeberiaElMedicoAtenderDosPacientesEnUnMismoDia() {
		fail("Not yet implemented");
	}

	@Test
	public void noDeberiaPermitirCancelarUnTurnoYaCancelado() {
		fail("Not yet implemented");
	}

	@Test
	public void deberiaOrdenarMedicosPorEspecialidaPorOrdenAscendente() {
		fail("Not yet implemented");
	}

	@Test
	public void obtenerReporteDeLosPacientesAtendidosPorMedicoPorDia() {
		fail("Not yet implemented");
	}



}
