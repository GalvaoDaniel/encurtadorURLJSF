package com.encurtadorURLJSF.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import com.encurtadorURLJSF.model.Usuario;


public class UsuarioDao {
	
	private EntityManager entityManager;
	
	public UsuarioDao() {
		entityManager = Persistence.createEntityManagerFactory("encurtadorURLJSF6").createEntityManager();
	}
	
	@SuppressWarnings("finally")
	public Usuario findUsuarioByLogin(String login) {
		Usuario usuario = null;
		try {
			usuario = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.login LIKE :login", Usuario.class)
					.setParameter("login", login)
					.getSingleResult();
			
		} catch (NoResultException e) {
			usuario = null;
		}finally {
			return usuario;
		}
	}

}
