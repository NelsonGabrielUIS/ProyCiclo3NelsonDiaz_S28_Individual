/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dto.InfoDTO;
import persistence.MySQLConnect;

/**
 *
 * @author ingdeiver
 */
public class InfoDAOImpl {
    
    private MySQLConnect mySQLConnect = null;
    private PreparedStatement prepareStatement = null;
    private ResultSet resultSet = null;
    

    private  void openConnection (){
        this.mySQLConnect = new MySQLConnect();
    }
    
    private void closeConnection() {
        this.mySQLConnect.closeConecction();      
    }
    
  
    public List<InfoDTO> list() {
        String statement = "SELECT * FROM " + InfoDTO.TABLE_NAME + " ;" ;
        List<InfoDTO> lista = new ArrayList<>();
        
        try {
            
            // se abre una nueva conexión
            this.openConnection();
            
            // se crea el statement
            this.prepareStatement = this.mySQLConnect.getConnection().prepareStatement(statement);
 
             // se obtienen los datos
            this.resultSet = this.prepareStatement.executeQuery();
            
            
                
            while (this.resultSet.next()){
                lista.add(new InfoDTO(this.resultSet.getNString("info"), this.resultSet.getInt("id")));
            };
            
        } catch (SQLException ex) {
            Logger.getLogger(InfoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            this.closeConnection();
            return null;
        }
        
        this.closeConnection();
        return lista;
    }

  
    public InfoDTO getById(Integer id) {
            String statement = "SELECT * FROM " + InfoDTO.TABLE_NAME + " WHERE id = :id;" ;
            InfoDTO info = null;
            
        try {
            // se abre una nueva conexión
            this.openConnection();
            
            // se crea el statement
            this.prepareStatement = this.mySQLConnect.getConnection().prepareStatement(statement);
            this.prepareStatement.setInt(1, id);
            
            // se obtienen los datos
            this.resultSet = this.prepareStatement.executeQuery();
            
            if(this.resultSet.next()){
                info = new InfoDTO(this.resultSet.getNString("info"), this.resultSet.getInt("id"));
            }
            
            // se cierra la conexión
            this.closeConnection();
            
        } catch (SQLException ex) {
            Logger.getLogger(InfoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            this.closeConnection();
            return null;
        }
        
        this.closeConnection();
        return info;
    }

    
    public void remove(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean save(InfoDTO entity) {
        String statement = "INSERT INTO " + InfoDTO.TABLE_NAME + "(info)" + " VALUES(?);";
        boolean succes = true;
        
        try {
            // se abre una nueva conexión
            this.openConnection();
            // crea y ejecuta el statement
            this.prepareStatement = this.mySQLConnect.getConnection().prepareStatement(statement);
            this.prepareStatement.setString(1, entity.getInfo());
            this.prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            Logger.getLogger(InfoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            succes = false;
            return succes;
        }
        
        this.closeConnection();
        return succes;
    }

   
    public InfoDTO update(InfoDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
