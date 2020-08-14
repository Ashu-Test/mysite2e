/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.*;

import java.sql.*;

import javax.servlet.*;

import javax.servlet.http.*;


/**
 *
 * @author ashut
 */
public class DataServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//          response.setContentType("text/html");
       
            
            
            
  /*          
            
            
            
            
            
    Connection connection=ConnectionClass.getConnection();



  ResultSet rs;

  response.setContentType("text/html");

  List dataList = new ArrayList();

  try {

 


  //Select the data from the database

  String sql = "select * from register";

  Statement s = connection.createStatement();

  s.executeQuery (sql);

  rs = s.getResultSet();

  while (rs.next ()){

  //Add records into data list

      dataList.add(rs.getString(1));//id

      dataList.add(rs.getString(2));//name
   
      dataList.add(rs.getString(3));//mobile
     
      dataList.add(rs.getString(4));//email
     
      dataList.add(rs.getString(5));//gender
   
      dataList.add(rs.getString(6)); //reg type

      dataList.add(rs.getInt(7)); //tickets num
     
      dataList.add(rs.getTimestamp(8)); //reg date
    
      dataList.add(rs.getString(9)); //picName

  }

  rs.close ();

  s.close ();

  }catch(SQLException e){

  System.out.println("Exception is ;"+e);

  }

  request.setAttribute("data",dataList);

  //Disptching request

  RequestDispatcher dispatcher = request.getRequestDispatcher("AllPages/AdminDashboard/Dashboard.jsp");

  if (dispatcher != null){

  dispatcher.forward(request, response);

  } 

  */
  
  
  
//public List<RegsiterTableDAO> list() throws SQLException{
    
//    List<RegsiterTableDAO> Userlists=new ArrayList<RegsiterTableDAO>();
//    
//    
//    Connection connection=ConnectionClass.getConnection();
//
//
//
//  ResultSet rs;

 

// 
//
//  try {
//
// 
//
//
//  //Select the data from the database
//
//  String sql = "select * from register";
//
//  Statement s = connection.createStatement();
//
//  s.executeQuery (sql);
//
//  rs = s.getResultSet();
//
//  while (rs.next ()){
//    RegsiterTableDAO user=new RegsiterTableDAO();
//    user.setMYid(rs.getString(1));
//     user.setName(rs.getString(2));
//     user.setMobile(rs.getString(3));
//     user.setEmail(rs.getString(4));
//     user.setGender(rs.getString(5));
//     user.setRegType(rs.getString(6));
//     user.setTicketNo(rs.getInt(7));
//     user.setRegDate(rs.getTimestamp(8));
//     user.setPicName(rs.getString(9));
//    Userlists.add(user);
//    HttpSession ss= request.getSession();
//    ss.setAttribute("userLists",Userlists );
//     RequestDispatcher dispatcher = request.getRequestDispatcher("AllPages/AdminDashboard/Dashboard.jsp");
//
//  if (dispatcher != null){
//
//  
//      dispatcher.forward(request, response);
//
//  } 
//  }
//  
//  
//  }catch(SQLException e){
//      e.printStackTrace();
//  }
//    
//    
////}
//
//            
//         
//            
            
            
            
            
            try {
                 
                List<RegsiterTableDAO> userL =DataServletDAO.list();
                request.setAttribute("userLists",userL );
                 RequestDispatcher dispatcher = request.getRequestDispatcher("AllPages/AdminDashboard/Dashboard.jsp");

  if (dispatcher != null){

  
      dispatcher.forward(request, response);

  } 
                
                
                
            } catch (IOException | SQLException | ServletException e) {
                e.printStackTrace();
            }
   
            
            
            
            
            
            
            
            
            
            
            
            
//            out.println("<h1>Servlet DataServlet at " + request.getContextPath() + "</h1>");
             
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
