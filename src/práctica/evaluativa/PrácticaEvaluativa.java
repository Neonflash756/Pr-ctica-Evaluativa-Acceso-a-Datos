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
        System.out.print("QUIERE ADICIONAR NUEVOS DATOS A LA BASO DE DATOS? \n"
                + "SI=1 " + "NO=2");
        String respuesta = sc.nextLine();
        int numero = Integer.parseInt(respuesta);
        
        while(numero == 1){
            try (Statement st = conexion.createStatement()) { 
                
                System.out.print("QUIERE INSERTAR UN FABRICANTE? \n"
                + "SI = 1 " + "NO = 2" );
                String r1 = sc.nextLine();
                int n1 = Integer.parseInt(respuesta);
                
                if(n1 ==1){
                    System.out.print("INTRODUZCA NOMBRE DEL FABRICANTE: ");
                    String nombreFabricante = sc.nextLine();

                    PreparedStatement ps = conexion.prepareStatement("INSERT INTO fabricante (nombre) values(?)");
                    ps.setString(1, nombreFabricante);
                    ps.executeUpdate();
                    ps.close();
                }
                
                System.out.print("QUIERE INSERTAR UN PRODUCTO? \n"
                + "SI = 1 " + "NO = 2" );
                String r2 = sc.nextLine();
                int n2 = Integer.parseInt(respuesta);
                if(n2 ==1){
                    System.out.println("INTRODUZCA NOMBRE DEL PRODUCTO: ");
                    String nombreProducto = sc.nextLine();

                    System.out.print("INTRODUZCA PRECIO DEL PRODUCTO: ");
                    String precio = sc.nextLine(); 

                    String codigoFabricante = "SELECT `codigo` FROM `fabricante` WHERE nombre LIKE 'nombreFabricante'";

                    PreparedStatement PS = conexion.prepareStatement("INSERT INTO producto (nombre, precio ,codigo_fabricante) values(?,?,?)");
                    PS.setString(1, nombreProducto);
                    PS.setString(2, precio);
                    PS.setString(3, codigoFabricante);
                    PS.executeUpdate();
                    PS.close(); 
                }
            }
            
            System.out.print("QUIERE ADICIONAR NUEVOS DATOS A LA BASO DE DATOS? \n"
                + "SI=1 " + "NO=2");
            respuesta = sc.nextLine();
            numero = Integer.parseInt(respuesta);
        }
        
        System.out.print("PROGRAMA FINALIZADO \n");
    }
    
}
