package grc.dao;

import grc.modelo.Materia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class MateriaDAO {
	private static MateriaDAO instancia = null;

	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;

	public static MateriaDAO getInstancia() throws Exception {
		if (instancia == null) {
			instancia = new MateriaDAO();
		}
		em = grc.dao.EntityManagerUtil.getNewEM();
		return instancia;
	}

	public void alta(Materia M) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(M);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Materia> obtenerTodo() {
		List<Materia> a = null;
		Query query = em.createQuery("from Materia");
		a = query.getResultList();
		return a;
	}

	public Materia getMateria(int id) {
		Materia S = em.find(Materia.class, id);
		return S;
	}
}
