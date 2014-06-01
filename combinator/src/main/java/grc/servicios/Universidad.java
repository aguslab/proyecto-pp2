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

public class Universidad implements IUniversidad
{
	public Carrera getCarrerraFromAlumno(String alumno)
	{
		try
		{
			return CarreraDAO.getInstancia().getCarrera(0);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public Set<Curso> getCursosFromCarrera(Carrera carrera)
	{
		try
		{
			return CursoDAO.getInstancia().getCursosPorCarrera(carrera);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public PlanEstudio getPlanEstudioFromCarrera(Carrera carrera)
	{
		try
		{
			return PlanEstudioDAO.getInstancia().getPlanEstudioDeCarrera(carrera);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Set<Materia> getMateriasAprobadasFromAlumno(String alumno)
	{

		try
		{
			Set<Materia> materiasAprobadas = new HashSet<Materia>();
			for (MateriaAprobada m : MateriaAprobadaDAO.getInstancia().obtenerTodo())
			{
				materiasAprobadas.add(m.getMateriaAprobada());
			}
			return materiasAprobadas;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
