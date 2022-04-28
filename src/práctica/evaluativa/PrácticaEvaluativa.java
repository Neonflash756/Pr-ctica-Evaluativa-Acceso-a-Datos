/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica.evaluativa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Alejandro Cobo López
 */
public class PrácticaEvaluativa {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tienda","root","");
        ResultSet rs;
        Scanner sc = new Scanner(System.in);
        
        try (Statement st = conexion.createStatement()) {
            System.out.println("INTRODUZCA NOMBRE DEL PRODUCTO: ");
            String nombreProducto = sc.nextLine();
            
            System.out.print("INTRODUZCA PRECIO DEL PRODUCTO: ");
            String p = sc.nextLine();
            double precio = Double.parseDouble(p);
                    
            System.out.print("INTRODUZCA NOMBRE DEL FABRICANTE: ");
            String nombreFabricante = sc.nextLine();
                    
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO fabricante (nombre)");
            ps.setString(1, nombreFabricante);
            ps.executeUpdate();
            ps.close();
            
            PreparedStatement PS = conexion.prepareStatement("INSERT INTO producto (nombre, precio)");
            ps.setString(1, nombreFabricante);
            ps.executeUpdate();
            ps.close();
        }
    }
    
}
