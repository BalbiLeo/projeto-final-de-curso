/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfcDAO;

import dados.Bean.Funcionario;
import dados.Bean.Tratamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import dataBase.DataBase;



/**
 *
 * @author Balbicosta
 */
public class tratamentoDAO {
    
    DataBase cdb = new DataBase();
    Funcionario func = new Funcionario();
    Tratamento trato = new Tratamento();
    
    public void saveData(Tratamento trato){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("INSERT INTO tratamento(endoc, fisico, nutric, id)VALUES(?,?,?,?)");
            st.setString(1, trato.getEndoc());
            st.setString(2, trato.getFisico());
            st.setString(3, trato.getNutric());
            st.setInt(4, func.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de cadastro." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
    
    public Tratamento listData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        ResultSet rst = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement(Busca, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rst = st.executeQuery("Select * FROM tratamento WHERE id ='"+busca+"'");
            while (rst.next()){
                rst.first();
                trato.setEndoc(rst.getString("endoc"));
                trato.setFisico(rst.getString("Fisico"));
                trato.setNutric(rst.getString("Nutric"));
                trato.setId(rst.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(tratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cdb.shutdownConnect(on, st, rst);
        }
        return trato;
    }
        
    public void changeData(Tratamento trato){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement(" UPDATE tratamento SET endoc=?, fisico=?, nutric=? WHERE id=?");
            st.setString(1, trato.getEndoc());
            st.setString(2, trato.getFisico());
            st.setString(3, trato.getNutric());
            st.setInt(4, trato.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Cadastro não atualizado." + ex);
        } finally{
            cdb.shutdownConnect(on, st);
        }
    }    
        
    public void eraseData(Tratamento trato){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("DELETE * FROM tratamento WHERE id=?");
            st.setInt(1, trato.getId());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro apagado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Cadastro não apagado." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
}
