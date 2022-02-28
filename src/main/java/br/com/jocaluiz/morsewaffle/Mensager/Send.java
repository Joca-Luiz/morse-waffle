package br.com.jocaluiz.morsewaffle.Mensager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.jocaluiz.morsewaffle.Connection.Conn;

public class Send {
    public static Connection conn = Conn.getConnection();
    public static void send(String port, String user, String mensage) {
        if (mensage == null) {
            return;
        }

        String query = "INSERT INTO mensager (porta, user, mensage) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, port);
            stmt.setString(2, user);
            stmt.setString(3, mensage);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Falha ao enviar a mensage!");
        }
    }
}
