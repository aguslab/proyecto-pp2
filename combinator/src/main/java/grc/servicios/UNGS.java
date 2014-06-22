package grc.servicios;

import java.util.HashSet;
import java.util.Set;

import grc.dao.CarreraDAO;
import grc.dao.CursoDAO;
import grc.dao.PlanEstudioDAO;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.PlanEstudio;

public class UNGS implements IUniversidad
{
	public Carrera getCarreraFromAlumno(String alumno)
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

	public PlanEstudio getPlanEstudioFromCarrera(Carrera carrera)
	{
		try
		{
			return PlanEstudioDAO.getInstancia().getPlanEstudioDeCarrera(carrera);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<Curso> getCursos()
	{
		try
		{
			return new HashSet<Curso>(CursoDAO.getInstancia().obtenerTodo());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
