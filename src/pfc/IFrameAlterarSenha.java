/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfc;

import dados.Bean.Usuario;
import javax.swing.JOptionPane;
import pfcDAO.usuarioDAO;
/**
 *
 * @author Balbicosta
 */
public class IFrameAlterarSenha extends javax.swing.JInternalFrame {
    
    //Instâncias do bean Usuário e Data Access Object usuarioDAO.
    Usuario usur = new Usuario();
    usuarioDAO uDAO = new usuarioDAO();
    /**
     * Creates new form IFrameUsuario
     */
    public IFrameAlterarSenha() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        salvar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        novaSenha = new javax.swing.JPasswordField();
        senhaAtual = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Dados Usuário");
        setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel1.setText("ID");

        jLabel2.setText("Senha ");

        jLabel3.setText("Nova Senha");

        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/accept.png"))); // NOI18N
        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel.png"))); // NOI18N
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(novaSenha)
                        .addComponent(senhaAtual)
                        .addComponent(Id)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(senhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(novaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(sair))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // Ação do botão SALVA na tela de Alteração de senha do USUÁRIO.
        String mat = Id.getText();
        int ID = Integer.valueOf(mat);
        int id = uDAO.listData(mat).getId();
        usur.setId(id);
        
        // Verificação do ID do USUÁRIO com o registrado no banco de dados.
        if (ID == id){
            String SenhaAtual = String.valueOf(senhaAtual.getPassword());
            String NovaSenha = String.valueOf(novaSenha.getPassword());
            usur.setSenha(NovaSenha);
            
            // Verificação se a NOVA SENHA é diferente da SENHA registrada no banco de dados.
            if ( !SenhaAtual.equals(NovaSenha)){
                
                // Chamada do método para alterar a senha do USUÁRIO na classe de Data Access Object usuarioDAO.
                uDAO.changeData(usur);
            }else{
                JOptionPane.showMessageDialog(null, "Login incorreto ou senhas diferentes");
            }
            Id.setText("");
            senhaAtual.setText("");
            novaSenha.setText("");
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // Ação do botão SAIR na tela de alteração de senha do USUÁRIO.:
         this.setVisible(false);
         Runtime.getRuntime().runFinalization();
    }//GEN-LAST:event_sairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField novaSenha;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    private javax.swing.JPasswordField senhaAtual;
    // End of variables declaration//GEN-END:variables
}
