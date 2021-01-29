package com.encurtadorURLJSF.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.encurtadorURLJSF.model.Usuario;

public class UsuarioDao {
	
	@SuppressWarnings("finally")
	public Usuario findUsuarioByLogin(String login) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
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
