package grc.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import grc.controlador.GRCController;
import grc.dao.CriterioOrdenDAO;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.modelo.GRCModel;
import grc.servicios.CriterioOrden;
import grc.servicios.CriterioOrdenPorPoscorrelativas;
import grc.servicios.CriterioOrdenSecuenciales;
import grc.servicios.FiltroCorrelativas;
import grc.servicios.FiltroMateriasAprobadas;
import grc.servicios.IFiltro;
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
		a.altaCriterioOrden();
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

		IFiltro filtro = new FiltroMateriasAprobadas(matAprobadas);
		cursosDisponibles = filtro.filtrar(cursosDisponibles);
		filtro = new FiltroCorrelativas(matAprobadas, planEstudio);
		cursosDisponibles = filtro.filtrar(cursosDisponibles);

//		for (Curso c : cursosDisponibles)
//		{
//			System.out.println("nombre: " + c.getNombreCurso());
//		}
		
		final CriterioOrden criterioOrdenPorMaterias = CriterioOrdenDAO.getInstancia().getCriterioOrden(1);
		final CriterioOrden criterioOrdenPorPoscorrelativas = new CriterioOrdenPorPoscorrelativas(planEstudio);
		final List<CriterioOrden> co = new ArrayList<CriterioOrden>();
		co.add(criterioOrdenPorPoscorrelativas);
		co.add(criterioOrdenPorMaterias);
		CriterioOrden criterioOrdenSecuenciales = new CriterioOrdenSecuenciales(co);
		
		Map<String, CriterioOrden> criterios = new HashMap<String, CriterioOrden>();
		criterios.put("Materias", criterioOrdenPorMaterias);
		criterios.put("Poscorrelativas", criterioOrdenPorPoscorrelativas);
		criterios.put("Ambos", criterioOrdenSecuenciales);

		long timeOut = 10;
		GRCModel model = new GRCModel(cursosDisponibles, criterioOrdenPorMaterias, timeOut);
		GRCController controller = new GRCController(model, criterios);
		GRCView vista = new GRCView(controller, criterios.keySet());
		GRCViewText viewText = new GRCViewText(controller, model);
		model.addObserver(vista);
//		model.addObserver(viewText);
		vista.showVista();
//		viewText.menuPrincipal();
//		model.actualizarRecomendaciones(cursos, false);
	}

}
