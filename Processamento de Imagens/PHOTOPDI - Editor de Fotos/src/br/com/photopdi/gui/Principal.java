package br.com.photopdi.gui;

import br.com.photopdi.dominio.Filtros;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Principal extends javax.swing.JFrame {

    private File jfc_padrao;
    private BufferedImage imagem;
    private File imgOriginal;
    private String url;

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jpanel_principal = new javax.swing.JPanel();
        label_imgPrincipal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        subMenu_arquivo_abrir = new javax.swing.JMenu();
        menu_arquivo_bt_abrir = new javax.swing.JMenuItem();
        menu_arquivo_bt_salvar = new javax.swing.JMenuItem();
        menu_arquivo_limpar = new javax.swing.JMenuItem();
        menu_arquivo_sair = new javax.swing.JMenuItem();
        menu_filtros = new javax.swing.JMenu();
        menu_filtros_bt_brilho = new javax.swing.JMenuItem();
        menu_filtros_bt_contraste = new javax.swing.JMenuItem();
        menu_filtros_btEscalaDeCinza = new javax.swing.JMenuItem();
        menu_filtros_btNegativo = new javax.swing.JMenuItem();
        menu_filtros_btBinarizacao = new javax.swing.JMenuItem();
        menu_filtros_btSuavizacao = new javax.swing.JMenuItem();
        menu_filtros_btBordas = new javax.swing.JMenuItem();
        menu_filtros_btQuantificacao = new javax.swing.JMenuItem();
        menu_filtros_btPaletaDeCores = new javax.swing.JMenuItem();
        menu_filtros_btOriginal = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        jMenuItem10.setText("jMenuItem10");

        jMenuItem11.setText("jMenuItem11");

        jMenu3.setText("jMenu3");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jpanel_principal.setBackground(new java.awt.Color(51, 51, 51));
        jpanel_principal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpanel_principalLayout = new javax.swing.GroupLayout(jpanel_principal);
        jpanel_principal.setLayout(jpanel_principalLayout);
        jpanel_principalLayout.setHorizontalGroup(
            jpanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_principalLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(label_imgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jpanel_principalLayout.setVerticalGroup(
            jpanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_principalLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(label_imgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuBar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        subMenu_arquivo_abrir.setText("Arquivo");

        menu_arquivo_bt_abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_bt_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/photopdi/imagens/abrir.png"))); // NOI18N
        menu_arquivo_bt_abrir.setText("Abrir");
        menu_arquivo_bt_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_arquivo_bt_abrirActionPerformed(evt);
            }
        });
        subMenu_arquivo_abrir.add(menu_arquivo_bt_abrir);

        menu_arquivo_bt_salvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/photopdi/imagens/salvar.png"))); // NOI18N
        menu_arquivo_bt_salvar.setText("Salvar");
        menu_arquivo_bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_arquivo_bt_salvarActionPerformed(evt);
            }
        });
        subMenu_arquivo_abrir.add(menu_arquivo_bt_salvar);

        menu_arquivo_limpar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/photopdi/imagens/limpar.png"))); // NOI18N
        menu_arquivo_limpar.setText("Limpar");
        menu_arquivo_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_arquivo_limparActionPerformed(evt);
            }
        });
        subMenu_arquivo_abrir.add(menu_arquivo_limpar);

        menu_arquivo_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/photopdi/imagens/fechar.png"))); // NOI18N
        menu_arquivo_sair.setText("Sair");
        menu_arquivo_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_arquivo_sairActionPerformed(evt);
            }
        });
        subMenu_arquivo_abrir.add(menu_arquivo_sair);

        jMenuBar1.add(subMenu_arquivo_abrir);

        menu_filtros.setText("Filtros");

        menu_filtros_bt_brilho.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        menu_filtros_bt_brilho.setText("Brilho");
        menu_filtros_bt_brilho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filtros_bt_brilhoActionPerformed(evt);
            }
        });
        menu_filtros.add(menu_filtros_bt_brilho);

        menu_filtros_bt_contraste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menu_filtros_bt_contraste.setText("Contraste");
        menu_filtros_bt_contraste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filtros_bt_contrasteActionPerformed(evt);
            }
        });
        menu_filtros.add(menu_filtros_bt_contraste);

        menu_filtros_btEscalaDeCinza.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        menu_filtros_btEscalaDeCinza.setText("Escala de Cinza");
        menu_filtros_btEscalaDeCinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filtros_btEscalaDeCinzaActionPerformed(evt);
            }
        });
        menu_filtros.add(menu_filtros_btEscalaDeCinza);

        menu_filtros_btNegativo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        menu_filtros_btNegativo.setText("Negativo");
        menu_filtros_btNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filtros_btNegativoActionPerformed(evt);
            }
        });
        menu_filtros.add(menu_filtros_btNegativo);

        menu_filtros_btBinarizacao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        menu_filtros_btBinarizacao.setText("Binarização");
        menu_filtros_btBinarizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filtros_btBinarizacaoActionPerformed(evt);
            }
        });
        menu_filtros.add(menu_filtros_btBinarizacao);

        menu_filtros_btSuavizacao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        menu_filtros_btSuavizacao.setText("Suavização");
        menu_filtros_btSuavizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filtros_btSuavizacaoActionPerformed(evt);
            }
        });
        menu_filtros.add(menu_filtros_btSuavizacao);

        menu_filtros_btBordas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        menu_filtros_btBordas.setText("Detecção de Bordas");
        menu_filtros_btBordas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filtros_btBordasActionPerformed(evt);
            }
        });
        menu_filtros.add(menu_filtros_btBordas);

        menu_filtros_btQuantificacao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        menu_filtros_btQuantificacao.setText("Quantificação");
        menu_filtros_btQuantificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filtros_btQuantificacaoActionPerformed(evt);
            }
        });
        menu_filtros.add(menu_filtros_btQuantificacao);

        menu_filtros_btPaletaDeCores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.CTRL_MASK));
        menu_filtros_btPaletaDeCores.setText("Paleta de Cores");
        menu_filtros_btPaletaDeCores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filtros_btPaletaDeCoresActionPerformed(evt);
            }
        });
        menu_filtros.add(menu_filtros_btPaletaDeCores);

        menu_filtros_btOriginal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menu_filtros_btOriginal.setText("Imagem Original");
        menu_filtros_btOriginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filtros_btOriginalActionPerformed(evt);
            }
        });
        menu_filtros.add(menu_filtros_btOriginal);

        jMenuBar1.add(menu_filtros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpanel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_arquivo_bt_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_arquivo_bt_abrirActionPerformed

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg");

        //As configuracoes do choose para abrir a janela
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.addChoosableFileFilter(filter);

        jfc.showOpenDialog(null);//Abrindo a janela de selecao
        File img = jfc.getSelectedFile();//Armazenando oq foi selecionado na janela
       
        ImageIcon imagem = new ImageIcon(img.toString());
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagem.getImage().getScaledInstance(664,367,WIDTH)));
        jfc_padrao = img;
        imgOriginal = img;
        url = img.getAbsolutePath();

    }//GEN-LAST:event_menu_arquivo_bt_abrirActionPerformed

    private void menu_filtros_btEscalaDeCinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filtros_btEscalaDeCinzaActionPerformed

        try {
            imagem = ImageIO.read(jfc_padrao);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagem = imagem;
        Filtros ImagemEmCinza = new Filtros();
        BufferedImage imgAlt = ImagemEmCinza.tonsDeCinza(imagem);
        ImageIcon imagemAlt = new ImageIcon(imgAlt);
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagemAlt.getImage().getScaledInstance(664,367,WIDTH)));
    }//GEN-LAST:event_menu_filtros_btEscalaDeCinzaActionPerformed

    private void menu_filtros_btBordasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filtros_btBordasActionPerformed

        try {
            imagem = ImageIO.read(jfc_padrao);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagem = imagem;
        Filtros ImagemPassaAlta = new Filtros();
        BufferedImage imgAlt = ImagemPassaAlta.passaAlta(imagem);
        ImageIcon imagemAlt = new ImageIcon(imgAlt);
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagemAlt.getImage().getScaledInstance(664,367,WIDTH)));
    }//GEN-LAST:event_menu_filtros_btBordasActionPerformed

    private void menu_filtros_btNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filtros_btNegativoActionPerformed

        try {
            imagem = ImageIO.read(jfc_padrao);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagem = imagem;
        Filtros ImagemNegativa = new Filtros();
        BufferedImage imgAlt = ImagemNegativa.negativo(imagem);
        ImageIcon imagemAlt = new ImageIcon(imgAlt);
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagemAlt.getImage().getScaledInstance(664,367,WIDTH)));
    }//GEN-LAST:event_menu_filtros_btNegativoActionPerformed

    private void menu_filtros_btSuavizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filtros_btSuavizacaoActionPerformed

        try {
            imagem = ImageIO.read(jfc_padrao);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagem = imagem;
        Filtros ImagemSuavizada = new Filtros();
        BufferedImage imgAlt = ImagemSuavizada.suavizacao(imagem);
        ImageIcon imagemAlt = new ImageIcon(imgAlt);
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagemAlt.getImage().getScaledInstance(664,367,WIDTH)));
    }//GEN-LAST:event_menu_filtros_btSuavizacaoActionPerformed

    private void menu_filtros_btBinarizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filtros_btBinarizacaoActionPerformed

        try {
            imagem = ImageIO.read(jfc_padrao);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagem = imagem;
        Filtros ImagemBinarizada = new Filtros();
        BufferedImage imgAlt = ImagemBinarizada.binarizacao(imagem);
        ImageIcon imagemAlt = new ImageIcon(imgAlt);
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagemAlt.getImage().getScaledInstance(664,367,WIDTH)));

    }//GEN-LAST:event_menu_filtros_btBinarizacaoActionPerformed

    private void menu_arquivo_bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_arquivo_bt_salvarActionPerformed

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg");
        JFileChooser choose = new JFileChooser();
        choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
        choose.setAcceptAllFileFilterUsed(false);
        choose.addChoosableFileFilter(filter);

        choose.showSaveDialog(null);

        
        File file = new File(choose.getSelectedFile().getAbsolutePath() + ".jpg");
        url = (choose.getSelectedFile().getAbsolutePath() + ".jpg");
        try {
            ImageIO.write(imagem, "jpg", file);
            JOptionPane.showMessageDialog(rootPane, "Imagem salva com sucesso!");
//        url = file.getAbsolutePath();
//        System.out.println("URL" + url);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_menu_arquivo_bt_salvarActionPerformed

    private void menu_filtros_bt_brilhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filtros_bt_brilhoActionPerformed

        try {
            imagem = ImageIO.read(jfc_padrao);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagem = imagem;
        Filtros ImagemBrilho = new Filtros();
        float op =Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de brilho (1-10):\nSe a imagem ficar branca é porque ocorreu\n supersaturação de brilho. Retorne a imagem\noriginal e tente novamente "));
        BufferedImage imgAlt = ImagemBrilho.brilho(imagem, op);
        ImageIcon imagemAlt = new ImageIcon(imgAlt);
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagemAlt.getImage().getScaledInstance(664,367,WIDTH)));

    }//GEN-LAST:event_menu_filtros_bt_brilhoActionPerformed

    private void menu_filtros_btOriginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filtros_btOriginalActionPerformed

        try {
            imagem = ImageIO.read(imgOriginal);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagem = imagem;
        ImageIcon imagemOri = new ImageIcon(imgOriginal.getAbsolutePath());
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagemOri.getImage().getScaledInstance(664,367,WIDTH)));

    }//GEN-LAST:event_menu_filtros_btOriginalActionPerformed

    private void menu_arquivo_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_arquivo_limparActionPerformed

        jfc_padrao = null;
        imagem = null;
        ImageIcon imagemOri = new ImageIcon();
        label_imgPrincipal.setIcon(imagemOri);

    }//GEN-LAST:event_menu_arquivo_limparActionPerformed

    private void menu_filtros_bt_contrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filtros_bt_contrasteActionPerformed

        try {
            imagem = ImageIO.read(jfc_padrao);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagem = imagem;
        Filtros ImagemContraste = new Filtros();
        int op =Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de contraste:"));
        BufferedImage imgAlt = ImagemContraste.contraste(imagem, op);
        ImageIcon imagemAlt = new ImageIcon(imgAlt);
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagemAlt.getImage().getScaledInstance(664,367,WIDTH)));

    }//GEN-LAST:event_menu_filtros_bt_contrasteActionPerformed

    private void menu_arquivo_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_arquivo_sairActionPerformed

        int op = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja sair? Voce poderá perder seu trabalho caso não tenha salvo!");
        if (op == 0) {
            System.exit(0);
        } else {

        }

    }//GEN-LAST:event_menu_arquivo_sairActionPerformed

    private void menu_filtros_btQuantificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filtros_btQuantificacaoActionPerformed

        try {
            imagem = ImageIO.read(jfc_padrao);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagem = imagem;
        Filtros ImagemQuantizada = new Filtros();
        BufferedImage imgAlt = ImagemQuantizada.equalizacao(imagem);
        ImageIcon imagemAlt = new ImageIcon(imgAlt);
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagemAlt.getImage().getScaledInstance(664,367,WIDTH)));
        
                
    }//GEN-LAST:event_menu_filtros_btQuantificacaoActionPerformed

    private void menu_filtros_btPaletaDeCoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filtros_btPaletaDeCoresActionPerformed

        try {
            imagem = ImageIO.read(jfc_padrao);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagem = imagem;
        Filtros ImagemPaleta = new Filtros();
        BufferedImage imgAlt = ImagemPaleta.paleta(imagem);
        ImageIcon imagemAlt = new ImageIcon(imgAlt);
        label_imgPrincipal.setIcon(new javax.swing.ImageIcon(imagemAlt.getImage().getScaledInstance(664,367,WIDTH)));
        
    }//GEN-LAST:event_menu_filtros_btPaletaDeCoresActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jpanel_principal;
    private javax.swing.JLabel label_imgPrincipal;
    private javax.swing.JMenuItem menu_arquivo_bt_abrir;
    private javax.swing.JMenuItem menu_arquivo_bt_salvar;
    private javax.swing.JMenuItem menu_arquivo_limpar;
    private javax.swing.JMenuItem menu_arquivo_sair;
    private javax.swing.JMenu menu_filtros;
    private javax.swing.JMenuItem menu_filtros_btBinarizacao;
    private javax.swing.JMenuItem menu_filtros_btBordas;
    private javax.swing.JMenuItem menu_filtros_btEscalaDeCinza;
    private javax.swing.JMenuItem menu_filtros_btNegativo;
    private javax.swing.JMenuItem menu_filtros_btOriginal;
    private javax.swing.JMenuItem menu_filtros_btPaletaDeCores;
    private javax.swing.JMenuItem menu_filtros_btQuantificacao;
    private javax.swing.JMenuItem menu_filtros_btSuavizacao;
    private javax.swing.JMenuItem menu_filtros_bt_brilho;
    private javax.swing.JMenuItem menu_filtros_bt_contraste;
    private javax.swing.JMenu subMenu_arquivo_abrir;
    // End of variables declaration//GEN-END:variables
}
