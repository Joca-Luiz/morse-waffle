package br.com.jocaluiz.morsewaffle.Mensager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import br.com.jocaluiz.morsewaffle.Connection.Conn;

public class Recive  {
    public static String newline = "\n";
    public static Connection conn = Conn.getConnection();
    public static int show = MorseMensager.startSize;
    public static void recive(String port, JTextArea output) {
        while (MorseMensager.modoDoMensager) {
            if (getMensages(port).size() != show) {
                showMensagens(getMensages(port), show, output);
                MorseMensager.startSize = getMensages(port).size();
            }
        }
    }

    public static void showMensagens(ArrayList<String> 
    mensages, int start, JTextArea output) {
        for (int i = start; i < mensages.size(); i++) {
            output.append(mensages.get(i));
        }
        show = mensages.size();
    }

    public static ArrayList<String> getMensages(String port) {
        String query = "SELECT * FROM mensager WHERE porta = ?";
        ArrayList<String> mensagens = new ArrayList<String>();
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, port);
            ResultSet rs = stmt.executeQuery();
    
            while(rs.next()) {
                mensagens.add(rs.getString(3) + "> " + rs.getString(4) + newline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return mensagens;
    }
}
