/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfcDAO;

import dados.Bean.Anamnese;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dataBase.DataBase;
import dados.Bean.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;



/**
 *
 * @author Balbicosta
 */
public class anamneseDAO {
    
    // Instancias das classes bean Funcionario, Anamnese e da classe DataBase.
    DataBase cdb = new DataBase();
    Funcionario func = new Funcionario();
    Anamnese anam = new Anamnese();
    
    // Crud - Método para SALVAR (CREATE) os dados inseridos no formulário de ANAMNESE.
    public void saveData(Anamnese anam){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("INSERT INTO anamnese(admis, demis, perid, apto, inapto, id)VALUES(?,?,?,?,?,?)");
            st.setBoolean(1, anam.isAdmis());
            st.setBoolean(2, anam.isDemis());
            st.setBoolean(3, anam.isPerid());
            st.setBoolean(4, anam.isApto());
            st.setBoolean(5, anam.isInapto());
            st.setInt(6, anam.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de dados." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
    
    // cRud - Método para BUSCAR (READ) os dados inseridos no formulário de ANAMNESE.
    public Anamnese listData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        ResultSet rst = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement(Busca, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.FETCH_REVERSE);
            rst = st.executeQuery("SELECT * FROM anamnese WHERE id = '"+busca+"'");
            while(rst.next()){
                rst.first();
                anam.setAdmis(rst.getBoolean("admis"));
                anam.setDemis(rst.getBoolean("demis"));
                anam.setPerid(rst.getBoolean("perid"));
                anam.setApto(rst.getBoolean("apto"));
                anam.setInapto(rst.getBoolean("inapto"));
                anam.setId(rst.getInt("id"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de busca de anamnese do Funcionário." + ex);
        } finally{
            cdb.shutdownConnect(on, st, rst);
        }
        return anam;
    }
    
    // crUd - Método para ALTERAR (UPDATE) os dados inseridos no formulário de ANAMNESE.
    public void changeData(Anamnese anam){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("UPDATE anamnese SET admis=?, demis=?, perid=?, apto=?, inapto=? WHERE id=?");
            st.setBoolean(1, anam.isAdmis());
            st.setBoolean(2, anam.isDemis());
            st.setBoolean(3, anam.isPerid());
            st.setBoolean(4, anam.isApto());
            st.setBoolean(5, anam.isInapto());
            st.setInt(6, anam.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Dados não atualizados." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }    
    
    // cruD - Método para EXCLUIR (DELETE) os dados inseridos no formulário de ANAMNESE.
    public void eraseData(Anamnese anam){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("DELETE FROM anamnese WHERE id=?");
            st.setInt(1, anam.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Anamnese não apagada." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
}
