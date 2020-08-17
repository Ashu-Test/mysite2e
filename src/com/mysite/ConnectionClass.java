/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.cj.jdbc.MysqlDataSource;
//import com.mysql.jdbc.jdbc2.optional.*;
/**
 *
 * @author ashut  mysiteDB
 */
public class ConnectionClass {
    
    
    private static Connection conn;

    public static Connection getMyConnection(){

        try {

            if(conn==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
			System.out.println("Error. Driver class not found: " + e);
		}

                
                                                              //jws-app-mysql
                try {
               
	/*               MysqlConnectionPoolDataSource ds=new MysqlConnectionPoolDataSource();
			ds.setURL("jdbc:mysql://jws-app-mysql:3306/db?useSSL=false&autoReconnect=true");
			
			ds.setUser("ashu");
			ds.setPassword("ashu14mysql");
			
			conn=ds.getConnection();
			
			  */
			
			
			conn= DriverManager.getConnection("jdbc:mysql://jws-app-mysql:3306/db?useSSL=false&autoReconnect=true","ashu","ashu14mysql");
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
