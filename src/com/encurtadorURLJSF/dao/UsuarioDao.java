package com.encurtadorURLJSF.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.encurtadorURLJSF.model.Usuario;


public class UsuarioDao {
	
	private EntityManager entityManager;
	
	public UsuarioDao() {
		entityManager = Persistence.createEntityManagerFactory("encurtadorURLJSF6").createEntityManager();
	}
	
	public Usuario findUsuarioByLogin(String login) {
        Usuario usuario = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.login LIKE :login", Usuario.class)
        		.setParameter("login", login)
        		.getSingleResult();
        
        return usuario;
	}

}
