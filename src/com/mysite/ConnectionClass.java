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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import javax.sql.DataSource;




/**
 *
 * @author ashut  mysiteDB
 */
public class ConnectionClass {
    
    
    private static Connection conn;

   
	
	
	
	
	
	private static DataSource lookupDataSource() {
		try {
			Context initialContext = new InitialContext();
			try {
				return (DataSource) initialContext.lookup(System.getenv("DB_JNDI"));
			} catch (NameNotFoundException e) {
				Context envContext = (Context) initialContext.lookup("java:comp/env"); // Tomcat places datasources
																						// inside java:comp/env
				return (DataSource) envContext.lookup(System.getenv("DB_JNDI"));
			}
		} catch (NamingException e) {
			throw new RuntimeException("Could not look up datasource", e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
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
			
			
			
			DataSource dataSource = lookupDataSource();

		conn = dataSource.getConnection();
			
			
			
			//conn= DriverManager.getConnection("jdbc:mysql://jws-app-mysql:3306/db?useSSL=false&autoReconnect=true","ashu","ashu14mysql");
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
