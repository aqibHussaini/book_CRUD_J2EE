/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Bhatti
 */
public class getConnection {
    public static Connection getConnectionWithDB()throws Exception
    {
        Connection con=null;
        
        String url="jdbc:mysql://localhost/bookms",user="root",password="";
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(url, user, password);
        return con;
    }
}
