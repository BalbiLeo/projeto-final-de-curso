/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfcDAO;

import dados.Bean.Anamnese;
import dados.Bean.DadoRisco;
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
public class dadoRiscoDAO {
    
    // Instancias das classes bean Funcionario, Anamnese, DadoRisco e da classe DataBase.
    DataBase cdb = new DataBase();
    Anamnese anam = new Anamnese();
    DadoRisco dadoris = new DadoRisco();
    Funcionario func = new Funcionario();
    
    // Crud - Método para SALVAR (CREATE) os dados inseridos no formulário de ANAMNESE.
    public void saveData(DadoRisco dadoris){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("INSERT INTO dado_risco(fumo, alcool, convul, derrame, infarto, isquem, "
                    + "arritm, id)VALUES(?,?,?,?,?,?,?,?)");
            st.setBoolean(1, dadoris.getFumo());
            st.setBoolean(2, dadoris.getAlcool());
            st.setBoolean(3, dadoris.getConvul());
            st.setBoolean(4, dadoris.getDerrame());
            st.setBoolean(5, dadoris.getInfarto());
            st.setBoolean(6, dadoris.getIsquem());
            st.setBoolean(7, dadoris.getArritm());
            st.setInt(8, dadoris.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de cadastro de dados." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
    
    // cRud - Método para BUSCAR (READ) os dados inseridos no formulário de ANAMNESE.
    public DadoRisco listData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        ResultSet rst = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement(Busca, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rst = st.executeQuery("Select * FROM dado_risco WHERE id = '"+busca+"'");
            while (rst.next()){
                rst.first();
                dadoris.setFumo(rst.getBoolean("fumo"));
                dadoris.setAlcool(rst.getBoolean("alcool"));
                dadoris.setConvul(rst.getBoolean("convul"));
                dadoris.setDerrame(rst.getBoolean("derrame"));
                dadoris.setInfarto(rst.getBoolean("infarto"));
                dadoris.setIsquem(rst.getBoolean("isquem"));
                dadoris.setArritm(rst.getBoolean("arritm"));
                dadoris.setId(rst.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(dadoRiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cdb.shutdownConnect(on, st, rst);
        }
        return dadoris;
    }
    
    // crUd - Método para ALTERAR (UPDATE) os dados inseridos no formulário de ANAMNESE. 
    public void changeData(DadoRisco dadoris){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement(" UPDATE dado_risco SET fumo=?, alcool=?, convul=?, derrame=?, infarto=?, isquem=?, "
                    + "arritm=? WHERE id =?");
            st.setBoolean(1, dadoris.getFumo());
            st.setBoolean(2, dadoris.getAlcool());
            st.setBoolean(3, dadoris.getConvul());
            st.setBoolean(4, dadoris.getDerrame());
            st.setBoolean(5, dadoris.getInfarto());
            st.setBoolean(6, dadoris.getIsquem());
            st.setBoolean(7, dadoris.getArritm());
            st.setInt(8, dadoris.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Dados não atualizado." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }    
    
    // cruD - Método para EXCLUIR (DELETE) os dados inseridos no formulário de ANAMNESE.    
    public void eraseData(DadoRisco dadoris){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("DELETE FROM dado_risco WHERE id=?");
            st.setInt(1, dadoris.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Dados não apagados." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
}
