package grc.servicios;

import grc.dominio.PlanEstudio;
import java.util.Collections;

import java.util.ArrayList;
import java.util.List;

public class FiltroMaterias extends FiltroRecomendaciones
{
	public ArrayList<Integer> contar(List<Recomendacion> recomendaciones) 
	{
		ArrayList<Integer> cantidadMaterias = new ArrayList<Integer>();
		// Cuento la cantidad de poscorrelativas de cada recomendacion
		for (Recomendacion r : recomendaciones)
		{
			Integer cantMaterias = r.getRecomendacion().size();
			cantidadMaterias.add(cantMaterias);
		}
		return cantidadMaterias;
	}
	
	public List<Recomendacion> ordenar(List<Recomendacion> recomendaciones)
	{
		ArrayList<Integer> cantMaterias = contar(recomendaciones);
		return super.ordenar(recomendaciones, cantMaterias);
	}
}
