/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfcDAO;

import dados.Bean.Anamnese;
import dados.Bean.DadoClinico;
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
public class dadoClinicoDAO {
    
    // Instancias das classes bean Funcionario, Anamnese, DadoClinico e da classe DataBase.
    DataBase cdb = new DataBase();
    Funcionario func = new Funcionario();
    DadoClinico dadocli = new DadoClinico();
    Anamnese anam = new Anamnese();
    
    // Crud - Método para SALVAR (CREATE) os dados inseridos no formulário de ANAMNESE.
    public void saveData(DadoClinico dadocli){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("INSERT INTO dado_clinico(id, dataAval, alerg, medicam, hiperten, diabete, reumat, obesid,"
                    + "epleps, lombal, probResp, probVasc, colest,  peso, altura, imc)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, dadocli.getId());
            st.setString(2, dadocli.getDataAval());
            st.setBoolean(3, dadocli.getAlerg());
            st.setBoolean(4, dadocli.getMedicam());
            st.setBoolean(5, dadocli.getHiperten());
            st.setBoolean(6, dadocli.getDiabete());
            st.setBoolean(7, dadocli.getReumat());
            st.setString(8, dadocli.getObesid());
            st.setBoolean(9, dadocli.getEpileps());
            st.setBoolean(10, dadocli.getLombal());
            st.setBoolean(11, dadocli.getProbResp());
            st.setBoolean(12, dadocli.getProbVasc());
            st.setBoolean(13, dadocli.getColest());
            st.setDouble(14, dadocli.getPeso());
            st.setDouble(15, dadocli.getAltura());
            st.setDouble(16, dadocli.getImc());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de cadastro de dados." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
    
    // cRud - Método para BUSCAR (READ) os dados inseridos no formulário de ANAMNESE.
    public DadoClinico listData(String Busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        ResultSet rst = null;
        int busca = Integer.valueOf(Busca);
        try {
            st = on.prepareStatement(Busca, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rst = st.executeQuery("SELECT * FROM dado_clinico WHERE id='"+busca+"'");
            while(rst.next()){
            rst.first();
            dadocli.setPeso(rst.getDouble("peso"));
            dadocli.setAltura(rst.getDouble("altura"));
            dadocli.setImc(rst.getDouble("imc"));
            dadocli.setDataAval(rst.getString("dataAval"));
            dadocli.setLombal(rst.getBoolean("lombal"));
            dadocli.setProbResp(rst.getBoolean("probResp"));
            dadocli.setProbVasc(rst.getBoolean("probVasc"));
            dadocli.setAlerg(rst.getBoolean("alerg"));
            dadocli.setHiperten(rst.getBoolean("hiperten"));
            dadocli.setDiabete(rst.getBoolean("diabete"));
            dadocli.setReumat(rst.getBoolean("reumat"));
            dadocli.setObesid(rst.getString("obesid"));
            dadocli.setColest(rst.getBoolean("colest"));
            dadocli.setEpileps(rst.getBoolean("epleps"));
            dadocli.setMedicam(rst.getBoolean("medicam"));
            dadocli.setId(rst.getInt("id"));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(dadoClinicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cdb.shutdownConnect(on, st, rst);
        }
        return dadocli;
    }
    
    // crUd - Método para ALTERAR (UPDATE) os dados inseridos no formulário de ANAMNESE.    
    public void changeData(DadoClinico dadocli){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement(" UPDATE dado_clinico SET dataAval=?, alerg=?, medicam=?, hiperten=?, diabete=?, reumat=?, obesid=?,"
                    + "epleps=?, lombal=?, probResp=?, probVasc=?, colest=?,  peso=?, altura=?, imc=? WHERE id=?");
            st.setString(1, dadocli.getDataAval());
            st.setBoolean(2, dadocli.getAlerg());
            st.setBoolean(3, dadocli.getMedicam());
            st.setBoolean(4, dadocli.getHiperten());
            st.setBoolean(5, dadocli.getDiabete());
            st.setBoolean(6, dadocli.getReumat());
            st.setString(7, dadocli.getObesid());
            st.setBoolean(8, dadocli.getEpileps());
            st.setBoolean(9, dadocli.getLombal());
            st.setBoolean(10, dadocli.getProbResp());
            st.setBoolean(11, dadocli.getProbVasc());
            st.setBoolean(12, dadocli.getColest());
            st.setDouble(13, dadocli.getPeso());
            st.setDouble(14, dadocli.getAltura());
            st.setDouble(15, dadocli.getImc());
            st.setInt(16, dadocli.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Dados não atualizados." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }    
        
    // cruD - Método para EXCLUIR (DELETE) os dados inseridos no formulário de ANAMNESE.
    public void eraseData(DadoClinico dadocli){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("DELETE FROM dado_clinico WHERE id=?");
            st.setInt(1, dadocli.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Dados não apagados." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
}
