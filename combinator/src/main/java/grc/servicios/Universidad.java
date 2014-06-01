package grc.servicios;

import java.util.HashSet;
import java.util.Set;

import grc.dao.CarreraDAO;
import grc.dao.CursoDAO;
import grc.dao.MateriaAprobadaDAO;
import grc.dao.PlanEstudioDAO;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Materia;
import grc.dominio.MateriaAprobada;
import grc.dominio.PlanEstudio;

public class Universidad
{
	public Carrera getCarrerraFromAlumno(String alumno) throws Exception
	{
		return CarreraDAO.getInstancia().getCarrera(0);
	}

	public Set<Curso> getCursosFromCarrera(Carrera carrera) throws Exception
	{
		return CursoDAO.getInstancia().getCursosPorCarrera(carrera);
	}

	public PlanEstudio getPlanEstudioFromCarrera(Carrera carrera) throws Exception
	{
		return PlanEstudioDAO.getInstancia().getPlanEstudioDeCarrera(carrera);
	}

	public Set<Materia> getMateriasAprobadasFromAlumno(String alumno) throws Exception
	{
		Set<Materia> materiasAprobadas = new HashSet<Materia>();
		for (MateriaAprobada m : MateriaAprobadaDAO.getInstancia().obtenerTodo())
		{
			materiasAprobadas.add(m.getMateriaAprobada());
		}
		return materiasAprobadas;
	}

}
