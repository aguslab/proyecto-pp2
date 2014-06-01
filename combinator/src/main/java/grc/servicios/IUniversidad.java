package grc.servicios;

import java.util.Set;

import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;

public interface IUniversidad
{
	public Carrera getCarrerraFromAlumno(String alumno);

	public Set<Curso> getCursosFromCarrera(Carrera carrera);

	public PlanEstudio getPlanEstudioFromCarrera(Carrera carrera);

	public Set<Materia> getMateriasAprobadasFromAlumno(String alumno);

}
