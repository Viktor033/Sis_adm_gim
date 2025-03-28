package Gimnasio.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion(){ // Nombre corregido
        Connection conexion = null;
        var baseDatos= "gimnasio_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "Vik147_Dua216$";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.out.println("❌ Error al conectarnos a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if (conexion != null)
            System.out.println("✅ Conexión exitosa!!: " + conexion);
        else
            System.out.println("❌ Error al conectarse...");
    }
}
