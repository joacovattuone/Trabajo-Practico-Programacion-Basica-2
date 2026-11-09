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
		sistema= new SistemaGestor();
		cirujano = new Cirujano("M001", "Juan", "Perez", 10000.0, 3, 2000.0);
		pediatra = new Pediatra("M002", "Ana", "Gomez", 8000.0);
		cardiologo = new Cardiologo("M003", "Luis", "Lopez", 10000.0);
		pediatraDos = new Pediatra("M004", "Sofia", "Ruiz", 8000.0);		
		pacienteSinObra = new Paciente(11111111, "Carlos", "Diaz", ObraSocial.SIN_OBRA_SOCIAL);
		pacienteOsde = new Paciente(22222222, "Marta", "Soto", ObraSocial.OSDE);
		pacienteSwiss = new Paciente(33333333, "Pablo", "Vega", ObraSocial.SWISS_MEDICAL);
		
	}
 
	@Test
   public void deberiaPermitirRegistrarUnProfesionalCorrectamente() throws Exception {	 

		Boolean seRegistroProfesional = sistema.registrarProfesional(cirujano);
		Boolean seRegistroPaciente = sistema.registrarPaciente(pacienteSinObra);
 
		assertTrue(seRegistroProfesional);
		assertTrue(seRegistroPaciente);
	}
	
	@Test(expected =DatosInvalidosException.class)
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
	public void noDeberiaPermitirRegistrarUnPacienteConElMismoDni()
			throws Exception {		
		Paciente pacienteMismoDni = new Paciente(11111111, "Otro", "Nombre", ObraSocial.OSDE);

		sistema.registrarPaciente(pacienteSinObra);
		sistema.registrarPaciente(pacienteMismoDni);
	}
 
	@Test(expected = DniInvalidoException.class)
	public void noDeberiaPermitirRegistrarUnPacienteConDniDeLongitudInvalida()
			throws Exception {		
		sistema.registrarPaciente(new Paciente(123, "Corto", "Dni", ObraSocial.OSDE));
	}
 
	@Test
	public void deberiaCalcularElCostoDelTurnoConDescuentoSiElPacienteTieneObraSocial () {
		//ahora vamos por este
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
 
 