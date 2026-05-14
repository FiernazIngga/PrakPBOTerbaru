/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public Connection connection;

    String url = "jdbc:mysql://localhost/game_pesawat";
    String user = "root";
    String pass = "";

    public Connector() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi berhasil");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
