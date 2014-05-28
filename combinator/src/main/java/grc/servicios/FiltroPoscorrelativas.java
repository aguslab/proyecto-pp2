package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FiltroPoscorrelativas extends FiltroRecomendaciones
{
	public ArrayList<Integer> contarCantPosCorrelativas(List<Recomendacion> recomendaciones, PlanEstudio pe) 
	{
		HashMap<Materia, Set<Materia>> correlativas = pe.getCorrelativas();
		ArrayList<Integer> cantidadPoscorrelativas = new ArrayList<Integer>();
		Materia materia;
		for (Recomendacion r : recomendaciones) // Por cada recomendacion
		{
			Integer cantPosCorrelativas = 0;
			for (Curso c : r.getRecomendacion()) // Por cada curso
			{
				materia = c.getMateria();
				Collection<Set<Materia>> correl = correlativas.values();
				for (Set<Materia> mats : correl) //Contamos la cantidad de veces que 
				{
					for (Materia m : mats) //aparece una materia como correlativa de otras
					{
						if (m.getNombre().equalsIgnoreCase(materia.getNombre()))
						{
							cantPosCorrelativas++;
						}
					}
				}
			}
			cantidadPoscorrelativas.add(cantPosCorrelativas); // termino de contar y las
													// guardo en una lista
		}
		return cantidadPoscorrelativas;
	}
}
