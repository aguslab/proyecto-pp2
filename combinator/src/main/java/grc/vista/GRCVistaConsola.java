package grc.vista;

import grc.controlador.GRCControlador;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.modelo.GRCModelo;
import grc.servicios.Recomendacion;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class GRCVistaConsola implements Observer
{
	private GRCControlador controller;
	private GRCModelo model;
	private GRCModelo modelActualizado;
	private boolean seActualizoElModelo;

	public GRCVistaConsola(GRCControlador controlador, GRCModelo model)
	{
		this.controller = controlador;
		this.model = model;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		this.modelActualizado = (GRCModelo) o;
		seActualizoElModelo = true;
		System.out.println("se actualizaron los datos, presione 'R' para actualizar");
	}

	private void mensajeInicial()
	{
		System.out.println(this.model.getListaRecomendacionesSugeridas().get(0));
		System.out.println();
		System.out.println("Hay " + this.model.getListaRecomendacionesSugeridas().size()
				+ " recomendaciones disponibles");
	}

	public void menuPrincipal() throws Exception
	{
		limpiarPantalla();
		System.out.println("Bienvenido al Generador de Recomendaciones de Cursada");
		System.out.println();
		this.controller.filtrarTurnos();
		System.out.println();
		mensajeInicial();
		mensajeAyuda();
		seleccionarOpcion();
	}

	private void mensajeAyuda()
	{
		System.out.println("presione h para obtener ayuda con los comandos");

	}

	private void mostrarAyuda()
	{
		System.out.println();
		System.out
				.println("Indique qué turnos tiene disponibles. En caso de ser más de uno,\n separe las opciones con punto y coma.Ejemplo: si puede mañana y tarde, entonces ingrese \"1;2\":");
		System.out.println("1 - Mañana");
		System.out.println("2 - Tarde");
		System.out.println("3 - Noche");
		System.out.println("4 - Quitar todos los filtros");
		System.out.println("T - Mostrar Lista de Recomendaciones");
		System.out.println("R - Actualizar");
		System.out.println("H - Ayuda");
		System.out.println("0 - Salir");
	}

	private void seleccionarOpcion()
	{
		boolean opcionSalir = false;
		String opcionUsuario = "x";
		while (!Opciones().contains(opcionUsuario))
		{
			opcionUsuario = getOpcionUsuario();
			switch (opcionUsuario) {
				case "1" :
					controller.filtrarManiana(true);
					break;
				case "2" :
					controller.filtrarTarde(true);
					break;
				case "3" :
					controller.filtrarNoche(true);
					break;
				case "4" :
					controller.cambiarEstadoFiltroManiana(false);
					controller.cambiarEstadoFiltroTarde(false);
					controller.cambiarEstadoFiltroNoche(false);
					controller.filtrarTurnos();
					actualizar();
					break;
				case "t" :
					mostrarListaRecomendaciones();
					break;
				case "T" :
					mostrarListaRecomendaciones();
					break;
				case "r" :
					actualizar();
					break;
				case "R" :
					actualizar();
					break;
				case "h" :
					mostrarAyuda();
					break;
				case "H" :
					mostrarAyuda();
					break;
				case "0" :
					System.out
							.println("Felicitaciones por usar el mejor y único recomendador de cursadas");
					opcionSalir = true;
					break;
				default :
					System.out.println("Ingrese una opción correcta.");
					break;
			}
		}

		if (opcionSalir)
		{
			System.exit(0);
		} else
		{
			mensajeInicial();
			seleccionarOpcion();
		}
	}

	private void mostrarListaRecomendaciones()
	{
		for (String r : this.model.getListaRecomendacionesSugeridas())
		{
			System.out.println(r);
		}
	}

	private void actualizar()
	{
		if (seActualizoElModelo)
		{
			this.model = this.modelActualizado.clone();
		}
		mensajeInicial();
	}

	private String Opciones()
	{
		return "1,2,3,4,r,R,h,H,0";
	}

	// public void volverAMenuPrincipal() throws Exception
	// {
	// System.out.println();
	// String entradaTeclado;
	// do
	// {
	// System.out.println("Para volver al menu principal presiones 1");
	// entradaTeclado = getOpcionUsuario();
	// } while (!entradaTeclado.equals("1"));
	// {
	// menuPrincipal();
	// }
	// }

	private String getOpcionUsuario()
	{
		mensajeAyuda();
		String entradaTeclado = new Scanner(System.in).nextLine();
		return entradaTeclado;
	}

	private void limpiarPantalla()
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	private void mostrarTodasLasRecomendaciones(List<Recomendacion> recos)
	{
		System.out.println();
		int i = 1;
		for (Recomendacion r : recos)
		{
			System.out.println();
			System.out.println("Recomendacion :" + i);
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
}
