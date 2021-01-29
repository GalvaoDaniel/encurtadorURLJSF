package com.encurtadorURLJSF.businessLogic;

import java.util.List;

import com.encurtadorURLJSF.dao.UrlEncurtadaDao;
import com.encurtadorURLJSF.model.UrlEncurtada;
import com.encurtadorURLJSF.model.Usuario;

public class UrlEncurtadaService {
	
	private UrlEncurtadaDao urlEncurtadaDao = new UrlEncurtadaDao();
	
	
	public void persist(UrlEncurtada urlEncurtada) {
		urlEncurtadaDao.persist(urlEncurtada);
	}
	
	public List<UrlEncurtada> findAll() {
		return urlEncurtadaDao.findAll();
	}
	
	public List<UrlEncurtada> findByUsuario(Usuario usuario) {
		return urlEncurtadaDao.findByUsuario(usuario);
	}

}
