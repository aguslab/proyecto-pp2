package grc.app;

import java.util.List;
import java.util.Set;

import grc.controlador.GRCController;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.modelo.GRCModel;
import grc.servicios.FiltroCursos;
import grc.servicios.Recomendacion;
import grc.servicios.Universidad;
import grc.vista.GRCView;
import grc.vista.GRCViewText;

public class Inicializador
{

private static void generarAltas() throws Exception
	{

		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
		a.init();
		// ALTAAAAAAAAAAAAAA
		a.altaMaterias();
		//a.altaHorarios(); // NO alta!!!
		a.altaCursos();
		a.altaMateriasAprobadas();
		a.altaPlanEstudio();

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

	public static void main(String[] args) throws Exception
	{

		String alumnoNombre = "cualquierCosa";
		Carrera licSistemas = null;
		PlanEstudio planEstudio = null;
		Set<Materia> matAprobadas = null;
		Set<Curso> cursosDisponibles = null;
		Universidad universidad = new Universidad();
		try
		{
//			 generarAltas();
		} catch (Exception e)
		{
			System.out.println("¡¡¡PROBLEMA AL GENERAR ALTAS!!!");
			e.printStackTrace();
		}
		
		licSistemas = universidad.getCarrerraFromAlumno(alumnoNombre);
		
		cursosDisponibles = universidad.getCursosFromCarrera(licSistemas);

		planEstudio = universidad.getPlanEstudioFromCarrera(licSistemas);
		matAprobadas = universidad.getMateriasAprobadasFromAlumno(alumnoNombre);

		FiltroCursos fil = new FiltroCursos();

		cursosDisponibles = fil.filtrarMateriasAprobadas(cursosDisponibles, matAprobadas);
		cursosDisponibles = fil.filtrarCorrelativas(planEstudio, cursosDisponibles, matAprobadas);

		for (Curso c : cursosDisponibles)
		{
			System.out.println("nombre: " + c.getNombreCurso());
		}

		long timeOut = 10;
		GRCModel model = new GRCModel(cursosDisponibles, planEstudio, timeOut);
		
		GRCController controller = new GRCController(model);
		GRCView vista = new GRCView(model, controller);
		GRCViewText viewText = new GRCViewText(controller);
		model.addObserver(vista);
		model.addObserver(viewText);
		vista.showVista();
		viewText.menuPrincipal();
//		model.actualizarRecomendaciones(cursos, false);
	}

}
