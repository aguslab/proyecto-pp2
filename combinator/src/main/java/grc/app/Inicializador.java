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
import grc.dominio.MateriaAprobada;
import grc.dominio.PlanEstudio;
import grc.modelo.GRCModel;
import grc.servicios.Filtro;
import grc.vista.GRCView;

public class Inicializador
{

	public static void main(String[] args) throws Exception
	{

		Carrera licSistemas = null;
		PlanEstudio pe = null;
		List<MateriaAprobada> matAprobadas = null;
		Set<Curso> cursosDisponibles = null;

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
		
		GRCController controller = new GRCController();
		GRCView vista = null;

		vista = new GRCView(model, controller);
		model.addObserver(vista);
		model.actualizarRecomendaciones(cursos, false);
		vista.initVista();
	}

}
