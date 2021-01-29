package com.encurtadorURLJSF.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.encurtadorURLJSF.businessLogic.UrlEncurtadaService;
import com.encurtadorURLJSF.businessLogic.UsuarioService;
import com.encurtadorURLJSF.model.UrlEncurtada;
import com.encurtadorURLJSF.model.Usuario;

@ManagedBean(name = "loginMBean")
@SessionScoped
public class LoginMBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService = new UsuarioService();
	
	private UrlEncurtadaService urlEncurtadaService = new UrlEncurtadaService();
	
	
	private String login;
	
	private String senha;
	
	private Usuario usuarioLogado;
	
	private List<UrlEncurtada> urlsEncurtadas;
	
	public String logar() {
		if ((login == null || login.isEmpty()) || (senha == null || senha.isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Usuario e senha devem ser preenchidos."));
			return "login";
		}
		
		Usuario usuarioLogando = usuarioService.findUsuarioByLogin(login);
		
		String senhaMd5Digest = DigestUtils.md5Hex(senha);
		
		if (usuarioLogando != null && usuarioLogando.getSenha().equals(senhaMd5Digest)) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("usuario", usuarioLogando);
			usuarioLogado = usuarioLogando;
			return listagem();
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Usuario ou senha esta incorreto."));
		
		return "login";
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Logout", "Logout realizado com sucesso."));
        return "/login.xhtml?faces-redirect=true";
    }
	
	public String listagem() {
		urlsEncurtadas = urlEncurtadaService.findByUsuario(usuarioLogado);
		return "/loggedIn/listagem?faces-redirect=true";
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public List<UrlEncurtada> getUrlsEncurtadas() {
		return urlsEncurtadas;
	}

	public void setUrlsEncurtadas(List<UrlEncurtada> urlsEncurtadas) {
		this.urlsEncurtadas = urlsEncurtadas;
	}
	
	
	
	

}
