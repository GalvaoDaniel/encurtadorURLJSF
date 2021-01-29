package com.encurtadorURLJSF.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.encurtadorURLJSF.model.UrlEncurtada;
import com.encurtadorURLJSF.model.Usuario;

public class UrlEncurtadaDao {
	
	public void persist(UrlEncurtada urlEncurtada) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			entityManager.persist(urlEncurtada);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			
			e.printStackTrace();
			throw new RuntimeException("Erro ao persistir UrlEncurtada.");
		} finally {
			entityManager.close();
		}
        
	}
	
	public List<UrlEncurtada> findAll() {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		List<UrlEncurtada> urlsEncurtadas = entityManager
				.createQuery("SELECT url FROM UrlEncurtada url", UrlEncurtada.class)
        		.getResultList();
        
        return urlsEncurtadas;
	}
	
	public List<UrlEncurtada> findByUsuario(Usuario usuario) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		List<UrlEncurtada> urlsEncurtadas = entityManager
				.createQuery("SELECT url FROM UrlEncurtada url WHERE url.usuario LIKE :usuario", UrlEncurtada.class)
        		.setParameter("usuario", usuario)
        		.getResultList();
        
        return urlsEncurtadas;
	}

}
