package Gimnasio.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConextion(){
        Connection conexion = null;
        var baseDatos= "gimnasio_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "Vik147_Dua216$";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch (Exception e){
            System.out.println("Error al conectarnos a la base de Datos: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConextion();
            if (conexion != null)
                System.out.println("Conexión exitosa!!: " + conexion);
            else
                System.out.println("Error al Conmectarse...");
    }
}
