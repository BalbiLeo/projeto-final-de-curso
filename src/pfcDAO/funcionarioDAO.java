/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfcDAO;

import dados.Bean.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dataBase.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Balbicosta
 */
public class funcionarioDAO {
    
    // Instancias da classe DataBase.
    DataBase cdb = new DataBase();
    
    // Crud - Método para SALVAR (CREATE) os dados inseridos no formulário de FUNCIONÁRIO.
    public void saveData(Funcionario func){
        PreparedStatement st = null;
        Connection on = cdb.getConnectData();
        try {
            st = on.prepareStatement("INSERT INTO funcionario(id, nome, idade, fone, sexo, cpf, endereco, funcao, email"
                    + ",dept, dataUlt, dataProx, infoAd)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, func.getId());
            st.setString(2, func.getNome());
            st.setInt(3, func.getIdade());
            st.setString(4, func.getFone());
            st.setString(5, func.getSexo());
            st.setString(6, func.getCpf());
            st.setString(7, func.getEndereco());
            st.setString(8, func.getFuncao());
            st.setString(9, func.getEmail());
            st.setString(10, func.getDept());
            st.setString(11, func.getDataUlt());
            st.setString(12, func.getDataProx());
            st.setString(13, func.getInfoAd());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de cadastro de funcionário." );
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
    
    // cRud - Método para BUSCAR (READ) os dados inseridos no formulário de FUNCIONÁRIO.
    public Funcionario listData(String busca){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        ResultSet rst = null;
        Funcionario func = new Funcionario();
        try {
            st = on.prepareStatement(busca, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rst = st.executeQuery("SELECT * FROM funcionario WHERE id = '"+busca+"'");
                if (rst.next()){
                    rst.first();
                    func.setNome(rst.getString("nome"));
                    func.setIdade(rst.getInt("idade"));
                    func.setFone(rst.getString("fone"));
                    func.setSexo(rst.getString("sexo"));
                    func.setCpf(rst.getString("cpf"));
                    func.setEndereco(rst.getString("endereco"));
                    func.setFuncao(rst.getString("funcao"));
                    func.setEmail(rst.getString("email"));
                    func.setId(rst.getInt("id"));
                    func.setDept(rst.getString("dept"));
                    func.setDataUlt(rst.getString("dataUlt"));
                    func.setDataProx(rst.getString("dataProx"));
                    func.setInfoAd(rst.getString("infoAd"));
                }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de busca de Funcionário." + ex);
        }finally{
            cdb.shutdownConnect(on, st, rst);
        }
        return func;
    }
        
    // crUd - Método para ALTERAR (UPDATE) os dados inseridos no formulário de FUNCIONÁRIO.
    public void changeData(Funcionario func){
        Connection on = cdb.getConnectData();
        PreparedStatement st=null;
        try {
            st = on.prepareStatement("UPDATE funcionario SET nome=?, idade=?, fone=?, sexo=?, cpf=?"
                    + ", endereco=?, funcao=?, email=?, dept=?, dataUlt=?, dataProx=?, infoAd=? WHERE id=?");
            st.setString(1, func.getNome());
            st.setInt(2, func.getIdade());
            st.setString(3, func.getFone());
            st.setString(4, func.getSexo());
            st.setString(5, func.getCpf());
            st.setString(6, func.getEndereco());
            st.setString(7, func.getFuncao());
            st.setString(8, func.getEmail());
            st.setString(9, func.getDept());
            st.setString(10, func.getDataUlt());
            st.setString(11, func.getDataProx());
            st.setString(12, func.getInfoAd());
            st.setInt(13, func.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Dados não atualizado." + ex);
        } finally{
            cdb.shutdownConnect(on, st);
        }
    }    
    
    // cruD - Método para EXCLUIR (DELETE) os dados inseridos no formulário de FUNCIONÁRIO.
    public void eraseData(Funcionario func){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("DELETE FROM funcionario WHERE id=?");
            st.setInt(1, func.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Funcionario não apagado." + ex);
        }finally{
            cdb.shutdownConnect(on, st);
        }
    }
}    
