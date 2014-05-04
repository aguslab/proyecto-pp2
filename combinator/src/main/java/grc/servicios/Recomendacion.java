package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Recomendacion implements Serializable
{

	private static final long serialVersionUID = 1L;
	List<Curso> recomendacion;
	boolean[] lunes = new boolean[24];
	boolean[] martes = new boolean[24];
	boolean[] miercoles = new boolean[24];
	boolean[] jueves = new boolean[24];
	boolean[] viernes = new boolean[24];
	boolean[] sabado = new boolean[24];

	private long timeToWait;
	private long timeInit;
	private boolean finishRecoOK;
	
	public Recomendacion(long timeToWait)
	{
		this.timeToWait = timeToWait;
		this.recomendacion = new ArrayList<Curso>();
		finishRecoOK = true;
	}

	public List<Curso> getRecomendacion()
	{
		return recomendacion;
	}

	public List<Recomendacion> backtracking(List<Curso> cursos) throws ClassNotFoundException,
			IOException
	{
		List<Recomendacion> resultado = new ArrayList<Recomendacion>();
		Recomendacion recomendaciontemp = new Recomendacion(timeToWait);
		this.timeInit = new Date().getTime();
		armarSubconjuntos(resultado, cursos, recomendaciontemp, 0);
		return resultado;
	}

	private void armarSubconjuntos(List<Recomendacion> resultado, List<Curso> cursos,
			Recomendacion recomendaciontemp, int desde) throws ClassNotFoundException, IOException
	{

		long timeNow = new Date().getTime();
		if (timeNow - this.timeInit > timeToWait)
		{
			System.out.println("SE PASO EL TIEMPO!!!");
			finishRecoOK = false;
			return;
		}

		if (desde == cursos.size())
			return;

		armarSubconjuntos(resultado, cursos, recomendaciontemp, desde + 1);

		if (recomendaciontemp.sePuedeAgregar(cursos.get(desde)))
		{
			recomendaciontemp.agregarCurso(cursos.get(desde));
			resultado.add(recomendaciontemp.clonar());
			armarSubconjuntos(resultado, cursos, recomendaciontemp, desde + 1);
			recomendaciontemp.eliminarCurso(cursos.get(desde));
		}

	}

	public ArrayList<Integer> cantMaterias(List<Recomendacion> recomendaciones)
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

	public ArrayList<Integer> cantPosCorrelativas(List<Recomendacion> recomendaciones,
			PlanEstudio pe)
	{
		HashMap<Materia, Set<Materia>> correlativas = pe.getCorrelativas();
		ArrayList<Integer> cantidadPoscorrelativas = new ArrayList<Integer>();
		Materia materia;
		int la = 0;
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
				System.out.println(c.getMateria().getNombre());
			}
			System.out.println("Reco " + la +" Cantidad: " + cantPosCorrelativas);
			la++;
			System.out.println("-----------------------------------------------------");
			cantidadPoscorrelativas.add(cantPosCorrelativas); // termino de contar y las
													// guardo en una lista
		}
		return cantidadPoscorrelativas;
	}

	public List<Recomendacion> ordenarRecomendaciones(List<Recomendacion> recomendaciones,
			ArrayList<Integer> cantidad)
	{
		System.out.println("cantidad de recos" + recomendaciones.size());
		// ordeno segun las cantidades de poscorrelativas de cada recomendacion
		Recomendacion rTemp;
		int temp, j;
		for (int i = 1; i < cantidad.size(); i++)
		{
			temp = cantidad.get(i);
			rTemp = recomendaciones.get(i);
			j = i;
			while (j > 0 && cantidad.get(j - 1) < temp)
			{
				cantidad.set(j, cantidad.get(j - 1));
				recomendaciones.set(j, recomendaciones.get(j - 1));
				j--;
			}
			cantidad.set(j, temp);
			recomendaciones.set(j, rTemp);
		}
		return recomendaciones;
	}

	private void agregarCurso(Curso curso)
	{
		this.recomendacion.add(curso);
		this.agregarHorariosRecomendacion(curso);
	}

	private void eliminarCurso(Curso curso)
	{
		this.recomendacion.remove(curso);
		this.limpiarHorariosRecomendacion(curso);
	}

	private void agregarHorariosRecomendacion(Curso curso)
	{
		this.setearHorariosRecomendacion(curso, true);
	}

	private void limpiarHorariosRecomendacion(Curso curso)
	{
		this.setearHorariosRecomendacion(curso, false);
	}

	private Recomendacion clonar() throws IOException, ClassNotFoundException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(this);
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);

		return (Recomendacion) ois.readObject();
	}

	private void setearHorariosRecomendacion(Curso curso, boolean valorASetear)
	{
		for (Horario horario : curso.getHorario())
		{
			String dia = horario.getDia();
			int horaInicio = horario.getHoraInicio();
			int horaFin = horario.getHoraFin();
			if (dia.equalsIgnoreCase("Lunes"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					lunes[i] = valorASetear;
				}
			} else if (dia.equalsIgnoreCase("Martes"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					martes[i] = valorASetear;
				}
			} else if (dia.equalsIgnoreCase("Miercoles"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					miercoles[i] = valorASetear;
				}
			} else if (dia.equalsIgnoreCase("Jueves"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					jueves[i] = valorASetear;
				}
			} else if (dia.equalsIgnoreCase("Viernes"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					viernes[i] = valorASetear;
				}
			} else if (dia.equalsIgnoreCase("Sabado"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					sabado[i] = valorASetear;
				}
			}
		}

	}

	private boolean sePuedeAgregar(Curso curso)
	{
		boolean horarioVacio = true;
		for (Horario horario : curso.getHorario())
		{
			String dia = horario.getDia();
			int horaInicio = horario.getHoraInicio();
			int horaFin = horario.getHoraFin();

			if (dia.equalsIgnoreCase("Lunes"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					horarioVacio = horarioVacio && (lunes[i] == false);
				}
			} else if (dia.equalsIgnoreCase("Martes"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					horarioVacio = horarioVacio && (martes[i] == false);
				}
			} else if (dia.equalsIgnoreCase("Miercoles"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					horarioVacio = horarioVacio && (miercoles[i] == false);
				}
			} else if (dia.equalsIgnoreCase("Jueves"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					horarioVacio = horarioVacio && (jueves[i] == false);
				}
			} else if (dia.equalsIgnoreCase("Viernes"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					horarioVacio = horarioVacio && (viernes[i] == false);
				}
			} else if (dia.equalsIgnoreCase("Sabado"))
			{
				for (int i = horaInicio; i < horaFin; i++)
				{
					horarioVacio = horarioVacio && (sabado[i] == false);
				}
			}
		}

		return horarioVacio;
	}

	public boolean isFinishRecoOK()
	{
		return finishRecoOK;
	}

	public void setRecomendacion(List<Curso> recomendacion)
	{
		this.recomendacion = recomendacion;
	}
	
}
