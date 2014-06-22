package grc.app;

import java.util.Map;
import java.util.Set;

import grc.controlador.GRCControlador;
import grc.dominio.Curso;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.modelo.EstadoFiltros;
import grc.modelo.GRCModelo;
import grc.servicios.CriterioOrden;
import grc.servicios.FiltroCorrelativas;
import grc.servicios.FiltroMateriasAprobadas;
import grc.servicios.IFiltro;
import grc.vista.GRCVista;

public class Inicializador
{

	public void IniciarApp(Set<Materia> materiasAprobadas, Set<Curso> cursosDisponibles, PlanEstudio planEstudio, Map<String, CriterioOrden> criteriosOrdenamiento, long timeOut)
	{
		IFiltro filtro = new FiltroMateriasAprobadas(materiasAprobadas);
		cursosDisponibles = filtro.filtrar(cursosDisponibles);
		filtro = new FiltroCorrelativas(materiasAprobadas, planEstudio);
		cursosDisponibles = filtro.filtrar(cursosDisponibles);

		GRCModelo model = new GRCModelo(cursosDisponibles, criteriosOrdenamiento.get("Materias"), timeOut);
		EstadoFiltros estadoFiltros = new EstadoFiltros(true, true, true, true);
		GRCControlador controlador = new GRCControlador(model, criteriosOrdenamiento, estadoFiltros);
		GRCVista vista = new GRCVista(controlador, criteriosOrdenamiento.keySet());
//		GRCVistaTexto viewText = new GRCVistaTexto(controller, model, vista);
		model.addObserver(vista);
//		model.addObserver(viewText);
		estadoFiltros.addObserver(vista);
//		estadoFiltros.addObserver(viewText);
		vista.showVista();
//		viewText.start();
		model.actualizarRecomendaciones(cursosDisponibles, true);
	}

}
