package br.com.jocaluiz.morsewaffle.Mensager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import br.com.jocaluiz.morsewaffle.Connection.Conn;

public class Mensager {
    public static String newline = "\n";
    public static Connection conn = Conn.getConnection();
    public static void ativar(String port, String user, String input, JTextArea output) {
        mensagensPassadas(output, port);

        if (MorseMensager.modoDoMensager) {
            MorseMensager.modoDoMensager = false;
        } else {
            MorseMensager.modoDoMensager = true;
            new Thread() {
                @Override
                public void run() {
                    Recive.recive(port, output);
                }
            }.start();
        }
    }

    public static ArrayList<String> mensagensPassadas(JTextArea output, String port) {
        String query = "SELECT * FROM mensager WHERE porta = ?";
        ArrayList<String> mensagensPassadas = new ArrayList<String>();
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, port);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                output.append(rs.getString(3) + "> " + rs.getString(4) + newline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mensagensPassadas;
    }
}
