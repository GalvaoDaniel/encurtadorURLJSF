package com.encurtadorURLJSF.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.encurtadorURLJSF.businessLogic.EncurtadorUrl;
import com.encurtadorURLJSF.dao.UrlEncurtadaDao;
import com.encurtadorURLJSF.model.UrlEncurtada;
import com.encurtadorURLJSF.model.Usuario;

@ManagedBean(name = "urlEncurtadaMBean")
@SessionScoped
public class UrlEncurtadaMBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private UrlEncurtada urlEncurtada = new UrlEncurtada();
	
	public void encurtarUrl() {
		
		
		if (urlEncurtada.getUrlEncurtada() != null) {
			String urlOriginal = urlEncurtada.getUrlOriginal();
			urlEncurtada = new UrlEncurtada();
			urlEncurtada.setUrlOriginal(urlOriginal);
		}
		
		urlEncurtada.setUrlEncurtada(EncurtadorUrl.encurtarUrl(urlEncurtada.getUrlOriginal()));
		urlEncurtada.setDataProcessamento(new Date());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		urlEncurtada.setUsuario(usuarioLogado);
		
		UrlEncurtadaDao urlEncurtadaDao = new UrlEncurtadaDao();
		urlEncurtadaDao.persist(urlEncurtada);
	}
	
	public String encurtador() {
		setUrlEncurtada(new UrlEncurtada());
		return "/loggedIn/encurtador?faces-redirect=true";
	}
	
	public UrlEncurtada getUrlEncurtada() {
		return urlEncurtada;
	}

	public void setUrlEncurtada(UrlEncurtada urlEncurtada) {
		this.urlEncurtada = urlEncurtada;
	}
	
	

}
