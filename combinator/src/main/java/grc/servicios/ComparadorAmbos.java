package grc.servicios;

import grc.dominio.PlanEstudio;

import java.util.List;

public class ComparadorAmbos extends Comparador
{
	List<Character> criterio;
	PlanEstudio planEstudio;
	
	public  ComparadorAmbos(List<Character> criterio, PlanEstudio planEstudio)
	{
		this.criterio = criterio;
		this.planEstudio = planEstudio;
	}
	
	@Override
	public int compare(Recomendacion o1, Recomendacion o2) 
	{
		Integer resultado;
		
		Boolean criterioMateria = criterio.get(2).equals('d') ? true : false;
		ComparadorMaterias comparadorMaterias = new ComparadorMaterias(criterioMateria);
		ComparadorPoscorrelativas comparadorPoscorrelativas = new ComparadorPoscorrelativas(planEstudio);
		
		Integer cantidadMateriasRecomendacion1 = comparadorMaterias.contarCantidadMaterias(o1);
		Integer cantidadMateriasRecomendacion2 = comparadorMaterias.contarCantidadMaterias(o2);
		Integer cantidadPoscorrelativasRecomendacion1 = comparadorPoscorrelativas.contarCantidadPoscorrelativas(o1, planEstudio);
		Integer cantidadPoscorrelativasRecomendacion2 = comparadorPoscorrelativas.contarCantidadPoscorrelativas(o2, planEstudio);
		
		if(criterio.get(0).equals('a')) //comparar por mayor cantidad materia y si hay empate por mayor cantidad poscorrelativas 
		{
			resultado = cantidadMateriasRecomendacion2 - cantidadMateriasRecomendacion1;
			if(resultado.equals(0)) //Si hay empate, ordenar por poscorrelativas
			{
				resultado = cantidadPoscorrelativasRecomendacion2 - cantidadPoscorrelativasRecomendacion1;
			}
		}
		else if(criterio.get(0).equals('b'))//comparar por menor cantidad materia y si hay empate por mayor cantidad poscorrelativas
		{
			resultado = cantidadMateriasRecomendacion1 - cantidadMateriasRecomendacion2; 
			if(resultado.equals(0)) //Si hay empate, ordenar por poscorrelativas
			{
				resultado = cantidadPoscorrelativasRecomendacion2 - cantidadPoscorrelativasRecomendacion1;
			}
		}
		else if(criterio.get(0).equals('c') && criterio.get(1).equals('a') )//comparar por mayor cantidad poscorrelativas y si hay
																			//empate por mayor cantidad materias
		{
			resultado = cantidadPoscorrelativasRecomendacion2 - cantidadPoscorrelativasRecomendacion1;
			if(resultado.equals(0)) //Si hay empate, ordenar por mayor cantidad de materias
			{
				resultado = cantidadMateriasRecomendacion2 - cantidadMateriasRecomendacion1;
			}
		}
		else //comparar por mayor cantidad poscorrelativas y si hay empate por menor cantidad materias
		{
			resultado = cantidadPoscorrelativasRecomendacion2 - cantidadPoscorrelativasRecomendacion1;
			if(resultado.equals(0))
			{
				resultado = cantidadMateriasRecomendacion1 - cantidadMateriasRecomendacion2;
			}
		}
			return resultado;
	}
	
	public void setPlanEstudio(PlanEstudio planEstudio)
	{
		this.planEstudio = planEstudio;
	}
}
