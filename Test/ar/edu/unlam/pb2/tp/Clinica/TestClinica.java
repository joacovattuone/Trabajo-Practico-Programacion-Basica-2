package ar.edu.unlam.pb2.tp.Clinica;
 
import static org.junit.Assert.*;
 
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
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
		sistema = new SistemaGestor();
		cirujano = new Cirujano("M001", "Juan", "Perez", 10000.0, 3, 2000.0);
		pediatra = new Pediatra("M002", "Ana", "Gomez", 8000.0);
		cardiologo = new Cardiologo("M003", "Luis", "Lopez", 10000.0);
		pediatraDos = new Pediatra("M004", "Sofia", "Ruiz", 8000.0);
		pacienteSinObra = new Paciente(11111111, "Carlos", "Diaz", ObraSocial.SIN_OBRA_SOCIAL);
		pacienteOsde = new Paciente(22222222, "Marta", "Soto", ObraSocial.OSDE);
		pacienteSwiss = new Paciente(33333333, "Pablo", "Vega", ObraSocial.SWISS_MEDICAL);
 
	}
 
	@Test
	public void deberiaPermitirRegistrarUnProfesionalYUnPacienteCorrectamente() throws Exception {
 
		Boolean seRegistroProfesional = sistema.registrarProfesional(cirujano);
		Boolean seRegistroPaciente = sistema.registrarPaciente(pacienteSinObra);
 
		assertTrue(seRegistroProfesional);
		assertTrue(seRegistroPaciente);
	}
 
	@Test(expected = DatosInvalidosException.class)
	public void noDeberiaPermitirRegistrarUnProfesionalConDatosIncorrectos() throws Exception {
 
		sistema.registrarProfesional(pediatraDos);
 
		sistema.registrarProfesional(new Pediatra("M-010", "Sol", "Vega", 0.0));
 
	}
 
	@Test(expected = ProfesionalExistenteException.class)
	public void noDeberiaPermitirRegistrarUnProfesionalConMatriculaDuplicada() throws Exception {
 
		sistema.registrarProfesional(pediatra);
 
		sistema.registrarProfesional(new Cardiologo("M002", "Otro", "Medico", 500.0));
 
	}
 
	@Test(expected = PacienteExistenteException.class)
	public void noDeberiaPermitirRegistrarUnPacienteConElMismoDni() throws Exception {
		Paciente pacienteMismoDni = new Paciente(11111111, "Otro", "Nombre", ObraSocial.OSDE);
 
		sistema.registrarPaciente(pacienteSinObra);
		sistema.registrarPaciente(pacienteMismoDni);
	}
 
	@Test(expected = DniInvalidoException.class)
	public void noDeberiaPermitirRegistrarUnPacienteConDniDeLongitudInvalida() throws Exception {
		sistema.registrarPaciente(new Paciente(123, "Corto", "Dni", ObraSocial.OSDE));
	}
 
	@Test
	public void deberiaCalcularElHonorarioFinalDeCirujanoPediatraYCardiologo() {
		ArrayList<Profesional> profesionales = new ArrayList<>();
		profesionales.add(cirujano);
		profesionales.add(pediatra);
		profesionales.add(cardiologo);
 
		assertEquals(16000.0, profesionales.get(0).calcularHonorarioFinal(), 0.0);
		assertEquals(8800.0, profesionales.get(1).calcularHonorarioFinal(), 0.0);
		assertEquals(13000.0, profesionales.get(2).calcularHonorarioFinal(), 0.0);
 
		assertEquals(6000.0, ((Operable) cirujano).calcularCostoOperacion(), 0.0);
 
	}
 
	@Test
	public void deberiaCalcularElCostoDelTurnoConYSinDescuentoSegunLaObraSocial() {
		Turno conDescuento = new Turno(pacienteOsde, pediatra, LocalDate.now().plusDays(1));
		Turno sinDescuento = new Turno(pacienteSinObra, pediatra, LocalDate.now().plusDays(2));
		Turno swiss = new Turno(new Paciente(11111111, "A", "B", ObraSocial.SWISS_MEDICAL), pediatra, LocalDate.now());
		Turno galeno = new Turno(new Paciente(22222222, "C", "D", ObraSocial.GALENO), pediatra, LocalDate.now());
 
		assertEquals(440.0, ((Descontable) pacienteOsde).calcularDescuento(1100.0), 0.0);
 
		assertEquals(5280.0, conDescuento.calcularCosto(), 0.0);
		assertEquals(8800.0, sinDescuento.calcularCosto(), 0.0);
		assertEquals(6160.0, swiss.calcularCosto(), 0.0);
		assertEquals(7040.0, galeno.calcularCosto(), 0.0);
		assertEquals(EstadoTurno.PROGRAMADO, conDescuento.getEstado());
 
	}
 
	@Test
	public void deberiaAgendarTurnosYObtenerElProximoLosOrdenadosPorFechaYLosDeUnRango() throws Exception {
		sistema.registrarProfesional(cirujano);
		sistema.registrarPaciente(pacienteSinObra);
		sistema.registrarPaciente(pacienteOsde);
 
		Turno turnoEnCincoDias = sistema.agendarTurno(pacienteSinObra, cirujano, LocalDate.now().plusDays(5));
		Turno turnoEnUnDia = sistema.agendarTurno(pacienteOsde, cirujano, LocalDate.now().plusDays(1));
		Turno turnoEnTresDias = sistema.agendarTurno(pacienteSinObra, cirujano, LocalDate.now().plusDays(3));
 
		assertEquals(EstadoTurno.PROGRAMADO, turnoEnUnDia.getEstado());
		assertEquals(turnoEnUnDia, sistema.obtenerProximoTurno(cirujano));
 
		List<Turno> turnos = sistema.obtenerTurnosDeUnProfesional(cirujano);
		assertEquals(3, turnos.size());
		assertEquals(turnoEnUnDia, turnos.get(0));
		assertEquals(turnoEnTresDias, turnos.get(1));
		assertEquals(turnoEnCincoDias, turnos.get(2));
 
		List<Turno> turnosEnRango = sistema.obtenerTurnosEnRango(cirujano, LocalDate.now().plusDays(2),
				LocalDate.now().plusDays(5));
		assertEquals(2, turnosEnRango.size());
		assertEquals(turnoEnTresDias, turnosEnRango.get(0));
		assertEquals(turnoEnCincoDias, turnosEnRango.get(1));
	}
 
	@Test(expected = TurnoOcupadoException.class)
	public void noDeberiaPermitirAgendarDosTurnosDelMismoProfesionalEnLaMismaFecha() throws Exception {
		sistema.registrarProfesional(cirujano);
		sistema.registrarPaciente(pacienteSinObra);
		sistema.registrarPaciente(pacienteOsde);
 
		sistema.agendarTurno(pacienteSinObra, cirujano, LocalDate.now().plusDays(2));
		sistema.agendarTurno(pacienteOsde, cirujano, LocalDate.now().plusDays(2));
	}
 
	@Test(expected = ProfesionalNoEncontradoException.class)
	public void noDeberiaPermitirAgendarUnTurnoConProfesionalNoRegistrado() throws Exception {
		sistema.registrarPaciente(pacienteSinObra);
 
		sistema.agendarTurno(pacienteSinObra, cirujano, LocalDate.now().plusDays(2));
 
	}
 
	@Test(expected = TurnoInvalidoException.class)
	public void noDeberiaPermitirAgendarUnTurnoConFechaAnteriorAHoy() throws Exception {
		sistema.registrarProfesional(cirujano);
		sistema.registrarPaciente(pacienteSinObra);
 
		sistema.agendarTurno(pacienteSinObra, cirujano, LocalDate.now().minusDays(1));
	}
 
	@Test(expected = TurnoInvalidoException.class)
	public void noDeberiaPermitirConsultarRangoConFechasInvalidas() throws Exception {
		sistema.registrarProfesional(cirujano);
 
		sistema.obtenerTurnosEnRango(cirujano, LocalDate.now().plusDays(5), LocalDate.now().plusDays(1));
		
	}
 
	@Test
	public void deberiaObtenerLosProfesionalesOrdenadosPorHonorarioFinalYEnCasoDeEmpatePorMatricula() throws Exception {
		sistema.registrarProfesional(pediatraDos);
		sistema.registrarProfesional(pediatra);
		sistema.registrarProfesional(cardiologo);
		sistema.registrarProfesional(cirujano);
 
		List<Profesional> ordenados = sistema.listarProfesionalesPorHonorarioFinal();
 
		assertEquals(4, ordenados.size());
		assertEquals(cirujano, ordenados.get(0));
		assertEquals(cardiologo, ordenados.get(1));
		assertEquals(pediatra, ordenados.get(2));
		assertEquals(pediatraDos, ordenados.get(3));
	}
 
	@Test(expected = TurnoNoCancelableException.class)
	public void noDeberiaPermitirCancelarUnTurnoYaAtendido() throws Exception {
		sistema.registrarProfesional(cirujano);
		sistema.registrarPaciente(pacienteSinObra);
		Turno turno = sistema.agendarTurno(pacienteSinObra, cirujano, LocalDate.now().plusDays(2));
 
		sistema.atenderTurno(turno);
		sistema.cancelarTurno(turno);
 
	}
 
	@Test
	public void deberiaCalcularLaRecaudacionTotalYObtenerElHistorialDeTurnosPorPaciente() throws Exception {
		sistema.registrarProfesional(cirujano);
		sistema.registrarProfesional(pediatra);
		sistema.registrarPaciente(pacienteSinObra);
		sistema.registrarPaciente(pacienteOsde);
 
		Turno turnoUno = sistema.agendarTurno(pacienteSinObra, pediatra, LocalDate.now().plusDays(2));
		Turno turnoDos = sistema.agendarTurno(pacienteOsde, cirujano, LocalDate.now().plusDays(4));
		Turno turnoTres = sistema.agendarTurno(pacienteOsde, pediatra, LocalDate.now().plusDays(1));
 
		assertTrue(sistema.atenderTurno(turnoUno));
		assertTrue(sistema.atenderTurno(turnoDos));
		
		assertEquals(18400, sistema.calcularRecaudacionTotal(), 0.0);
		
		HashMap<Paciente, ArrayList<Turno>> historial = sistema.obtenerHistorialPorPaciente();
		assertEquals(2, historial.size());
		
		ArrayList<Turno> turnosSinObraSocial = historial.get(pacienteSinObra);
		assertEquals(1, turnosSinObraSocial.size());
		assertEquals(turnoUno, turnosSinObraSocial.get(0));
		
		ArrayList<Turno> turnosConOsde = historial.get(pacienteOsde);
		assertEquals(2, turnosConOsde.size());
		assertEquals(turnoTres, turnosConOsde.get(0));
		assertEquals(turnoDos, turnosConOsde.get(1));
	}
}
 