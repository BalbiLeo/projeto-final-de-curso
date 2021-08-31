/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfcDAO;

import dados.Bean.Funcionario;
import dados.Bean.Usuario;
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
public class usuarioDAO {
    
    // Instancias das classes Funcionário e DataBase.
    Funcionario func = new Funcionario();
    DataBase cdb = new DataBase();
    
    // Crud - Método para SALVAR (CREATE) os dados inseridos no formulário de USUÁRIO.
    public void saveData(Usuario usuario){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement("INSERT INTO usuario(login, senha, fk_Funcionario_id)VALUES(?,?,?)");
            st.setString(1, usuario.getLogin());
            st.setString(2, usuario.getSenha());
            st.setInt(3, usuario.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de cadastro de usuário." );
        } finally{
            cdb.shutdownConnect(on, st);
        }
    }
    
    // cRud - Método para BUSCAR (READ) os dados inseridos no formulário de USUÁRIO.
    public Usuario listData(String Login){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        ResultSet rst = null;
        Usuario usuario = new Usuario();
        int login = Integer.valueOf(Login);
            try {
            st = on.prepareStatement(Login);
            rst = st.executeQuery("SELECT * FROM usuario WHERE fk_Funcionario_id = '"+login+"'");
            if (rst.next()){
                rst.first();
                usuario.setId(rst.getInt("fk_Funcionario_id"));
                usuario.setLogin(rst.getString("login"));
                usuario.setSenha(rst.getString("senha"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de busca de Usuário." + ex);
        }finally{
            cdb.shutdownConnect(on, st, rst);
        }
        return usuario;
    }
    
// crUd - Método para ALTERAR (UPDATE) os dados inseridos no formulário de USUÁRIO.    
    public void changeData(Usuario usuario){
        Connection on = cdb.getConnectData();
        PreparedStatement st = null;
        try {
            st = on.prepareStatement(" UPDATE Usuario SET senha=? WHERE fk_Funcionario_id=?");
            st.setString(1, usuario.getSenha());
            st.setInt(2, usuario.getId());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Senha não alterada." + ex);
        } finally{
            cdb.shutdownConnect(on, st);
        }
    }    
}
