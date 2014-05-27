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
import grc.modelo.GRCModel;
import grc.servicios.Filtro;
import grc.servicios.Recomendacion;
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
		a.altaHorarios(); // NO alta!!!
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

		licSistemas = CarreraDAO.getInstancia().getCarrera(0);

		pe = PlanEstudioDAO.getInstancia().getPlanEstudioDeCarrera(licSistemas);
		matAprobadas = MateriaAprobadaDAO.getInstancia().obtenerTodo();

		Filtro fil = new Filtro();

			cursosDisponibles = fil.getCursosDisponibles(pe, matAprobadas);

		for (Curso c : cursosDisponibles)
		{
			System.out.println("nombre: " + c.getMateria().getNombre());
		}

		List<Curso> cursos = new ArrayList<Curso>(cursosDisponibles);
		long timeOut = 50;
		GRCModel model = new GRCModel(cursos, pe, timeOut);
		
		GRCController controller = new GRCController(model);
		GRCView vista = null;
		GRCViewText viewText = new GRCViewText(controller);
		vista = new GRCView(model, controller);
		model.addObserver(vista);
		model.addObserver(viewText);
		vista.showVista();
		viewText.menuPrincipal();
		model.actualizarRecomendaciones(cursos, false);
	}

}
