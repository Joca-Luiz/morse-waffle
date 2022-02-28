package br.com.jocaluiz.morsewaffle.Mensager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextArea;

import br.com.jocaluiz.morsewaffle.Connection.Conn;

public class MorseMensager {
    public static String waffle = "Morse Waffle/MorseMensager> ", newline = "\n",  help = " If you have any questions about the waffle type the command 'help'", port, user;
    public static boolean modoDoMensager = false;
    public static int startSize;
    public static JTextArea outputArea;
    public static void mensager(String prefix, String input, JTextArea output) {
        boolean prefixCheck = input.startsWith(prefix);

        if (prefixCheck) {
            String[] valores = input.replace(prefix, "").split(" ");
            if (valores[0].length() > 0) {
                startSize = Recive.getMensages(valores[1]).size();
                port = valores[0];
                user = valores[1];
                outputArea = output;

                output.append(waffle + "Wealcome to MorseMensager, " + user + " -------------------- PORT: " + port + newline);
                Mensager.ativar(port, user, input, output);
            } else {
                output.append(waffle + "Please insert your port and your user to connect" + newline);
            }
        }    
    }

    public static void send(String mensage) {
        if (mensage.startsWith(";exit")) {
            modoDoMensager = false;

            outputArea.setText(waffle + "Saindo do Morse Mensager e limpando porta..." + newline);

            String query = "DELETE FROM mensager WHERE porta = ?";
            try {
            PreparedStatement stmt = Conn.getConnection().prepareStatement(query);
            stmt.setString(1, port);
            stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Erro ao limpar a porta e sair");
            }
        } else {
            Send.send(port, user, mensage);
        }
    }
}