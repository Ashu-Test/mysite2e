/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author ashut
 */
public class DataServletDAO {
    
    
    
    
    
  
public static List<RegsiterTableDAO> list() throws SQLException{
    
    List<RegsiterTableDAO> Userlists=new ArrayList<RegsiterTableDAO>();
    
    
    Connection connection=ConnectionClass.getConnection();



  ResultSet rs;

 

 

  try {

 


  //Select the data from the database

  String sql = "select * from register order by rdate DESC";

  Statement s = connection.createStatement();

  s.executeQuery (sql);

  rs = s.getResultSet();

  while (rs.next ()){
    RegsiterTableDAO user=new RegsiterTableDAO();
    user.setMYid(rs.getString(1));
     user.setName(rs.getString(2));
     user.setMobile(rs.getString(3));
     user.setEmail(rs.getString(4));
     user.setGender(rs.getString(5));
     user.setRegType(rs.getString(6));
     user.setTicket(rs.getInt(7));
     user.setRegDate(rs.getTimestamp(8));
     user.setPicName(rs.getString(9));
   
    //  get the blob
      
      
     
     try {
     Blob blob=rs.getBlob(10);
     InputStream is=blob.getBinaryStream();
     ByteArrayOutputStream os= new ByteArrayOutputStream();
     byte[] buffer=new byte[10000];
     int bytesRead=-1;
      
          while((bytesRead=is.read(buffer))!=-1){
              os.write(buffer,0,bytesRead);
         }
     
        byte[] imageBytes=os.toByteArray();
        String base64Image=Base64.getEncoder().encodeToString(imageBytes);
       //  is.close();os.close();
          
          user.setBase64Image(base64Image);
     
  } catch (IOException ex) {
        
          System.out.println("image not read");
            ex.printStackTrace();
      }   
     
      
      
      
      
      
      Userlists.add(user);
   


   
  }
  
  
  }catch(SQLException e){
      e.printStackTrace();
  }
    
 return Userlists;
}
    
    
    
    
}
