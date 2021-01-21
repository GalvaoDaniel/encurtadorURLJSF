package com.encurtadorURLJSF.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encurtadorURLJSF.model.Usuario;

@WebFilter(filterName = "LoggedInFilter", urlPatterns = "/loggedIn/*")
public class LoggedInFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servRequest, ServletResponse servResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServRequest = (HttpServletRequest) servRequest;
		HttpServletResponse httpServResponse = (HttpServletResponse) servResponse;
		HttpSession httpSession = httpServRequest.getSession();
		
		Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
		if(usuario != null) {
			filterChain.doFilter(servRequest, servResponse);
		} else {
			httpServResponse.sendRedirect(httpServRequest.getContextPath() + "/login.xhtml");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
