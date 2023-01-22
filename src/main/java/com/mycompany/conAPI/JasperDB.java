/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conAPI;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AJM
 */
public class JasperDB {
    
    private Connection conn;
    
    public JasperDB(){     
        newConn();
    }
    
    public Connection newConn(){
        try{
            Connection connection = DriverManager.getConnection(
            "jdbc:mariadb://localhost:43306/AparthotelDB",
            "admin", "s3rv3r"      
            );
            conn = connection;
            System.out.println( "Conexion con la base de datos correcta: "+ connection.isValid(5));
        }catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Fallo al conectar con la BBDD");
        }
        return conn;
    }
    
    public void close(){
        if(conn != null){
        try{
        conn.close();
        }catch(Exception e){
             System.out.println("Fallo al liberar la conexion con la BBDD");
        }
        }
    }
    
    public Connection GetConnection(){
        return conn;
    }
}
