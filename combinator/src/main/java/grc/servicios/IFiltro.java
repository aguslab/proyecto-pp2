package grc.servicios;

import grc.dominio.Curso;
import java.util.Set;

public interface IFiltro
{
	public Set<Curso> filtrar(Set<Curso> cursos);
}
