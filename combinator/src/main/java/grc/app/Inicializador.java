package grc.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import grc.controlador.GRCController;
import grc.dao.CarreraDAO;
import grc.dao.MateriaAprobadaDAO;
import grc.dao.PlanEstudioDAO;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.MateriaAprobada;
import grc.dominio.PlanEstudio;
import grc.modelo.Modelo;
import grc.servicios.AdministradorCursos;
import grc.servicios.Recomendacion;
import grc.vista.GRCView;

public class Inicializador
{

	private static void generarAltas() throws Exception
	{

		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
		a.init();
		// ALTAAAAAAAAAAAAAA
		a.altaMaterias();
		a.altaHorarios(); // NO alta!!!
		a.altaCursos();
		a.altaMateriasAprobadas();
		a.altaPlanEstudio();

	}
	public static void main(String[] args)
	{

		Carrera licSistemas = null;
		PlanEstudio pe = null;
		List<MateriaAprobada> matAprobadas = null;
		Set<Curso> cursosDisponibles = null;
		try
		{
//			 generarAltas();
		} catch (Exception e)
		{
			System.out.println("¡¡¡PROBLEMA AL GENERAR ALTAS!!!");
			e.printStackTrace();
		}

		try
		{
			licSistemas = CarreraDAO.getInstancia().getCarrera(0);
			System.out.println(licSistemas.getNombre());
		} catch (Exception e1)
		{
			System.out.println("PROBLEMA AL OBTENER CARRERA!!!");
			e1.printStackTrace();
		}

		try
		{
			pe = PlanEstudioDAO.getInstancia().getPlanEstudioDeCarrera(licSistemas);
			pe.getCarrera().getNombre();
		} catch (Exception e)
		{
			System.out.println("PROBLEMA AL OBTENER PLAN DE ESTUDIOS!!!");
			e.printStackTrace();
		}
		try
		{
			matAprobadas = MateriaAprobadaDAO.getInstancia().obtenerTodo();
			matAprobadas.get(0).getMateriaAprobada().getNombre();
		} catch (Exception e)
		{
			System.out.println("PROBLEMA AL OBTENER MATERIAS APROBADAS!!!");
			e.printStackTrace();
		}

		AdministradorCursos ac = new AdministradorCursos();

		try
		{
			cursosDisponibles = ac.getCursosDisponibles(pe, matAprobadas);
		} catch (Exception e)
		{
			System.out.println("PROBLEMA AL OBTENER CURSOS DISPONIBLES!!!");
			e.printStackTrace();
		}

		System.out.println("CURSOS DISPONIBLES A CURSAR");
		for (Curso c : cursosDisponibles)
		{
			System.out.println("nombre: " + c.getMateria().getNombre());
		}

//		Recomendacion reco = new Recomendacion();
		List<Curso> cursos = new ArrayList<Curso>(cursosDisponibles);
//		try
//		{
//			recomendacionesCursos = reco.backtracking(cursos);
//		} catch (Exception e)
//		{
//			System.out.println("ERROR AL GENERAR RECOMEDACIONES!!!");
//			e.printStackTrace();
//		}
		
//		printRecomendaciones(recomendacionesCursos);
		long timeToWait = 1000;
		Modelo model = new Modelo(cursos, pe, timeToWait);
		
		GRCController controller = new GRCController();
		GRCView vista = null;
		try
		{
			vista = new GRCView(model, controller);
		} catch (Exception e1)
		{
			System.out.println("ERROR AL CREAR VIEW!!!");
			e1.printStackTrace();
		}
		model.addObserver(vista);
		try
		{
			model.calcularRecomendaciones(cursos);
		} catch (Exception e)
		{
			System.out.println("ERROR AL GENERAR RECOMEDACIONES!!!");
			e.printStackTrace();
		}
		try
		{
			vista.initVista();
		} catch (Exception e)
		{
			System.out.println("NO SE PUDO INICIAR LA VISTAAAAA");
			e.printStackTrace();
		}
		
	}

	public static void printRecomendaciones(List<Recomendacion> recos)
	{
	System.out.println();
		int i = 1;
		for (Recomendacion r : recos)
		{
			System.out.println("Recomendacion :"+i);
			i++;
			for (Curso c : r.getRecomendacion())
			{
				System.out.println("Curso: " + c.getMateria().getNombre());
				for (Horario h : c.getHorario())
				{
					System.out.println(h.getDia() + ": de " + h.getHoraInicio() + " a "
							+ h.getHoraFin() + "hs");
				}
			}
		}
	}

}
