package br.com.jocaluiz.morsewaffle.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tables {
    public static Connection conn = Conn.getConnection();
    public static void createTables() {
        String query = "CREATE TABLE IF NOT EXISTS mensager ( id int(9) AUTO_INCREMENT NOT NULL PRIMARY KEY, porta varchar(255) NOT NULL, user varchar(50) NOT NULL, mensage varchar(255) NOT NULL );";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            System.out.println("Checagem de tabelas concluida!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Falha ao criar as tabelas. " + e);
        }
    }
    
}
