/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123200061_tugas4;

import java.sql.*;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class connector {
    String DBurl = "jdbc:mysql://localhost/tugasjdbc";
    String DBusername = "root";
    String DBpassword = "";
    
    String data[] = new String[2];
    Connection koneksi;
    Statement statement;
    static String[] username;
    
    public connector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
        }catch(Exception ex){
            System.out.println("Connection Failed " + ex.getMessage() );
        }
    }
    
    
    void masukData (String username, String password){
        try {
            if (!checkUsername(username)) {
                String query = "INSERT INTO `users` (`username`, `password`)" 
                        + "VALUES('" + username + "','" + password + "')";
                statement = koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Input Succsess!");
                JOptionPane.showMessageDialog(null, "Register Success!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Username Sudah Tersedia");
            }
        }catch (Exception ex) {
            System.out.println("Input Failed");
        }
    }
    
    
    String[] bacaData(){
        try{
            String query = "SELECT * FROM `users`";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[0] = resultSet.getString("username");
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }finally {
            return data;
        }
    }
    
    
    boolean checkUsername (String username){
        try {
            String query = "SELECT * FROM `users` WHERE username = '"+username+"'";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[0] = resultSet.getString("username");
            }
            statement.close();
            data[0].toString();
            return true;
        }catch (Exception e){
            System.out.println("Tidak Ada!");
            return false;
        }
    }
    
    
    boolean checkLogin (String username, String password){
        try {
            String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[0] = resultSet.getString("username");
                data[1] = resultSet.getString("password");
            }
            statement.close();
            System.out.println(data[1].toString());
            System.out.println(password);
            if (data[1].toString().equals(password)) {
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Tidak Ada!");
            return false;
        }
    }    
}

