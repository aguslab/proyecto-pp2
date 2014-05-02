package grc.dao;

import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Horario;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CursoDAO
{
	private static CursoDAO instancia = null;
	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;
	public static CursoDAO getInstancia() throws Exception
	{
		if (instancia == null)
		{
			instancia = new CursoDAO();
		}
		em = EntityManagerUtil.getNewEM();
		return instancia;
	}

	public void alta(Curso C) throws Exception
	{
		try
		{
			em.getTransaction().begin();
			em.merge(C);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e)
		{
			em.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Curso> obtenerTodo()
	{
		List<Curso> a = null;
		Query query = em.createQuery("from Curso");
		a = query.getResultList();
		return a;
	}

	public Curso getCurso(int id)
	{
		Curso S = em.find(Curso.class, id);
		return S;
	}

	@SuppressWarnings("unchecked")
	public Set<Curso> getCursosPorTurno(Integer horaInicio, Integer horaFin)
	{
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Curso> cq = builder.createQuery(Curso.class);
		Root<Curso> cur = cq.from(Curso.class);
		cq.select(cur);
		// TODO: agregar metaclases!
		Join<Curso, Horario> jo = cur.join("horarios");
		Predicate conjuncion = builder.conjunction();

		conjuncion.getExpressions().add(
				builder.ge(jo.get("horaInicio").as(Integer.class), horaInicio));
		conjuncion.getExpressions().add(builder.le(jo.get("horaFin").as(Integer.class), horaFin));

		cq.where(conjuncion);
		TypedQuery<?> q = em.createQuery(cq);

		List<Curso> cursos = (List<Curso>) q.getResultList();
		Set<Curso> curs = new HashSet<Curso>(cursos);

		return curs;
	}

	public Set<Curso> getCursosPorCarrera(Carrera carrera)
	{
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Curso> cq = builder.createQuery(Curso.class);
		Root<Curso> cur = cq.from(Curso.class);
		cq.select(cur);
		// TODO: agregar metaclases!
		Join<Curso, Carrera> joCarr = cur.join("carreras");
		Integer idCarrera = carrera.getId();
		Predicate conjuncion = builder.conjunction();

		conjuncion.getExpressions().add(
				builder.equal(joCarr.get("id").as(Integer.class), idCarrera));

		cq.where(conjuncion);
		TypedQuery<Curso> q = em.createQuery(cq);

		List<Curso> cursos = (List<Curso>) q.getResultList();
		Set<Curso> curs = new HashSet<Curso>(cursos);

		return curs;
	}

	/**
	 * Al conjunto de cursos recibido como parametro, quita los cursos que dicten materias
	 * 
	 * @param cursos
	 * @return
	 */
	// Cuenta la cantidad de veces que aparece cada materia en la tabla de
	// materias_aprobadas.
	// cantAprobada = 0 no está aprobada, cantAprobada>0 esta aprobada
//	public Set<Curso> quitarMateriasAprobadas(Set<Curso> cursos)
//	{
//		int materia_id;
//		Set<Curso> cursosCopia = new HashSet<Curso>(cursos);
//		for (Curso c : cursosCopia)
//		{
//			materia_id = c.getMateria().getId();
//			String a = new String("0");
//			Query query = em.createQuery("SELECT COUNT(*) FROM MateriaAprobada WHERE materia.id = "
//					+ materia_id);
//
//			if (!query.getResultList().get(0).toString().equals(a))
//			{
//				cursos.remove(c);
//			}
//		}
//		return cursos;
//	}

}
