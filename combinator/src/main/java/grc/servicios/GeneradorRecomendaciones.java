package grc.servicios;

import grc.dominio.Curso;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeneradorRecomendaciones
{

	List<Curso> recomendacion;
	private long timeOut;
	private long timeInit;
	private boolean finishRecoOK;
	private boolean puedeEsperar;

	public GeneradorRecomendaciones(long timeOut, boolean puedeEsperar)
	{
		this.timeOut = timeOut;
		this.recomendacion = new ArrayList<Curso>();
		// finishRecoOK = true; //TODO: ver!!
		this.puedeEsperar = puedeEsperar;
	}

	public List<Curso> getRecomendacion()
	{
		return recomendacion;
	}

	public List<Recomendacion> generarRecomendaciones(List<Curso> cursos)
			throws ClassNotFoundException, IOException
	{
		List<Recomendacion> resultado = new ArrayList<Recomendacion>();
		RecomendacionParcial recomendacionParcial = new RecomendacionParcial();
		this.timeInit = new Date().getTime();
		armarSubconjuntos(resultado, cursos, recomendacionParcial, 0);
		return resultado;
	}

	private void armarSubconjuntos(List<Recomendacion> resultado, List<Curso> cursos,
			RecomendacionParcial recomendacionParcial, int desde)
	{
		long timeNow = new Date().getTime();
		if (!this.puedeEsperar && timeNow - this.timeInit > timeOut)
		{
			finishRecoOK = false;
			return;
		}

		if (desde == cursos.size()){
			this.finishRecoOK = true;
			return;
		}
		armarSubconjuntos(resultado, cursos, recomendacionParcial, desde + 1);

		if (recomendacionParcial.puedeAgregarCurso(cursos.get(desde)))
		{
			recomendacionParcial.agregarCurso(cursos.get(desde));
			resultado.add(new Recomendacion(recomendacionParcial.clone().getRecomendacion()));
			armarSubconjuntos(resultado, cursos, recomendacionParcial, desde + 1);
			recomendacionParcial.eliminarCurso(cursos.get(desde));
		}

	}

	public boolean isFinishRecoOK()
	{
		return finishRecoOK;
	}

}
