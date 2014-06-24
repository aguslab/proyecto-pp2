package grc.controlador;

import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;
import grc.modelo.EstadoFiltros;
import grc.modelo.GRCModelo;
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

import org.apache.log4j.Logger;

public class GRCControlador
{
	static Logger logger = Logger.getLogger(GRCControlador.class);
	private GRCModelo modelo;
	private EstadoFiltros estadoFiltros;
	private Map<String, CriterioOrden> criterios;

	// TODO eliminar estados del controlador!!!
	public GRCControlador(GRCModelo model, Map<String, CriterioOrden> criterios, EstadoFiltros estadoFiltros)
	{
		this.modelo = model;
		this.estadoFiltros = estadoFiltros;
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
			nombreMateria = c.getNombreCortoCurso();
			for (Horario horario : c.getHorario())
			{
				int contadorPosicion = 0;
				Dia dia = horario.getDia();
				Double horaInicio = horario.getHoraInicio();
				Double horaFin = horario.getHoraFin();
				if (dia.name().equalsIgnoreCase("Lunes"))
				{
					for (Double i = horaInicio; i < horaFin; i++)
					{
						if (contadorPosicion == 1)
							tablaDias.setValueAt(nombreMateria, i.intValue() - 8, 1);
						else
							tablaDias.setValueAt(" ", i.intValue() - 8, 1);
						contadorPosicion++;
					}
				} 
				else if (dia.name().equalsIgnoreCase("Martes"))
				{
					for (Double i = horaInicio; i < horaFin; i++)
					{
						if (contadorPosicion == 1)
							tablaDias.setValueAt(nombreMateria, i.intValue() - 8, 2);
						else
							tablaDias.setValueAt(" ", i.intValue() - 8, 2);
						contadorPosicion++;
					}
				} 
				else if (dia.name().equalsIgnoreCase("Miercoles"))
				{
					for (Double i = horaInicio; i < horaFin; i++)
					{
						if (contadorPosicion == 1)
							tablaDias.setValueAt(nombreMateria, i.intValue() - 8, 3);
						else
							tablaDias.setValueAt(" ", i.intValue() - 8, 3);
						contadorPosicion++;
					}
				} 
				else if (dia.name().equalsIgnoreCase("Jueves"))
				{
					for (Double i = horaInicio; i < horaFin; i++)
					{
						if (contadorPosicion == 1)
							tablaDias.setValueAt(nombreMateria, i.intValue() - 8, 4);
						else
							tablaDias.setValueAt(" ", i.intValue() - 8, 4);
						contadorPosicion++;
					}
				} 
				else if (dia.name().equalsIgnoreCase("Viernes"))
				{
					for (Double i = horaInicio; i < horaFin; i++)
					{
						if (contadorPosicion == 1)
							tablaDias.setValueAt(nombreMateria, i.intValue() - 8, 5);
						else
							tablaDias.setValueAt(" ", i.intValue() - 8, 5);
						contadorPosicion++;
					}
				} 
				else if (dia.name().equalsIgnoreCase("Sabado"))
				{
					for (Double i = horaInicio; i < horaFin; i++)
					{
						if (contadorPosicion == 1)
							tablaDias.setValueAt(nombreMateria, i.intValue() - 8, 6);
						else
							tablaDias.setValueAt(" ", i.intValue() - 8, 6);
						contadorPosicion++;
					}
				}
			}
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
			tablaDias.setValueAt(hora1 + " a " + hora2, i, 0);
			for (int j = 1; j < tablaDias.getColumnCount(); j++)
			{
				tablaDias.setValueAt("", i, j);
			}
			hora1++;
			hora2++;
		}
		return tablaDias;
	}

	public void filtrarTurnos()
	{
		List<Horario> horarios = new ArrayList<Horario>();

		if (estadoFiltros.isFiltroMañana())
		{
			horarios.add(Horario.MAÑANA);
		}
		if (estadoFiltros.isFiltroTarde())
		{
			horarios.add(Horario.TARDE);
		}
		if (estadoFiltros.isFiltroNoche())
		{
			horarios.add(Horario.NOCHE);
		}

		IFiltro f = new FiltroHorarios(horarios);
		Set<Curso> cursosFiltradosPorHorario = f.filtrar(new HashSet<Curso>(this.getModelo()
				.getCursosDisponibles()));
//		System.out.println("cantidad cursos: " + cursosFiltradosPorHorario.size());
//		System.out.println("CANT RECOS ANTES: " + this.modelo.getRecomendaciones().size());
		this.modelo.actualizarRecomendaciones(cursosFiltradosPorHorario, this.estadoFiltros.isFiltroPuedeEsperar());
//		System.out.println("CANT RECOS DESPUES: " + this.modelo.getRecomendaciones().size())
		logger.info("Se filtraron las recomendaciones.");
	}

	private GRCModelo getModelo()
	{
		return this.modelo;
	}

	public void seleccionActualRecomendacion(int posElegida)
	{
		this.modelo.actualizarRecomendacionActual(posElegida);
	}

	public void setCriterioOrdenamiento(String criterioElegido)
	{
		assert this.criterios.containsKey(criterioElegido);
		this.getModelo().ordenarPorCriterio(this.criterios.get(criterioElegido));
	}

	public void filtrarManiana(boolean fm)
	{
		cambiarEstadoFiltroManiana(fm);
		this.filtrarTurnos();
		logger.info("Se eligió el filtro Mañana.");
	}

	public void filtrarTarde(boolean ft)
	{
		cambiarEstadoFiltroTarde(ft);
		this.filtrarTurnos();
		logger.info("Se eligió el filtro Tarde.");
	}

	public void filtrarNoche(boolean fn)
	{
		cambiarEstadoFiltroNoche(fn);
		this.filtrarTurnos();
		logger.info("Se eligió el filtro Noche.");
	}

	public void puedeEsperar(boolean puedeEsperarAhora)
	{
		boolean filtrar = false;
		if (!this.estadoFiltros.isFiltroPuedeEsperar() && puedeEsperarAhora)
		{
			filtrar = true;
		} else if (this.estadoFiltros.isFiltroPuedeEsperar() && !puedeEsperarAhora)
		{
			filtrar = false;
		}
		this.estadoFiltros.setFiltroPuedeEsperar(puedeEsperarAhora);
		if (filtrar)
		{
			filtrarTurnos();
		}
	}

	public void cambiarEstadoFiltroManiana(boolean fm)
	{
		this.estadoFiltros.setFiltroMañana(fm);
	}

	public void cambiarEstadoFiltroTarde(boolean ft)
	{
		this.estadoFiltros.setFiltroTarde(ft);
	}

	public void cambiarEstadoFiltroNoche(boolean fn)
	{
		this.estadoFiltros.setFiltroNoche(fn);
	}
}
