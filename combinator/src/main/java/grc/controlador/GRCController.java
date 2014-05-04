package grc.controlador;

import grc.dao.MateriaAprobadaDAO;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.MateriaAprobada;
import grc.servicios.Filtrador;
import grc.servicios.Recomendacion;
import grc.vista.GRCView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

public class GRCController
{
	private GRCView vista;
	private boolean filtroManiana;
	private boolean filtroTarde;
	private boolean filtroNoche;

	public GRCController()
	{
		filtroManiana = true;
		filtroTarde = true;
		filtroNoche = true;
	}

	public DefaultTableModel cambiarTablaDias(DefaultTableModel tablaDias, int posItemLista)
			throws Exception
	{
		String nombreMateria = "";
		List<Recomendacion> recomendaciones = this.vista.getModelo().getRecomendaciones();
		if (recomendaciones.isEmpty())
			return tablaDias;
		Recomendacion r = recomendaciones.get(posItemLista);
		for (Curso c : r.getRecomendacion())
		{
			nombreMateria = c.getMateria().getNombre();
			for (Horario horario : c.getHorario()) 
			{
				String dia = horario.getDia();
				int horaInicio = horario.getHoraInicio();
				int horaFin = horario.getHoraFin();
				if (dia.equalsIgnoreCase("Lunes")) {
					for (int i = horaInicio; i < horaFin; i++) {
						tablaDias.setValueAt(nombreMateria,  i-8,1);
					}
				} else if (dia.equalsIgnoreCase("Martes")) {
					for (int i = horaInicio; i < horaFin; i++) {
						tablaDias.setValueAt(nombreMateria,  i-8, 2);
					}
				} else if (dia.equalsIgnoreCase("Miercoles")) {
					System.out.println("HORAi" + horaInicio);
					System.out.println("HORA F" + horaFin);
					for (int i = horaInicio; i < horaFin; i++) {
						System.out.println(i);
						tablaDias.setValueAt(nombreMateria,  i-8, 3);
					}
				} else if (dia.equalsIgnoreCase("Jueves")) {
					for (int i = horaInicio; i < horaFin; i++) {
						tablaDias.setValueAt(nombreMateria,  i-8, 4);
					}
				} else if (dia.equalsIgnoreCase("Viernes")) {
					for (int i = horaInicio; i < horaFin; i++) {
						tablaDias.setValueAt(nombreMateria,  i-8, 5);
					}
				} else if (dia.equalsIgnoreCase("Sabado")) {
					for (int i = horaInicio; i < horaFin; i++) {
						tablaDias.setValueAt(nombreMateria,  i-8, 6);
					}
				}
			}
		}
		return tablaDias;
	}

	public ArrayList<String> getRecomendaciones() throws Exception
	{
		return armarRecomendacion(this.vista.getModelo().getRecomendaciones());
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

	public DefaultTableModel borrarValores(DefaultTableModel tablaDias)
	{
		tablaDias.setRowCount(14);
		tablaDias.setValueAt("8 a 9", 0, 0);
		tablaDias.setValueAt("9 a 10", 1, 0);
		tablaDias.setValueAt("10 a 11", 2, 0);
		tablaDias.setValueAt("11 a 12", 3, 0);
		tablaDias.setValueAt("12 a 13", 4, 0);
		tablaDias.setValueAt("13 a 14", 5, 0);
		tablaDias.setValueAt("14 a 15", 6, 0);
		tablaDias.setValueAt("15 a 16", 7, 0);
		tablaDias.setValueAt("16 a 17", 8, 0);
		tablaDias.setValueAt("17 a 18", 9, 0);
		tablaDias.setValueAt("18 a 19", 10, 0);
		tablaDias.setValueAt("19 a 20", 11, 0);
		tablaDias.setValueAt("20 a 21", 12, 0);
		tablaDias.setValueAt("21 a 22", 13, 0);
		
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
	

	public void filtrarTurnos(boolean filtro, String turno) throws Exception
	{
		List<Horario> horarios = new ArrayList<Horario>();
		Horario horarTmp;
		switch (turno) {
			case "M" :
				filtroManiana = filtro;
				break;
			case "T" :
				filtroTarde = filtro;
				break;
			case "N" :
				filtroNoche = filtro;
				break;
			default :
				break;
		}
		if (filtroManiana)
		{
			horarTmp = new Horario(8, 12);
			horarios.add(horarTmp);
		}
		if (filtroTarde)
		{
			horarTmp = new Horario(13, 17);
			horarios.add(horarTmp);
		}
		if (filtroNoche)
		{
			horarTmp = new Horario(18, 22);
			horarios.add(horarTmp);
		}

		Filtrador f = new Filtrador();
		Set<Curso> cursos = f.getCursosDisponibles(this.vista.getModelo().getCursosDisponibles(),
				horarios);
		List<Curso> cursosDisp = new ArrayList<Curso>(cursos);
		this.vista.getModelo().calcularRecomendaciones(cursosDisp);
	}

	public GRCView getVista()
	{
		return vista;
	}

	public void setVista(GRCView vista)
	{
		this.vista = vista;
	}

	public void cambioFiltros(boolean filtro, String turno)
	{
		try
		{
			filtrarTurnos(filtro, turno);
		} catch (Exception e)
		{
			System.out.println("ERROR AL FILTRAR!!!");
			e.printStackTrace();
		}

	}

}
