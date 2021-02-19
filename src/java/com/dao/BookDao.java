/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.helper.getConnection;
import com.pojo.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bhatti
 */
public class BookDao {
    public static int SaveBook(Book object)throws Exception
    {
        int i=-99;
        Connection con=getConnection.getConnectionWithDB();
        String sql="INSERT INTO `book`( `b_title`, `b_author`, `b_price`, `b_pic`) VALUES ('"+object.getBooktitle()+"','"+object.getBookauthor()+"',"+object.getBookprice()+",'"+object.getPic()+"')";
        PreparedStatement ps=con.prepareStatement(sql);
        i=ps.executeUpdate();
        return i;
    }
    public static List<Book> getAllbooks()throws Exception
    {
        List<Book> booklist=new ArrayList<>();
          Connection con=getConnection.getConnectionWithDB();
          PreparedStatement ps=con.prepareStatement("select * from book");
         ResultSet rs= ps.executeQuery();
         while(rs.next())
         {
             Book obj=new Book();
             obj.setId(rs.getInt("b_id"));
             obj.setBooktitle(rs.getString("b_title"));
             obj.setBookauthor(rs.getString("b_author"));
             obj.setBookprice(rs.getFloat("b_price"));
             obj.setPic(rs.getString("b_pic"));
             booklist.add(obj);
         }
        return booklist;
    }
    public static List<Book> getAllBooksByLimiting(int start,int length)throws Exception
    {
        List<Book> booklist=new ArrayList<>();
          Connection con=getConnection.getConnectionWithDB();
          PreparedStatement ps=con.prepareStatement("select * from book  limit "+(start-1)+","+length);
         ResultSet rs= ps.executeQuery();
         while(rs.next())
         {
             Book obj=new Book();
             obj.setId(rs.getInt("b_id"));
             obj.setBooktitle(rs.getString("b_title"));
             obj.setBookauthor(rs.getString("b_author"));
             obj.setBookprice(rs.getFloat("b_price"));
             obj.setPic(rs.getString("b_pic"));
             booklist.add(obj);
         }
        return booklist;
    }
     public static Book getbookbyid(int id)throws Exception
    {
        Book obj=new Book();
        Connection con=getConnection.getConnectionWithDB();
          PreparedStatement ps=con.prepareStatement("select * from book where b_id = "+id);
           ResultSet rs= ps.executeQuery();
           rs.next();
           obj.setId(rs.getInt("b_id"));
           obj.setBooktitle(rs.getString("b_title"));
           obj.setBookauthor(rs.getString("b_author"));
           obj.setBookprice(rs.getFloat("b_price"));
           obj.setPic(rs.getString("b_pic"));
        return obj;
    }
      public static int Delete(int id)throws Exception
    {
        int i = 0;
        Connection con=getConnection.getConnectionWithDB();
          PreparedStatement ps=con.prepareStatement("delete from `book` where b_id = "+id);
           i=ps.executeUpdate();
           return i;
    }
       public static int Update(Book obj)throws Exception
    {
        int i=999;
        String sql="UPDATE `book` SET `b_title`=?,`b_author`=?,`b_price`=?,`b_pic`=? WHERE b_id ="+obj.getId();
         Connection con=getConnection.getConnectionWithDB();
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setString(1, obj.getBooktitle());
         ps.setString(2, obj.getBookauthor());
         ps.setFloat(3, obj.getBookprice());
         ps.setString(4, obj.getPic());
         i=ps.executeUpdate();
         System.out.println(""+i);
        return i;
    }
       
}
