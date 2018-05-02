package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.LivroDao;
import models.Livro;
	

/**
 * Servlet implementation class adicionaLivro
 */
@WebServlet("/adicionaLivro")
public class adicionaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adicionaLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		// pegando os parâmetros do request
		int ID = request.Integer.parseInt(request.getParameter("ID"));
		String titulo = request.getParameter("titulo");
		String autores = request.getParameter("autores");
		String genero = request.getParameter("genero");
		int ano = Integer.parseInt(request.getParameter("ano"));
		String editora = request.getParameter("editora");
		
		// monta um objeto filme
		Livro novo_livro = new Livro();
		novo_livro.setID(ID);
		novo_livro.setTitulo(titulo);
		novo_livro.setAutores(autores);
		novo_livro.setGenero(genero);
		novo_livro.setAno(ano);
		novo_livro.setEditora(editora);
	

		// salva o filme
		LivroDao dao = new LivroDao();
		try {
			dao.adiciona(novo_livro);
			// imprime o nome do contato que foi adicionado
			out.println("<html>");
			out.println("<body>");
			out.println("Filme: \"" + novo_livro.getTitulo() +
					"\", adicionado com sucesso!");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			out.print(e);
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
