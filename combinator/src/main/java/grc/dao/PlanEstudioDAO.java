package grc.dao;

import grc.dominio.Carrera;
import grc.dominio.PlanEstudio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class PlanEstudioDAO
{
	private static PlanEstudioDAO instancia = null;

	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;

	public static PlanEstudioDAO getInstancia() throws Exception
	{
		if (instancia == null)
		{
			instancia = new PlanEstudioDAO();
		}
		em = grc.dao.EntityManagerUtil.getNewEM();
		return instancia;
	}

	public void alta(PlanEstudio PE) throws Exception
	{
		try
		{
			em.getTransaction().begin();
			em.merge(PE);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e)
		{
			em.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PlanEstudio> obtenerTodo()
	{
		List<PlanEstudio> a = null;
		Query query = em.createQuery("from PlanEstudio");
		a = query.getResultList();
		return a;
	}

	@SuppressWarnings("unchecked")
	public PlanEstudio getPlanEstudioDeCarrera(Carrera carrera)
	{
		int idC = carrera.getId();
		Query query = em.createQuery("from PlanEstudio p WHERE p.carrera.id = " + idC);
		PlanEstudio pe = ((List<PlanEstudio>) query.getResultList()).get(0);
		return pe;
	}

}
