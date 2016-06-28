package br.com.locadora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> {

	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}
	
	public void adiciona(T t){
		EntityManager em = new JPAUtil().getEntityManager();
		//abre a transação do Hibernate	
		em.getTransaction().begin();
		//grava os dados
		em.persist(t);
		//commita a transação
		em.getTransaction().commit();
		//fecha tudo
		em.close();
	}
	
	public void remove(T t){
		EntityManager em = new JPAUtil().getEntityManager();
			//abre a transação do Hibernate	
			em.getTransaction().begin();
			//remove os dados
			em.remove(t);
			//commita a transação
			em.getTransaction().commit();
			//fecha tudo
			em.close();
	}
	
	public List<T> listaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		em.close();
		return lista;
	}

	public T buscaPorId(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();
		T instancia = em.find(classe, id);
		em.close();
		return instancia;
	}

	public int contaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();
		long result = (Long) em.createQuery("select count(n) from livro n")
				.getSingleResult();
		em.close();

		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		em.close();
		return lista;
	}
	
}
