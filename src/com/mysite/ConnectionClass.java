/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ashut  mysiteDB
 */
public class ConnectionClass {
    
    
    private static Connection conn;

    public static Connection getConnection(){

        try {

            if(conn==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
			System.out.println("Error. Driver class not found: " + e);
		}

                
                
                try {
                conn= DriverManager.getConnection("jdbc:mysql://jws-app-mysql:3306/db?useSSL=false&allowPublicKeyRetrieval=true","ashu","ashu14mysql");
               } catch (SQLException e) {
			System.out.println("Error. Connection problem: " + e);
			
		}
                    
                    
                    
            }
            
            
		

        } catch (Exception e) {
            e.printStackTrace();
        }


        return conn;
    }
    
}
