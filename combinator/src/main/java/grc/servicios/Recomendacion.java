package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.Horario;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Recomendacion implements Serializable {

	private static final long serialVersionUID = 1L;
	List<Curso> recomendacion;
	boolean[] lunes = new boolean[24];
	boolean[] martes = new boolean[24];
	boolean[] miercoles = new boolean[24];
	boolean[] jueves = new boolean[24];
	boolean[] viernes = new boolean[24];
	boolean[] sabado = new boolean[24];
	
	private long timeToWait = 1;
	private long timeInit;
	private boolean finishRecoOK = true;
	public Recomendacion() {
		this.recomendacion = new ArrayList<Curso>();
	}

	public List<Curso> getRecomendacion() {
		return recomendacion;
	}

	public List<Recomendacion> backtracking(List<Curso> cursos) throws ClassNotFoundException,
			IOException {
		List<Recomendacion> resultado = new ArrayList<Recomendacion>();
		Recomendacion recomendaciontemp = new Recomendacion();
		timeInit = new Date().getTime();
		armarSubconjuntos(resultado, cursos, recomendaciontemp, 0);
		return resultado;
	}

	private void armarSubconjuntos(List<Recomendacion> resultado, List<Curso> cursos,
			Recomendacion recomendaciontemp, int desde) throws ClassNotFoundException, IOException {
		
		long timeNow = new Date().getTime();
		if (timeNow - this.timeInit > timeToWait){
			System.out.println("SE PASO EL TIEMPO!!!");
			finishRecoOK = false;
			return;
		}
			
		if (desde == cursos.size())
			return;

		armarSubconjuntos(resultado, cursos, recomendaciontemp, desde + 1);

		if (recomendaciontemp.sePuedeAgregar(cursos.get(desde))) {
			recomendaciontemp.agregarCurso(cursos.get(desde));
			resultado.add(recomendaciontemp.clonar());
			armarSubconjuntos(resultado, cursos, recomendaciontemp, desde + 1);
			recomendaciontemp.eliminarCurso(cursos.get(desde));
		}

	}

	private void agregarCurso(Curso curso) {
		this.recomendacion.add(curso);
		this.agregarHorariosRecomendacion(curso);
	}

	private void eliminarCurso(Curso curso) {
		this.recomendacion.remove(curso);
		this.limpiarHorariosRecomendacion(curso);
	}

	private void agregarHorariosRecomendacion(Curso curso) {
		this.setearHorariosRecomendacion(curso, true);
	}

	private void limpiarHorariosRecomendacion(Curso curso) {
		this.setearHorariosRecomendacion(curso, false);
	}

	private Recomendacion clonar() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(this);
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);

		return (Recomendacion) ois.readObject();
	}

	private void setearHorariosRecomendacion(Curso curso, boolean valorASetear) {
		for (Horario horario : curso.getHorario()) {
			String dia = horario.getDia();
			int horaInicio = horario.getHoraInicio();
			int horaFin = horario.getHoraFin();
			if (dia.equalsIgnoreCase("Lunes")) {
				for (int i = horaInicio; i < horaFin; i++) {
					lunes[i] = valorASetear;
				}
			} else if (dia.equalsIgnoreCase("Martes")) {
				for (int i = horaInicio; i < horaFin; i++) {
					martes[i] = valorASetear;
				}
			} else if (dia.equalsIgnoreCase("Miercoles")) {
				for (int i = horaInicio; i < horaFin; i++) {
					miercoles[i] = valorASetear;
				}
			} else if (dia.equalsIgnoreCase("Jueves")) {
				for (int i = horaInicio; i < horaFin; i++) {
					jueves[i] = valorASetear;
				}
			} else if (dia.equalsIgnoreCase("Viernes")) {
				for (int i = horaInicio; i < horaFin; i++) {
					viernes[i] = valorASetear;
				}
			} else if (dia.equalsIgnoreCase("Sabado")) {
				for (int i = horaInicio; i < horaFin; i++) {
					sabado[i] = valorASetear;
				}
			}
		}

	}

	private boolean sePuedeAgregar(Curso curso) {
		boolean horarioVacio = true;
		for (Horario horario : curso.getHorario()) {
			String dia = horario.getDia();
			int horaInicio = horario.getHoraInicio();
			int horaFin = horario.getHoraFin();

			if (dia.equalsIgnoreCase("Lunes")) {
				for (int i = horaInicio; i < horaFin && horarioVacio; i++) {
					horarioVacio = horarioVacio && (lunes[i] == false);
				}
			} else if (dia.equalsIgnoreCase("Martes")) {
				for (int i = horaInicio; i < horaFin && horarioVacio; i++) {
					horarioVacio = horarioVacio && (martes[i] == false);
				}
			} else if (dia.equalsIgnoreCase("Miercoles")) {
				for (int i = horaInicio; i < horaFin && horarioVacio; i++) {
					horarioVacio = horarioVacio && (miercoles[i] == false);
				}
			} else if (dia.equalsIgnoreCase("Jueves")) {
				for (int i = horaInicio; i < horaFin && horarioVacio; i++) {
					horarioVacio = horarioVacio && (jueves[i] == false);
				}
			} else if (dia.equalsIgnoreCase("Viernes")) {
				for (int i = horaInicio; i < horaFin && horarioVacio; i++) {
					horarioVacio = horarioVacio && (viernes[i] == false);
				}
			} else if (dia.equalsIgnoreCase("Sabado")) {
				for (int i = horaInicio; i < horaFin && horarioVacio; i++) {
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

}
