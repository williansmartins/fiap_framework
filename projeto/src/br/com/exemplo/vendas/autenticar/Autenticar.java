package br.com.exemplo.vendas.autenticar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Autenticar extends HttpServlet {

	private static final long serialVersionUID = -8861303989794457177L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		if(login.equals("admin") && senha.equals("admin")){
			String userCaptchaResponse = request.getParameter("jcaptcha");
			boolean captchaPassed = CaptchaServlet.validateResponse(request, userCaptchaResponse);
			
			if(captchaPassed){
				response.sendRedirect("gerarRelatorio.html");
			}else{
				response.getWriter().write("captcha falhou!");
				response.getWriter().write("<html><body><br/><a href='index.jsp'>Tente novamente.</a></body></html>");
			}
		}else{
			response.getWriter().write("captcha falhou!");
			response.getWriter().write("<html><body><br/><a href='index.jsp'>Tente novamente.</a></body></html>");
		}
	}
}