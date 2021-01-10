package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    // padrão singleton - para abrir apenas uma instancia para varios usuarios
    private static ConnectionFactory connectionFactory;
    
    private ConnectionFactory(){
    
    }
    
    // conexão de padrão
    public static ConnectionFactory getConnectionFactory(){
    
        if(connectionFactory == null){
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
    
    // conexão bom o banco jdbc
    public Connection getConnection(){
    
        Connection con = null;
        
        try{
            // passando driver do banco mais a url, usuario do banco e a senha
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TesteJUnit", "postgres", "123");
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Erro na Conexão " + ex);
        }
        
        return con;
    }
    
}
