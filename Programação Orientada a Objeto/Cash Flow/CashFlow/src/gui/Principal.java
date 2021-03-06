/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Natanael
 */
public class Principal extends javax.swing.JFrame {

    
    /**
     * Creates new form TelaPrincipal
     */
    public Principal() {
        //this.gerenteDeJanelas = new GerenteDeJanelas(jDesktopPane1);
        initComponents();
        this.setLocationRelativeTo(null);
        jlabelUserName.setText("Olá" + "sql para pegar nome do usuário");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jDiasCalendario = new com.toedter.calendar.JDayChooser();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jlabelUserName = new javax.swing.JLabel();
        bt_Visualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextDate = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuTitulo = new javax.swing.JMenu();
        bt_Recebimento = new javax.swing.JMenuItem();
        bt_Despesas = new javax.swing.JMenuItem();
        jMenuPessoa = new javax.swing.JMenu();
        bt_CadastrarPessoa = new javax.swing.JMenuItem();
        bt_atualizarPessoa = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuAdicionarUsuario = new javax.swing.JMenuItem();
        jMenuExcluirUsuario = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuConfigurações = new javax.swing.JMenu();
        jMenuItemModificarUsuario = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(231, 223, 204));

        jDiasCalendario.setDecorationBackgroundColor(new java.awt.Color(4, 161, 36));
        jDiasCalendario.setSundayForeground(new java.awt.Color(6, 12, 71));
        jDiasCalendario.setWeekdayForeground(new java.awt.Color(255, 255, 255));
        jDiasCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDiasCalendarioMouseClicked(evt);
            }
        });

        jTextField2.setEditable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/boy_1.png"))); // NOI18N

        jlabelUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlabelUserName.setForeground(new java.awt.Color(4, 151, 34));

        bt_Visualizar.setText("Visualizar");
        bt_Visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_VisualizarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextDate);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlabelUserName))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDiasCalendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(bt_Visualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jlabelUserName))
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDiasCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_Visualizar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bg_principal.jpg"))); // NOI18N

        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 851, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 588, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenuTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/títulos.png"))); // NOI18N
        jMenuTitulo.setText("Titulo");

        bt_Recebimento.setText("Cadastrar Recebimentos");
        bt_Recebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RecebimentoActionPerformed(evt);
            }
        });
        jMenuTitulo.add(bt_Recebimento);

        bt_Despesas.setText("Cadastrar Despesas");
        bt_Despesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DespesasActionPerformed(evt);
            }
        });
        jMenuTitulo.add(bt_Despesas);

        jMenuBar1.add(jMenuTitulo);

        jMenuPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/User-green256_25015.png"))); // NOI18N
        jMenuPessoa.setText("Pessoa");

        bt_CadastrarPessoa.setText("Cadastrar Pessoa");
        bt_CadastrarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CadastrarPessoaActionPerformed(evt);
            }
        });
        jMenuPessoa.add(bt_CadastrarPessoa);

        bt_atualizarPessoa.setText("Listar/Editar Pessoas Cadastradas");
        bt_atualizarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atualizarPessoaActionPerformed(evt);
            }
        });
        jMenuPessoa.add(bt_atualizarPessoa);

        jMenuBar1.add(jMenuPessoa);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/User-green256_25015.png"))); // NOI18N
        jMenu1.setText("Usuários");

        jMenuAdicionarUsuario.setText("Adicionar Usuário");
        jMenuAdicionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAdicionarUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuAdicionarUsuario);

        jMenuExcluirUsuario.setText("Excluir Usuário");
        jMenuExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExcluirUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuExcluirUsuario);

        jMenuBar1.add(jMenu1);

        jMenuRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        jMenuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/relatórios.png"))); // NOI18N
        jMenuRelatorio.setText("Relatorio");

        jMenuItem2.setText("Recebimento");
        jMenuRelatorio.add(jMenuItem2);

        jMenuItem3.setText("Despesas");
        jMenuRelatorio.add(jMenuItem3);

        jMenuBar1.add(jMenuRelatorio);

        jMenuConfigurações.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/configurações.png"))); // NOI18N
        jMenuConfigurações.setText("Configurações");

        jMenuItemModificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/modificar.png"))); // NOI18N
        jMenuItemModificarUsuario.setText("Modificar Usuário Cadastrado");
        jMenuItemModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarUsuarioActionPerformed(evt);
            }
        });
        jMenuConfigurações.add(jMenuItemModificarUsuario);

        jMenuBar1.add(jMenuConfigurações);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sobre.png"))); // NOI18N
        jMenu4.setText("Sobre");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sobre.png"))); // NOI18N
        jMenuItem1.setText("Sobre o Sistema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_RecebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RecebimentoActionPerformed
        //METODO EXIBIR TELA DE RECEBIMENTO  
        //gerenteDeJanelas.abrirJanelas(Recebimento.getInstancia());
        Recebimento exibirtelaRecebimento = new Recebimento();
        jDesktopPane1.add(exibirtelaRecebimento);   //ADICIONANDO A TELA DE RECEBIMENTO AO DESKTOP PRINCIPAL 
               
        try {                                       //TRY CASH PARA A TELA DE RECEBIMENDO EXIBIR NO TAMANHO IDEAL DA TELA
            exibirtelaRecebimento.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        exibirtelaRecebimento.setVisible(true);     //EXIBE A TELA RECEBIMENTO
    }//GEN-LAST:event_bt_RecebimentoActionPerformed

    private void jDiasCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDiasCalendarioMouseClicked
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        
        String dataFormatada = simpleDateFormat.format(this.jDiasCalendario.getDay());
        
        System.out.println(dataFormatada);
 
    }//GEN-LAST:event_jDiasCalendarioMouseClicked

    private void bt_DespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DespesasActionPerformed
        Despesa exibirTelaCancelamento = new Despesa();
        jDesktopPane1.add(exibirTelaCancelamento);
        exibirTelaCancelamento.setVisible(true);
    }//GEN-LAST:event_bt_DespesasActionPerformed

    private void bt_VisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_VisualizarActionPerformed
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        
        String dataFormatada = simpleDateFormat.format(this.jDiasCalendario.getDay());
        
        System.out.println(dataFormatada);
    }//GEN-LAST:event_bt_VisualizarActionPerformed

    private void bt_CadastrarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CadastrarPessoaActionPerformed
        CadastrarPessoa exibirTelaCadastrarPessoa = new CadastrarPessoa();
        jDesktopPane1.add(exibirTelaCadastrarPessoa);
        exibirTelaCadastrarPessoa.setVisible(true);
    }//GEN-LAST:event_bt_CadastrarPessoaActionPerformed

    private void jMenuItemModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarUsuarioActionPerformed
        // TODO add your handling code here:
        
        AlterarCadastroUsuario TelaCadUsuario = new AlterarCadastroUsuario();
        jDesktopPane1.add(TelaCadUsuario);
        TelaCadUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItemModificarUsuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Sobre telaSobre = new Sobre();
        jDesktopPane1.add(telaSobre);
        telaSobre.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void bt_atualizarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atualizarPessoaActionPerformed

        AtualizarPessoa atualizaPessoa = new AtualizarPessoa();
        jDesktopPane1.add(atualizaPessoa);
        atualizaPessoa.setVisible(true);
        
    }//GEN-LAST:event_bt_atualizarPessoaActionPerformed

    private void jMenuExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExcluirUsuarioActionPerformed

        

    }//GEN-LAST:event_jMenuExcluirUsuarioActionPerformed

    private void jMenuAdicionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAdicionarUsuarioActionPerformed

         AdicionarUsuario addUsuario = new AdicionarUsuario();
        addUsuario.setVisible(true);

    }//GEN-LAST:event_jMenuAdicionarUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bt_CadastrarPessoa;
    private javax.swing.JMenuItem bt_Despesas;
    private javax.swing.JMenuItem bt_Recebimento;
    private javax.swing.JButton bt_Visualizar;
    private javax.swing.JMenuItem bt_atualizarPessoa;
    private javax.swing.JDesktopPane jDesktopPane1;
    private com.toedter.calendar.JDayChooser jDiasCalendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuAdicionarUsuario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConfigurações;
    private javax.swing.JMenuItem jMenuExcluirUsuario;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemModificarUsuario;
    private javax.swing.JMenu jMenuPessoa;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JMenu jMenuTitulo;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextDate;
    private javax.swing.JTextField jTextField2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel jlabelUserName;
    // End of variables declaration//GEN-END:variables
}
