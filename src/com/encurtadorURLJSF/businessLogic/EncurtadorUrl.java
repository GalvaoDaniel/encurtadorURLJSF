package com.encurtadorURLJSF.businessLogic;

public class EncurtadorUrl {
	
	/***
	 * Método que recebe a URL que deverá ser encurtada e
	 * retorna a URL encurtada.
	 * 
	 * @param url
	 * @return URL encurtada
	 */
	public static String encurtarUrl(String url) {
		return "http://localhost:8080/encurtadorURLJSF6/s/" + getStringAleatoria();
	}
	
	private static String getStringAleatoria() {
		String strAelatoria = "";
		String charsPossiveis = "ABCDEFGHIJKLMNOPQRSTUVWYXZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 5; i++ ) {
			strAelatoria += charsPossiveis.charAt((int) Math.floor(Math.random() * charsPossiveis.length())); 
		}
		return strAelatoria;
	}

}
