package br.com.jocaluiz.morsewaffle.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
  public static Connection conn;
  public static Connection getConnection() {
    try {
      String driver = "com.mysql.cj.jdbc.Driver";
      Class.forName(driver);

      String host = "localhost",
      database = "morsewaffle",
      url = "jdbc:mysql://" + host + "/" + database,
      user = "root",
      password = "";

      conn = DriverManager.getConnection(url, user, password);

      if (conn == null) {
        System.out.println("Não foi possivel realizar a conexão com o banco de dados!");
      } 

      return conn;
    } catch(SQLException e) {
      System.out.println("Não foi possivel realizar a conexão com o banco de dados");
      return null;
    } catch(ClassNotFoundException e) {
      System.out.println("Driver não encontrado" + e);
      return null;
    }
  }
}
