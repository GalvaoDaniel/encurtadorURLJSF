package com.encurtadorURLJSF.businessLogic;


import com.encurtadorURLJSF.dao.UsuarioDao;
import com.encurtadorURLJSF.model.Usuario;

public class UsuarioService {

	private UsuarioDao usuarioDao = new UsuarioDao();
	
	public Usuario findUsuarioByLogin(String login) {
		return usuarioDao.findUsuarioByLogin(login);
	}
	
}
