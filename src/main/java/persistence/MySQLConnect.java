/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ingdeiver
 */
public class MySQLConnect {
    private Connection connection = null;
    
    // database credentials
    private String user = "root";
    private String passsword = "root";
    private String host = "localhost";
    private String port = "3306";
    private String database = "tutorias";
    private String uri = "jdbc:mysql://"+host+":"+port+"/"+database;
    private String driver = "com.mysql.cj.jdbc.Driver";
    
    
    public MySQLConnect(){
        try {
            Class.forName(this.driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            this.connection = DriverManager.getConnection(this.uri, this.user, this.passsword);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
    
    
    public void closeConecction() {
        if(this.connection != null){
            try {
                this.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        MySQLConnect con = new MySQLConnect();
    }
}
