package grc.controlador;

import grc.dao.MateriaAprobadaDAO;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.MateriaAprobada;
import grc.modelo.GRCModel;
import grc.servicios.Filtro;
import grc.servicios.Recomendacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

public class GRCController
{
	private GRCModel modelo;
	private boolean filtroManiana;
	private boolean filtroTarde;
	private boolean filtroNoche;
	private boolean filtroPuedeEsperar;

	public GRCController(GRCModel model)
	{
		filtroManiana = false;
		filtroTarde = false;
		filtroNoche = false;
		filtroPuedeEsperar = false;
		this.modelo = model;
	}

	public void cambiarTablaDias(DefaultTableModel tablaDias, int posItemLista) throws Exception
	{
		String nombreMateria = "";
		List<Recomendacion> recomendaciones = null;// this.vista.getModelo().getRecomendaciones();
		if (recomendaciones.isEmpty())
			return;
		Recomendacion r = recomendaciones.get(posItemLista);
		for (Curso c : r.getRecomendacion())
		{
			nombreMateria = c.getMateria().getNombre();
			for (Horario horario : c.getHorario())
			{
				String dia = horario.getDia();
				int horaInicio = horario.getHoraInicio();
				int horaFin = horario.getHoraFin();
				if (dia.equalsIgnoreCase("Lunes"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 1);
					}
				} else if (dia.equalsIgnoreCase("Martes"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 2);
					}
				} else if (dia.equalsIgnoreCase("Miercoles"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 3);
					}
				} else if (dia.equalsIgnoreCase("Jueves"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 4);
					}
				} else if (dia.equalsIgnoreCase("Viernes"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 5);
					}
				} else if (dia.equalsIgnoreCase("Sabado"))
				{
					for (int i = horaInicio; i < horaFin; i++)
					{
						tablaDias.setValueAt(nombreMateria, i - 8, 6);
					}
				}
			}
		}
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

//	private DefaultTableModel borrarValores(DefaultTableModel tablaDias)
//	{
//		tablaDias.setRowCount(14);
//		tablaDias.setValueAt("8 a 9", 0, 0);
//		tablaDias.setValueAt("9 a 10", 1, 0);
//		tablaDias.setValueAt("10 a 11", 2, 0);
//		tablaDias.setValueAt("11 a 12", 3, 0);
//		tablaDias.setValueAt("12 a 13", 4, 0);
//		tablaDias.setValueAt("13 a 14", 5, 0);
//		tablaDias.setValueAt("14 a 15", 6, 0);
//		tablaDias.setValueAt("15 a 16", 7, 0);
//		tablaDias.setValueAt("16 a 17", 8, 0);
//		tablaDias.setValueAt("17 a 18", 9, 0);
//		tablaDias.setValueAt("18 a 19", 10, 0);
//		tablaDias.setValueAt("19 a 20", 11, 0);
//		tablaDias.setValueAt("20 a 21", 12, 0);
//		tablaDias.setValueAt("21 a 22", 13, 0);
//
//		return tablaDias;
//	}

	public ArrayList<String> armarRecomendacion(List<Recomendacion> recomendaciones)
	{
		ArrayList<String> recomendacionesParaLista = new ArrayList<String>();
		for (Recomendacion r : recomendaciones)
		{
			String recoParaLista = "";
			for (Curso c : r.getRecomendacion())
			{
				recoParaLista += " " + c.getMateria().getNombre();
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
			System.out.println("MAÑANA");
			Horario horarTmp = new Horario(8, 12);
			horarios.add(horarTmp);
		}
		if (filtroTarde)
		{
			System.out.println("tarde");
			Horario horarTmp = new Horario(13, 17);
			horarios.add(horarTmp);
		}
		if (filtroNoche)
		{
			System.out.println("noche");
			Horario horarTmp = new Horario(18, 22);
			horarios.add(horarTmp);
		}

		Filtro f = new Filtro();
		Set<Curso> cursos = f.getCursosDisponibles(this.getModelo().getCursosDisponibles(),
				horarios);
		 System.out.println("cantidad cursos: "+cursos.size());
		 List<Curso> cursosDisp = new ArrayList<Curso>(cursos);
		System.out.println("CANT RECOS ANTES: " + this.modelo.getRecomendaciones().size());
		this.modelo.actualizarRecomendaciones(cursosDisp, this.filtroPuedeEsperar);
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

	// public void cambioPreferencias()
	// {
	// this.filtroManiana = this.vista.getCbManiana();
	// this.filtroTarde = this.vista.getCbTarde();
	// this.filtroNoche = this.vista.getCbNoche();
	// this.filtroPuedeEsperar = this.vista.puedeEsperar();
	// }

	public void seleccionActualRecomendacion(int posElegida)
	{
		this.modelo.actualizarRecomendacionActual(posElegida);

	}

	public void filtrarRecomendaciones(boolean ordMaterias, boolean ordPoscorrelativas)
	{
		this.getModelo().actualizarOrdenamiento(ordMaterias, ordPoscorrelativas);
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
