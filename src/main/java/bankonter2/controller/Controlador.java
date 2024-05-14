package bankonter2.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import bankonter2.model.Entidad;



public class Controlador {

	private static EntityManagerFactory entityManagerFactory;

	private String nombreEntidadControlada = "";
	private Class entidadControlada = null;


	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public Controlador(Class entidadControlada, String unidadPersistencia) {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
		}
		this.entidadControlada = entidadControlada;
		this.nombreEntidadControlada = this.entidadControlada.getName();
	}

	/**
	 * 
	 * @return
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	/**
	 * Ecuentras por id
	 * @param id
	 * @return
	 */
	public Entidad find(int id) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Entidad entidad = (Entidad) em.find(this.entidadControlada, id);
			em.close();
			return entidad;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * borras todos los registros
	 */
	public void deleteAll() {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.createQuery("DELETE FROM " + this.nombreEntidadControlada + " o").executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * insertar nuevo
	 */
	public void persist(Entidad e) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * actualizar
	 */
	public void merge(Entidad e) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * de aquí llamo o a merge(actualizar) o a persist(insertar)
	 * Es el mismo metodo que hay en guardar, pero directamente aquí 
	 * @param e
	 */
	public void save(Entidad e) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		if (e.getId() != -1) {
			merge(e);
		}
		else {
			persist(e);
		}
	}
	
	/**
	 * 
	 */
	public void remove(Entidad e) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Entidad actual = null;
		em.getTransaction().begin();
		if (!em.contains(e)) {
			actual = em.merge(e);
		}
		em.remove(actual);
		em.getTransaction().commit();
		em.close();
	}

	
	/**
	 * 
	 * @return
	 */
	public Entidad findFirst () {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT e FROM " + this.nombreEntidadControlada + " e order by e.id", Entidad.class);
			Entidad resultado = (Entidad) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Entidad findLast () {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT e FROM " + this.nombreEntidadControlada + " e order by e.id desc", Entidad.class);
			Entidad resultado = (Entidad) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Entidad findNext (Entidad e) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT e FROM " + this.nombreEntidadControlada + " e where e.id > :idActual order by e.id", Entidad.class);
			q.setParameter("idActual", e.getId());
			Entidad resultado = (Entidad) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	
	
	
	/**
	 * 
	 * @return
	 */
	public Entidad findPrevious (Entidad e) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT e FROM " + this.nombreEntidadControlada + " e where e.id < :idActual order by e.id desc", Entidad.class);
			q.setParameter("idActual", e.getId());
			Entidad resultado = (Entidad) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}
	
//	
//	public Entidad findPrevious(int idActual ) {
//		
//		try {
//			return (Entidad) getEntityManager().
//					createNativeQuery("select * from " + this.nombreEntidadControlada + " where id > " + idActual
//							+ " order by id", this.tipoEntidad)
//					.setMaxResults(1).getSingleResult();
//		}
//	}
//	
	
	
	
	
	
	
	/**
	 * 
	 */
	public List<? extends Entidad> findAll () {
		EntityManager em = getEntityManagerFactory().createEntityManager();

		TypedQuery<Entidad> q = em.createQuery("SELECT e FROM " + this.nombreEntidadControlada + " e", this.entidadControlada);

		List<Entidad> entidades = (List<Entidad>) q.getResultList();

		em.close();
		return entidades;
	}
	
	
}
