package grc.servicios;

import grc.dao.CursoDAO;
import grc.dao.MateriaAprobadaDAO;
import grc.dao.PlanEstudioDAO;
import grc.modelo.Curso;
import grc.modelo.Materia;
import grc.modelo.MateriaAprobada;
import grc.modelo.PlanEstudio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Filtrador {

	/**
	 * 
	 * @param filtrarNoche
	 * @param filtrarTarde
	 * @param filtrarManiana
	 * @param horaInicio
	 *            : la hora de inicio del horario del curso a los que se quiere
	 *            inscribir el alumno
	 * @return todos los cursos a los que se puede inscribir el alumno (filtrado
	 *         por horario, materias aprob y correlativas
	 * @throws Exception
	 */
	public Set<Curso> getCursosDisponibles(boolean filtrarManiana,
			boolean filtrarTarde, boolean filtrarNoche) throws Exception {
		Set<Curso> cursosDisponibles = new HashSet<Curso>();
		Set<Curso> cursosAFiltrar = new HashSet<Curso>();
		int horaInicioMan = 8;
		int horaInicioTar = 13;
		int horaInicioNoch = 18;
		if (filtrarManiana) {
			cursosAFiltrar = CursoDAO.getInstancia().getCursosPorTurno(
					horaInicioMan, horaInicioTar-1);
			System.out.println("MANANA: " +CursoDAO.getInstancia().getCursosPorTurno(
					horaInicioMan, horaInicioTar-1).size());
		}
		if (filtrarTarde) {
			cursosAFiltrar.addAll(CursoDAO.getInstancia().getCursosPorTurno(
					horaInicioTar,horaInicioNoch-1));
			System.out.println("TARDE: " +CursoDAO.getInstancia().getCursosPorTurno(
					horaInicioTar,horaInicioNoch-1).size());
		}
		if (filtrarNoche) {
			cursosAFiltrar.addAll(CursoDAO.getInstancia().getCursosPorTurno(
					horaInicioNoch,horaInicioNoch+4));
			System.out.println("NOCHE: " +CursoDAO.getInstancia().getCursosPorTurno(
					horaInicioNoch,horaInicioNoch+4).size());
		}
		System.out.println("TODOS: " +cursosAFiltrar.size());
		CursoDAO.getInstancia().quitarMateriasAprobadas(cursosAFiltrar);

		// como devuelve una lista, agrego cada elemento al Set
		Set<Materia> materiasAprobadas = new HashSet<Materia>();
		List<MateriaAprobada> mataprobadas = MateriaAprobadaDAO.getInstancia()
				.obtenerTodo();
		for (MateriaAprobada m : mataprobadas) {
			materiasAprobadas.add(m.getMateriaAprobada());
		}

		System.out.println("Cursos a filtrar!!!");
		for (Curso c : cursosAFiltrar) {
			System.out.println(c.getMateria().getNombre() + ": " + c.getId());
		}

		// Por ahora hay un unico plan de estudios
		PlanEstudio pe = PlanEstudioDAO.getInstancia().obtenerTodo().get(0);

		for (Curso c : cursosAFiltrar) {
			if (tieneCorrelativas(pe, c.getMateria(), materiasAprobadas)) {
				cursosDisponibles.add(c);
			}

		}

		return cursosDisponibles;
	}

	public boolean tieneCorrelativas(PlanEstudio pe, Materia materiaACursar,
			Set<Materia> materiasAprobadas) {
		if (pe.getCorrelativas().containsKey(materiaACursar)) {
			if (materiaACursar.getNombre().equalsIgnoreCase(
					"Laboratorio Interdisciplinario")) {
				return materiasAprobadas.size() >= 11;
			}
			return materiasAprobadas.containsAll(pe.getCorrelativas().get(
					materiaACursar));
		}

		return false;
	}

}
