/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfcDAO;

import dados.Bean.Dieta;
import dados.Bean.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import dataBase.DataBase;
import java.sql.Connection;



/**
 *
 * @author Balbicosta
 */
public class dietaDAO {
    
    DataBase cdb = new DataBase();
    Funcionario func = new Funcionario();
    Dieta diet = new Dieta();
    
    public void saveData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement("INSERT INTO dieta(dietRav, dietDukan, dietDash, dietLowcarb, dietCetog,"
                    + " id)VALUES(?,?,?,?,?,'"+busca+"')");
            st.setString(1, diet.getDietRav());
            st.setString(2, diet.getDietDukan());
            st.setString(3, diet.getDietDash());
            st.setString(4, diet.getDietLowcarb());
            st.setString(5, diet.getDietCetog());
            st.setInt(6, func.getId());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de cadastro." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
    
    public Dieta listData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        ResultSet rst = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement(Busca, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rst = st.executeQuery("Select * FROM dieta WHERE id = '"+busca+"'");
            while(rst.next()){
                rst.first();
                diet.setDietRav(rst.getString("dietRav"));
                diet.setDietDukan(rst.getString("dietDukan"));
                diet.setDietDash(rst.getString("dietDash"));
                diet.setDietLowcarb(rst.getString("dietLowcarb"));
                diet.setDietCetog(rst.getString("dietCetog"));
                func.setId(rst.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(dietaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cdb.shutdownConnect(on, st, rst);
        }
        return diet;
    }
        
    public void changeData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement(" UPDATE dieta SET dietRav=?, dietDukan=?, dietDash=?, dietLowcarb=?, "
                    + "dietCetog=? WHERE id='"+busca+"'");
            st.setString(1, diet.getDietRav());
            st.setString(2, diet.getDietDukan());
            st.setString(3, diet.getDietDash());
            st.setString(4, diet.getDietLowcarb());
            st.setString(5, diet.getDietCetog());
            st.setInt(6, func.getId());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Cadastro não atualizado." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }    
        
    public void eraseData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement("DELETE * FROM dieta WHERE id='"+busca+"'");
            st.setInt(1, func.getId());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro apagado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Cadastro não apagado." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
}
