package grc.servicios;

import java.util.Set;

import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.PlanEstudio;

public interface IUniversidad
{
	public Carrera getCarreraFromAlumno(String alumno);

	public Set<Curso> getCursos();

	public PlanEstudio getPlanEstudioFromCarrera(Carrera carrera);

}
