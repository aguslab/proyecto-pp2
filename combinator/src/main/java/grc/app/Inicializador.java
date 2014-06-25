package grc.app;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

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
import grc.vista.GRCVistaTexto;

public class Inicializador
{
	static Logger logger = Logger.getLogger(Inicializador.class);
	public void IniciarApp(Set<Materia> materiasAprobadas, Set<Curso> cursosDisponibles, PlanEstudio planEstudio, Map<String, CriterioOrden> criteriosOrdenamiento, long timeOut)
	{
		IFiltro filtro = new FiltroMateriasAprobadas(materiasAprobadas);
		cursosDisponibles = filtro.filtrar(cursosDisponibles);
		filtro = new FiltroCorrelativas(materiasAprobadas, planEstudio);
		cursosDisponibles = filtro.filtrar(cursosDisponibles);
		logger.info("Filtramos los cursos disponibles de materias aprobadas y poscorrelativas.");
		GRCModelo model = new GRCModelo(cursosDisponibles, criteriosOrdenamiento.get("Materias"), timeOut);
		EstadoFiltros estadoFiltros = new EstadoFiltros(true, true, true, true);
		GRCControlador controlador = new GRCControlador(model, criteriosOrdenamiento, estadoFiltros);
		GRCVista vista = new GRCVista(controlador, criteriosOrdenamiento.keySet());
		logger.info("Armamos el MVC.");
		GRCVistaTexto viewTexto = new GRCVistaTexto(controlador, model, criteriosOrdenamiento.keySet());

		model.addObserver(vista);
		model.addObserver(viewTexto);
		estadoFiltros.addObserver(vista);
		estadoFiltros.addObserver(viewTexto);
		vista.showVista();
		viewTexto.start();
		model.actualizarRecomendaciones(cursosDisponibles, true);
		logger.info("Terminamos de cargar datos limpios.");
	}

}
