<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
	<%@ page import="models.Livro"%>
	<%@ page import="java.util.List"%>

	<%
		LivroDao dao = new LivroDao();
		List<Livro> filmes = dao.getLista();
	%>
	<table style="border:2px solid black; border-collapse: collapse; ">
		<thead>
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>Autores</th>
				<th>Genero</th>
				<th>Ano</th>
				<th>Editora</th>
			</tr>
		</thead>

		<tbody style="border:1px solid black;">
		<%
			for (Livro livro : livro) {
				%>
			<tr>
				<td><%=livro.getID()%></td>
				<td><%=livro.getTitulo()%></td>
				<td><%=livro.getAutores()%></td>
				<td><%=livro.getGenero()%></td>
				<td><%=livro.getAno()%></td>
				<td><%=livro.getEditora()%></td>
			</tr>
	<%
		}
	%>

		</tbody>




	</table>

</body>
</html>