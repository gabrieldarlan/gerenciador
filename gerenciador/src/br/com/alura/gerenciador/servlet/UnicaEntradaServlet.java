package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
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
		String nomeDaClasse = PACOTE_ACAO + paramAcao;
		String nome = null;
		try {
			Class<?> classe = Class.forName(nomeDaClasse); // carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = nome.split(":");

		if (tipoEEndereco[0].equals(FORWARD)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(WEB_INF_VIEW + tipoEEndereco[1]);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
//		if (paramAcao.equals(LISTA_EMPRESAS)) {
//			System.out.println("listando");
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals(REMOVE_EMPRESA)) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals(MOSTRA_EMPRESA)) {
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals(ALTERA_EMPRESA)) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals(NOVA_EMPRESA)) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals(NOVA_EMPRESA_FORM)) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}

	}

}
