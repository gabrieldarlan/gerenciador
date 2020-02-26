package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final String SEPARADOR = ":";
	private static final String ACAO = "acao";
	private static final String PACOTE_ACAO = "br.com.alura.gerenciador.acao.";
	private static final String FORWARD = "forward";
	private static final String WEB_INF_VIEW = "WEB-INF/view/";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter(ACAO);

//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = sessao.getAttribute(USUARIO_LOGADO) == null;
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals(LOGIN) || paramAcao.equals(LOGIN_FORM));
//
//		if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}

		String nomeDaClasse = PACOTE_ACAO + paramAcao;
		String nome;

		try {
			Class<?> classe = Class.forName(nomeDaClasse); // carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = nome.split(SEPARADOR);

		if (tipoEEndereco[0].equals(FORWARD)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(WEB_INF_VIEW + tipoEEndereco[1]);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
	}
}
