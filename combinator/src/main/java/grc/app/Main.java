package grc.app;

import grc.dao.CriterioOrdenDAO;
import grc.dao.MateriaDAO;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.servicios.CriterioOrden;
import grc.servicios.CriterioOrdenPorPoscorrelativas;
import grc.servicios.CriterioOrdenSecuenciales;
import grc.servicios.UNGS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

public class Main
{
	static Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args)
	{
		logger.info("Corremos la aplicación.");
		try
		{
			generarAltas();
		} catch (Exception e)
		{
			//System.out.println("¡¡¡PROBLEMA AL GENERAR ALTAS!!!");
			logger.error("Error al generar las altas.",e);
			//e.printStackTrace();
		}
		String alumnoNombre = "Gokú";

		UNGS universidad = new UNGS();
		Carrera licSistemas = universidad.getCarreraFromAlumno(alumnoNombre);
		PlanEstudio planEstudio = universidad.getPlanEstudioFromCarrera(licSistemas);
		Set<Curso> cursosDisponibles = universidad.getCursos();
		cursosDisponibles = getCursosDeCarrera(cursosDisponibles, licSistemas);
		Set<Materia> materiasAprobadas = null;
		try
		{
			materiasAprobadas = getMateriasAprobadasFromAlumno(alumnoNombre);
		} catch (Exception e)
		{
			//e.printStackTrace();
			logger.error("Error al obtener materias aprobadas del alumno.",e);
		}

		Map<String, CriterioOrden> criterios = null;
		try
		{
			criterios = getCriteriosOrdenamiento(planEstudio);
		} catch (Exception e)
		{
			logger.error("Error al obtener los criterios de ordenamiento.",e);
			//e.printStackTrace();
		}
		
		long timeOut = 5;
		logger.info("Terminamos de cargar los datos dirty.");
		Inicializador initApp = new Inicializador();
		initApp.IniciarApp(materiasAprobadas, cursosDisponibles, planEstudio, criterios, timeOut);
	}

	private static Map<String, CriterioOrden> getCriteriosOrdenamiento(PlanEstudio planEstudio) throws Exception
	{
		CriterioOrden criterioOrdenPorMaterias = CriterioOrdenDAO.getInstancia()
				.getCriterioOrden(1);
		CriterioOrden criterioOrdenPorPoscorrelativas = new CriterioOrdenPorPoscorrelativas(
				planEstudio);
		
		List<CriterioOrden> co = new ArrayList<CriterioOrden>();
		co.add(criterioOrdenPorPoscorrelativas);
		co.add(criterioOrdenPorMaterias);
		CriterioOrden criterioOrdenSecuenciales = new CriterioOrdenSecuenciales(co);

		Map<String, CriterioOrden> criterios = new HashMap<String, CriterioOrden>();
		criterios.put("Materias", criterioOrdenPorMaterias);
		criterios.put("Poscorrelativas", criterioOrdenPorPoscorrelativas);
		criterios.put("Ambos", criterioOrdenSecuenciales);

		logger.info("Obtenemos criterio de ordenamiento.");
		return criterios;
	}

	private static Set<Curso> getCursosDeCarrera(Set<Curso> cursosDisponibles, Carrera carrera)
	{
		Set<Curso> cursosDeCarrera = new HashSet<Curso>();
		for (Curso c : cursosDisponibles)
		{
			if (c.getCarrera().getId() == carrera.getId())
			{
				cursosDeCarrera.add(c);
			}
		}
		logger.info("Obtenemos los cursos disponibles de esa carrera.");
		return cursosDeCarrera;
	}

	public static Set<Materia> getMateriasAprobadasFromAlumno(String alumno) throws Exception
	{
		if(alumno == null)
			return null;
		Set<Materia> materiasAprobadas = new HashSet<Materia>();
		materiasAprobadas.add(MateriaDAO.getInstancia().getMateria("Ingles Lectocomprension I"));
		materiasAprobadas.add(MateriaDAO.getInstancia()
				.getMateria("Introducción a la Programación"));
		materiasAprobadas.add(MateriaDAO.getInstancia().getMateria("Programación I"));
		materiasAprobadas.add(MateriaDAO.getInstancia().getMateria("Introducción a la Matemática"));

		logger.info("Obtenemos las materias aprobadas del alumno.");
		return materiasAprobadas;
	}

	private static void generarAltas() throws Exception
	{
		Persistor a = new Persistor();
		a.init();
		a.altaMaterias();
		a.altaCursos();
		a.altaPlanEstudio();
		a.altaCriterioOrden();
		logger.info("Damos de alta las instancias.");
	}
}
