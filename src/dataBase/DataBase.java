/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Balbicosta
 */

public class DataBase {
    
    // Definição dos parâmetros de conexão com o banco de dados MySQL
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/db_pfc?autoReconnect=true&useSSL=false"; //?autoReconnect=true&useSSL=false
    private final String USER = "root";
    private final String PASS = "root";
    
    //Método para estabelecer a conexão com o banco de dados.
    public Connection getConnectData(){
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException(null, ex);
        }
    }
    
    // Método para encerrar conexão com o banco de dados.
    public void shutdownConnect(Connection on){
        
        try {
            if(on != null){
                on.close();
            }    
        } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    //Método para a execução das query ao banco de dados.
    public void shutdownConnect(Connection on, PreparedStatement st){
        shutdownConnect(on);
        try {
            if(st != null){
                st.close();
            }    
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro de query. Conexão finalizada" + ex);
            }
    }
    
    // Método para retornos das query feitas ao banco de dados.
    public void shutdownConnect(Connection on, PreparedStatement st, ResultSet set){
        shutdownConnect(on);
        try {
            if(set != null){
                set.close();
            }    
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Retorno de dados não realizado. Conexão finalizada" + ex);
            }
    }
}