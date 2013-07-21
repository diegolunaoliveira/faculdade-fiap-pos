package br.com.fiap.javaweb.provaonline.filter;

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

import br.com.fiap.javaweb.provaonline.bean.TipoUsuario;
import br.com.fiap.javaweb.provaonline.bean.Usuario;

/**
 * Servlet Filter implementation class FiltraLogin
 */
@WebFilter(urlPatterns={"/paginas/*"})
public class FiltraLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FiltraLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest httpReq = (HttpServletRequest) request; 
		 HttpServletResponse httpRes = (HttpServletResponse) response;
		 
		 HttpSession session = httpReq.getSession();
		 Usuario user = (Usuario) session.getAttribute("userSession");
		 if(user == null){
			 httpRes.sendRedirect("../index.jsp");

		 }
		 
		 if(user != null && user.getTipoUsuario().equals(TipoUsuario.ALUNO.getDescricao())){
		    request.getRequestDispatcher("/paginas/cadastrarPerguntas.jsp").forward(request, response);

		 }
		 else if(user != null && user.getTipoUsuario().equals(TipoUsuario.ADMIN.getDescricao())){
				request.getRequestDispatcher("/paginas/prova.jsp").forward(request, response);

		 }else{
			 chain.doFilter(request, response);
		 }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
