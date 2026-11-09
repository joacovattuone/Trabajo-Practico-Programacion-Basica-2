package ar.edu.unlam.pb2.tp.Clinica;

import java.util.Comparator;

public class OrdenarProfesionalesPorHonorarioFinal implements Comparator<Profesional> {
	
		 
		@Override
		public int compare(Profesional o1, Profesional o2) {
			int resultado = o2.calcularHonorarioFinal().compareTo(o1.calcularHonorarioFinal());
			if (resultado == 0) {
				resultado = o1.getMatricula().compareTo(o2.getMatricula());
			}
			return resultado;
		}
	 

}
