package grc.controlador;

import grc.dao.MateriaAprobadaDAO;
import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;
import grc.dominio.MateriaAprobada;
import grc.modelo.GRCModel;
import grc.servicios.CriterioOrden;
import grc.servicios.FiltroHorarios;
import grc.servicios.IFiltro;
import grc.servicios.Recomendacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

public class GRCController
{
	private GRCModel modelo;
	private boolean filtroManiana;
	private boolean filtroTarde;
	private boolean filtroNoche;
	private boolean filtroPuedeEsperar;
	private Map<String, CriterioOrden> criterios;
	
//TODO eliminar estados del controlador!!!
	public GRCController(GRCModel model, Map<String, CriterioOrden> criterios)
	{
		filtroManiana = false;
		filtroTarde = false;
		filtroNoche = false;
		filtroPuedeEsperar = false;
		this.modelo = model;
		this.criterios = criterios;
	}

	public DefaultTableModel cambiarTablaDias(Recomendacion recomendacion) throws Exception
	{
		String[] nombreColumnas = {"","Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
		DefaultTableModel tablaDias = new DefaultTableModel(null, nombreColumnas);
		iniciarValores(tablaDias);
		String nombreMateria = "";
		List<Recomendacion> recomendaciones = this.getModelo().getRecomendaciones();
		if (recomendaciones.isEmpty())
			return tablaDias;
		Recomendacion r = recomendacion;
		for (Curso c : r.getRecomendacion())
		{
			nombreMateria = c.getMateria().getNombre();
			for (Horario horario : c.getHorario())
			{
				Dia dia = horario.getDia();
				int horaInicio = horario.getHoraInicio();
				int horaFin = horario.getHoraFin();
				if (dia.name().equalsIgnoreCase("Lunes"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 1);
					}
				} else if (dia.name().equalsIgnoreCase("Martes"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 2);
					}
				} else if (dia.name().equalsIgnoreCase("Miercoles"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 3);
					}
				} else if (dia.name().equalsIgnoreCase("Jueves"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 4);
					}
				} else if (dia.name().equalsIgnoreCase("Viernes"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 5);
					}
				} else if (dia.name().equalsIgnoreCase("Sabado"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 6);
					}
				}
			}
		}
		return tablaDias;
	}

	public ArrayList<String> getRecomendaciones() throws Exception
	{
		return armarRecomendacion(this.getModelo().getRecomendaciones());
	}

	public DefaultTableModel getMateriasAprobadas(DefaultTableModel tablaDias) throws Exception
	{
		List<MateriaAprobada> matAprobadas = MateriaAprobadaDAO.getInstancia().obtenerTodo();
		String nombreMateria;
		double nota;
		for (int i = 0; i < matAprobadas.size(); i++)
		{
			nombreMateria = matAprobadas.get(i).getMateriaAprobada().getNombre();
			nota = matAprobadas.get(i).getNota();

			Object nuevaFilaDatos[] = {nombreMateria, nota};
			tablaDias.addRow(nuevaFilaDatos);
		}
		return tablaDias;
	}

	private DefaultTableModel iniciarValores(DefaultTableModel tablaDias)
	{
		tablaDias.setRowCount(14);
		int hora1 = 8;
		int hora2 = 9;
		for (int i = 0; i < tablaDias.getRowCount(); i++)
		{
			tablaDias.setValueAt(hora1 + " a " + hora2,i,0);
		      for(int j = 1; j < tablaDias.getColumnCount(); j++) 
		      {
		    	  tablaDias.setValueAt("", i, j);
		      }
		      hora1++;
		      hora2++;
		}
		return tablaDias;
	}

	public ArrayList<String> armarRecomendacion(List<Recomendacion> recomendaciones)
	{
		ArrayList<String> recomendacionesParaLista = new ArrayList<String>();
		for (Recomendacion r : recomendaciones)
		{
			String recoParaLista = "";
			for (Curso c : r.getRecomendacion())
			{
				recoParaLista += " " + c.getNombreCurso();
				for (int j = 0; j < c.getHorario().size(); j++)
				{
					recoParaLista += " Dia: " + c.getHorario().get(j).getDia();
					recoParaLista += " De: " + c.getHorario().get(j).getHoraInicio();
					recoParaLista += "hs a " + c.getHorario().get(j).getHoraFin() + " hs";
				}
				recoParaLista += "; ";
			}
			recomendacionesParaLista.add(recoParaLista);
		}
		if (recomendaciones.isEmpty())
		{
			recomendacionesParaLista
					.add("NO HAY CURSOS DISPONIBLES PARA CURSAR CON ESTOS CRITERIOS");
		}
		return recomendacionesParaLista;
	}

	public void filtrarTurnos() throws Exception
	{
		List<Horario> horarios = new ArrayList<Horario>();
		
		if (filtroManiana)
		{
			horarios.add(Horario.MAÑANA);
		}
		if (filtroTarde)
		{
			horarios.add(Horario.TARDE);
		}
		if (filtroNoche)
		{
			horarios.add(Horario.NOCHE);
		}

		IFiltro f = new FiltroHorarios(horarios);
		Set<Curso> cursosFiltradosPorHorario = f.filtrar(new HashSet<Curso>(this.getModelo().getCursosDisponibles()));
		 System.out.println("cantidad cursos: "+cursosFiltradosPorHorario.size());
		System.out.println("CANT RECOS ANTES: " + this.modelo.getRecomendaciones().size());
		this.modelo.actualizarRecomendaciones(cursosFiltradosPorHorario, this.filtroPuedeEsperar);
		System.out.println("CANT RECOS DESPUES: " + this.modelo.getRecomendaciones().size());
	}

	private GRCModel getModelo()
	{
		return this.modelo;
	}

	// public void setVista(GRCView vista)
	// {
	// this.vista = vista;
	// }

	public void generarRecomendaciones()
	{
		// cambioPreferencias();
		try
		{
			filtrarTurnos();
		} catch (Exception e)
		{
			System.out.println("ERROR AL FILTRAR!!!");
			e.printStackTrace();
		}

	}

	public void seleccionActualRecomendacion(int posElegida)
	{
		this.modelo.actualizarRecomendacionActual(posElegida);
	}

	public void ordenarRecomendaciones(String criterioElegido)
	{
		assert this.criterios.containsKey(criterioElegido);
		this.getModelo().actualizarOrdenamiento(this.criterios.get(criterioElegido));
	}
	
	public void filtrarManiana(boolean fm)
	{
		this.filtroManiana = fm;
	}

	public void filtrarTarde(boolean ft)
	{
		this.filtroTarde = ft;
	}
	
	public void filtrarNoche(boolean fn)
	{
		this.filtroNoche = fn;
	}
	
	public void puedeEsperar(boolean pe)
	{
		this.filtroPuedeEsperar = pe;
	}
}
