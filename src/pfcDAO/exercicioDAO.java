/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfcDAO;

import dados.Bean.Exercicio;
import dados.Bean.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import dataBase.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;



/**
 *
 * @author Balbicosta
 */
public class exercicioDAO {
    
    DataBase cdb = new DataBase();
    Funcionario func = new Funcionario();
    Exercicio exerc = new Exercicio();
    
    public void saveData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement("INSERT INTO exercicio(forca, mobil, potenc, metab, exercLeve, exercMod, exercIntens,"
                    + "freqBaixa, freqMedia, freqAlta, id)VALUES(?,?,?,?,?,?,?,?,?,?,'"+busca+"')");
            st.setString(1, exerc.getForca());
            st.setString(2, exerc.getMobil());
            st.setString(3, exerc.getPotenc());
            st.setString(4, exerc.getMetab());
            st.setString(5, exerc.getExercLeve());
            st.setString(6, exerc.getExercMod());
            st.setString(7, exerc.getExercIntens());
            st.setInt(8, exerc.getFreqBaixa());
            st.setInt(9, exerc.getFreqMedia());
            st.setInt(10, exerc.getFreqAlta());
            st.setInt(11, func.getId());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de cadastro." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
    
    public Exercicio listData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        ResultSet rst = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement(Busca, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rst = st.executeQuery("Select * FROM exercicio WHERE id = '"+busca+"'");
            while(rst.next()){
                rst.first();
                exerc.setForca(rst.getString("forca"));
                exerc.setMobil(rst.getString("Mobil"));
                exerc.setPotenc(rst.getString("potenc"));
                exerc.setMetab(rst.getString("metab"));
                exerc.setExercLeve(rst.getString("exercLeve"));
                exerc.setExercMod(rst.getString("exercMod"));
                exerc.setExercIntens(rst.getString("exercIntens"));
                exerc.setFreqBaixa(rst.getInt("freqBaixa"));
                exerc.setFreqMedia(rst.getInt("freqMedia"));
                exerc.setFreqAlta(rst.getInt("freqAlta"));
                func.setId(rst.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(exercicioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cdb.shutdownConnect(on, st, rst);
        }
        return exerc;
    }
        
    public void changeData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement(" UPDATE Exercicio SET forca=?, mobil=?, potenc=?, metab=?, exercLeve=?, "
                    + "exercMod=?, exercIntens=?, freqBaixa=?, freqMedia=?, freqAlta=? WHERE id='"+busca+"'");
            st.setString(1, exerc.getForca());
            st.setString(2, exerc.getMobil());
            st.setString(3, exerc.getPotenc());
            st.setString(4, exerc.getMetab());
            st.setString(5, exerc.getExercLeve());
            st.setString(6, exerc.getExercMod());
            st.setString(7, exerc.getExercIntens());
            st.setInt(8, exerc.getFreqBaixa());
            st.setInt(9, exerc.getFreqMedia());
            st.setInt(10, exerc.getFreqAlta());
            st.setInt(11, func.getId());
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
            st = on.prepareStatement("DELETE * FROM exercicio WHERE id='"+busca+"'");
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
