<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="jdbc.LivroDao"%>

	<form action="pesquisaLivro">
		Chave de pesquisa: input type="text" name="key" />
		<button type="submit" value="Submit">Search</button>
	</form>
	<%
		List<Livro> livros = (List) request.getAtribute("lista_req");
		for (Livro livro: livros){
	%>		
	<li> <%livro.getTitulo()%> </li>	
		<%}%>
</body>
</html>