package grc.servicios;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import grc.app.Main;
import grc.dao.CarreraDAO;
import grc.dao.CursoDAO;
import grc.dao.PlanEstudioDAO;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.PlanEstudio;

public class UNGS implements IUniversidad
{
	static Logger logger = Logger.getLogger(UNGS.class);
	public Carrera getCarreraFromAlumno(String alumno)
	{
		try
		{
			logger.info("Obtenemos carrera del alumno." );
			return CarreraDAO.getInstancia().getCarrera(0);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		logger.warn("El alumno no está inscripto a esa carrera." );
		return null;
	}

	public PlanEstudio getPlanEstudioFromCarrera(Carrera carrera)
	{
		try
		{
			logger.info("Obtenemos el plan de estudios del alumno.");
			return PlanEstudioDAO.getInstancia().getPlanEstudioDeCarrera(carrera);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		logger.warn("No hay plan de estudio para esa carrera!.");
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
