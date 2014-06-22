package grc.dao;

import grc.dominio.Materia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
		int id = obtenerTodo().size();
		if(M.getId()<=id)
			M.setId(id+1);
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
	
	public Materia getMateria(String nombreMateria){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Materia> cq = builder.createQuery(Materia.class);
		Root<Materia> entidadMateria = cq.from(Materia.class);
		cq.select(entidadMateria);
		Predicate conjuncion = builder.conjunction();
		conjuncion.getExpressions().add(builder.equal(entidadMateria.get("nombre"), nombreMateria));

		cq.where(conjuncion);
		TypedQuery<Materia> q = em.createQuery(cq);
		return q.getSingleResult();
	}
}
