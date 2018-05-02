package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.LivroDao;

/**
 * Servlet implementation class pesquisaLivro
 */
@WebServlet("/pesquisaLivro")
public class pesquisaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pesquisaLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pesquisa = request.getParameter("key");
		LivroDao dao = new LivroDao();
		List<Livro> result = new ArrayList<Livro>();
		try {
			result = dao.getPesquisa(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("lista_req", result);
		RequestDispatcher disp = request.getRequestDispatcher("dadosPESQ.jsp");
		disp.forward(request, response);
				
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
