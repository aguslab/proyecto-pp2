package grc.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import grc.controlador.GRCControlador;
import grc.dao.CriterioOrdenDAO;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.modelo.EstadoFiltros;
import grc.modelo.GRCModelo;
import grc.servicios.CriterioOrden;
import grc.servicios.CriterioOrdenPorPoscorrelativas;
import grc.servicios.CriterioOrdenSecuenciales;
import grc.servicios.FiltroCorrelativas;
import grc.servicios.FiltroMateriasAprobadas;
import grc.servicios.IFiltro;
import grc.servicios.Universidad;
import grc.vista.GRCVista;
import grc.vista.GRCVistaTexto;

public class Inicializador
{

	public static void main(String[] args) throws Exception
	{
		String alumnoNombre = "cualquierCosa";
		Carrera licSistemas = null;
		PlanEstudio planEstudio = null;
		Set<Materia> matAprobadas = null;
		Set<Curso> cursosDisponibles = null;
		Universidad universidad = new Universidad();
		licSistemas = universidad.getCarrerraFromAlumno(alumnoNombre);
		
		cursosDisponibles = universidad.getCursosFromCarrera(licSistemas);

		planEstudio = universidad.getPlanEstudioFromCarrera(licSistemas);
		matAprobadas = universidad.getMateriasAprobadasFromAlumno(alumnoNombre);

		IFiltro filtro = new FiltroMateriasAprobadas(matAprobadas);
		cursosDisponibles = filtro.filtrar(cursosDisponibles);
		filtro = new FiltroCorrelativas(matAprobadas, planEstudio);
		cursosDisponibles = filtro.filtrar(cursosDisponibles);

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
		GRCModelo model = new GRCModelo(cursosDisponibles, criterioOrdenPorMaterias, timeOut);
		EstadoFiltros estadoFiltros = new EstadoFiltros(true, true, true, true);
		GRCControlador controller = new GRCControlador(model, criterios, estadoFiltros);
		GRCVista vista = new GRCVista(controller, criterios.keySet());
		GRCVistaTexto viewText = new GRCVistaTexto(controller, model, vista);
		model.addObserver(vista);
		model.addObserver(viewText);
		estadoFiltros.addObserver(vista);
		estadoFiltros.addObserver(viewText);
		vista.showVista();
//		viewText.start();
		model.actualizarRecomendaciones(cursosDisponibles, true);
	}

}
