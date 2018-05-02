package jdbc;

import models.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;

public class LivroDao {
	public LivroDao() {

	}

	public void adiciona(Livro novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.open();
		
			String sql = "insert into livro" + 
			"(titulo, autores, genero, ano, editora)" +
			"value (?,?,?,?,?)";
	
		try {
			PreparedStatement stmt = conn.prepareStatement(sql); 
			
			stmt.setInt(1, novo.getID());
			stmt.setString(2, novo.getTitulo());
			stmt.setString(3, novo.getAutores());
			stmt.setString(4, novo.getGenero());
			stmt.setInt(5, novo.getAno());
			stmt.setString(6, novo.getEditora());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


public List<Livro> getLista() throws Exception {
	List<Livro> livros = new ArrayList<Livro>();

	try {
		Conexao conx = new Conexao();
		Connection conn = conx.open();
		PreparedStatement stmt = conn.prepareStatement("select * from livro");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Contato
			Livro record = new Livro();
			record.setID(rs.getInt("ID"));
			record.setTitulo(rs.getString("titulo"));
			record.setAutores(rs.getString("autores"));
			record.setGenero(rs.getString("genero"));
			record.setAno(rs.getInt("ano"));
			record.setEditora(rs.getString("editora"));

			// adicionando o objeto à lista
			livros.add(record);
		}
		rs.close();
		stmt.close();
		conx.close(conn);
		return livros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
public List<Livro> getLista1() throws Exception {
	List<Livro> livros = new ArrayList<Livro>();

		try {
			Conexao conx = new Conexao();
			Connection conn = conx.open();
			PreparedStatement stmt = conn.prepareStatement("select * from filme where genero like ?");
			stmt.setString(1, key);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
			Livro record = new Livro();
			record.setID(rs.getInt("ID"));
			record.setTitulo(rs.getString("titulo"));
			record.setAutores(rs.getString("autores"));
			record.setGenero(rs.getString("genero"));
			record.setAno(rs.getInt("ano"));
			record.setEditora(rs.getString("editora"));

				// adicionando o objeto à lista
				livros.add(record); 
			}
		rs.close();
		stmt.close();
		conx.close(conn);
		return livros;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
}