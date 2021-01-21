package com.encurtadorURLJSF.webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encurtadorURLJSF.dao.UrlEncurtadaDao;
import com.encurtadorURLJSF.model.UrlEncurtada;

@WebServlet(urlPatterns = "/s/*")
public class EncurtadorUrlWebService extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UrlEncurtadaDao urlEncurtadaDao = new UrlEncurtadaDao();
		
		List<UrlEncurtada> urlsEncurtadas = urlEncurtadaDao.findAll();
		
		String requestUrl = req.getRequestURL().toString();
		
		UrlEncurtada ulrEncurtadaEncontrada = urlsEncurtadas.stream().
				filter( url -> url.getUrlEncurtada().equals(requestUrl)).
				findFirst().orElse(null);
		
		if (ulrEncurtadaEncontrada != null) {
			String urlToRedirect = ulrEncurtadaEncontrada.getUrlOriginal();
			resp.sendRedirect(urlToRedirect);
		} else {
			resp.sendRedirect("login");
		}
	}
	
}
