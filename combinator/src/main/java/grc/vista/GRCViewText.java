package grc.vista;

import edu.emory.mathcs.backport.java.util.Arrays;
import grc.controlador.GRCController;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.modelo.GRCModel;
import grc.servicios.Recomendacion;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class GRCViewText implements Observer
{
	private GRCController controller;

	public GRCViewText(GRCController controlador)
	{
		this.controller = controlador;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		GRCModel model = (GRCModel) o;
		this.printRecomendaciones(model.getRecomendaciones());
		try
		{
			this.volverAMenuPrincipal();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void main(String[] args)
	{
		try
		{
			menuPrincipal();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void menuPrincipal() throws Exception
	{
		boolean salir = false;
		limpiarPantalla();
		System.out.println("Bienvenido al Generador de Recomendaciones de Cursada");
		System.out.println();
		System.out
				.println("Indique qué turnos tiene disponibles. En caso de ser más de uno,\n separe las opciones con punto y coma.Ejemplo: si puede mañana y tarde, entonces ingrese \"1;2\":");
		System.out.println("1 - Mañana");
		System.out.println("2 - Tarde");
		System.out.println("3 - Noche");
		System.out.println("4 - Quitar todos los filtros");
		System.out.println("0 - Salir");
		String entradaTeclado = getOpcionUsuario();
//		List<String> opciones = Arrays.asList(entradaTeclado.split(";"));
//		for (String opc : opciones)
//		{
//		}

		switch (entradaTeclado) {
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
				controller.filtrarManiana(false);
				controller.filtrarTarde(false);
				controller.filtrarNoche(false);
				break;
			case "0" :
				System.out.println("Felicitaciones por usar el mejor y único recomendador de cursadas");
				break;
			default :
				System.out.println("Ingrese una opción correcta.");
				salir = true;
				break;
		}
		
		if(!salir){
			controller.filtrarTurnos();
			volverAMenuPrincipal();	
		}else{
			System.exit(0);
		}
		
	}

	public void volverAMenuPrincipal() throws Exception
	{
		System.out.println();
		String entradaTeclado;
		do
		{
			System.out.println("Para volver al menu principal presiones 1");
			entradaTeclado = getOpcionUsuario();
		} while (!entradaTeclado.equals("1"));
		{
			menuPrincipal();
		}
	}

	private String getOpcionUsuario()
	{
		Scanner entradaEscaner = new Scanner(System.in);
		String entradaTeclado = entradaEscaner.nextLine();
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

	private void printRecomendaciones(List<Recomendacion> recos)
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
