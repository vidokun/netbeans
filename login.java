/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package javaapplication13;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 * 
 * @author vidokun
 */
public class home extends javax.swing.JFrame {
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    /**
     * Creates new form NewJFrame
     */
    public home() {
        initComponents();
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
    }

        /**
     * BUtton login
     */
    
    
    
            try {
            sql = "SELECT * FROM login WHERE username='"+jTextField1.getText()+"' AND password='"+jTextField2.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(jTextField1.getText().equals(rs.getString("username")) && jTextField2.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "berhasil login");
                    System.out.println("berhasil login");
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                    System.out.println("username atau password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
