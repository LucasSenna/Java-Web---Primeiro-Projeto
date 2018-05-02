package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String USUARIO = "admin";
    private static final String SENHA = "admin";
    private static final String URL = "jdbc:postgresql://localhost/acervo";
    private static final String DRIVER = "org.postgresql.Driver";

    // Conectar ao banco
    public Connection open() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;
    }

    public void close(Connection conn) throws Exception {
        conn.close();
    }

}
