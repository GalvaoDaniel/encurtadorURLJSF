package com.encurtadorURLJSF.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import com.encurtadorURLJSF.model.UrlEncurtada;
import com.encurtadorURLJSF.model.Usuario;

public class UrlEncurtadaDao {
	
	private EntityManager entityManager;
	
	public UrlEncurtadaDao() {
		entityManager = Persistence.createEntityManagerFactory("encurtadorURLJSF6").createEntityManager();
	}
	
	@Transactional
	public void persist(UrlEncurtada urlEncurtada) {
		entityManager.getTransaction().begin();

		entityManager.persist(urlEncurtada);
		entityManager.getTransaction().commit();
        
        entityManager.close();
        
	}
	
	public List<UrlEncurtada> findAll() {
		List<UrlEncurtada> urlsEncurtadas = entityManager
				.createQuery("SELECT url FROM UrlEncurtada url", UrlEncurtada.class)
        		.getResultList();
        
        return urlsEncurtadas;
	}
	
	public List<UrlEncurtada> findByUsuario(Usuario usuario) {
		List<UrlEncurtada> urlsEncurtadas = entityManager
				.createQuery("SELECT url FROM UrlEncurtada url WHERE url.usuario LIKE :usuario", UrlEncurtada.class)
        		.setParameter("usuario", usuario)
        		.getResultList();
        
        return urlsEncurtadas;
	}

}
