package grc.servicios;

import grc.app.Inicializador;
import grc.dominio.Curso;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

public class GeneradorRecomendaciones
{
	static Logger logger = Logger.getLogger(GeneradorRecomendaciones.class);
	Set<Curso> cursosRecomendables;
	private long timeOut;
	private long timeInit;
	private boolean generacionRecomendacionesCompletada;
	private boolean puedeEsperar;

	public GeneradorRecomendaciones(long timeOut, boolean puedeEsperar)
	{
		this.timeOut = timeOut;
		this.cursosRecomendables = new HashSet<Curso>();
		this.puedeEsperar = puedeEsperar;
		this.generacionRecomendacionesCompletada = false;
	}

	public List<Recomendacion> generarRecomendaciones(List<Curso> cursos)
	{
		List<Recomendacion> resultado = new ArrayList<Recomendacion>();
		RecomendacionParcial recomendacionParcial = new RecomendacionParcial();
		this.timeInit = new Date().getTime();
		armarSubconjuntos(resultado, cursos, recomendacionParcial, 0);
		logger.info("Generamos las recomendaciones.");
		return resultado;
	}

	private void armarSubconjuntos(List<Recomendacion> resultado, List<Curso> cursos,
			RecomendacionParcial recomendacionParcial, int desde)
	{
		long timeNow = new Date().getTime();
		if (!this.puedeEsperar && timeNow - this.timeInit > timeOut)
		{
			generacionRecomendacionesCompletada = false;
			return;
		}

		if (desde == cursos.size()){
			this.generacionRecomendacionesCompletada = true;
			return;
		}
		armarSubconjuntos(resultado, cursos, recomendacionParcial, desde + 1);

		if (recomendacionParcial.puedeAgregarCurso(cursos.get(desde)))
		{
			recomendacionParcial.agregarCurso(cursos.get(desde));
			resultado.add(new Recomendacion(recomendacionParcial.getCopiaCursosDeRecomendacion()));
			armarSubconjuntos(resultado, cursos, recomendacionParcial, desde + 1);
			recomendacionParcial.eliminarCurso(cursos.get(desde));
		}
	}

	public boolean generacionRecomendacionesCompletada()
	{
		return generacionRecomendacionesCompletada;
	}

}
