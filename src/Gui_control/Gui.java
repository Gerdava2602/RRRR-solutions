/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_control;

import Nodos.Arbol;
import Nodos.Nodo;
import Nodos.Publicacion;
import Nodos.Usuario;
import file_control.Jason;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author German David
 */
public class Gui extends javax.swing.JFrame {
    static infoPage tutor;
    SaveStage saveS;
    ChooserFrame chooser;
    /**
     * Creates new form Gui
     */
    public Gui() throws IOException {
        initComponents();
        this.setTitle("Menú");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        tutor = new infoPage(this);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        save = new javax.swing.JButton();
        tutorial = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu (1).png"))); // NOI18N
        jLabel3.setText("Menú");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, -1));

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setFont(new java.awt.Font("Dubai", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/archivoAmarillo.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 270, -1));

        save.setBackground(new java.awt.Color(0, 102, 204));
        save.setFont(new java.awt.Font("Dubai", 1, 36)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/disqueteAmarillo.png"))); // NOI18N
        save.setBorder(null);
        save.setBorderPainted(false);
        save.setContentAreaFilled(false);
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 250, -1));

        tutorial.setBackground(new java.awt.Color(0, 102, 204));
        tutorial.setFont(new java.awt.Font("Dubai", 1, 36)); // NOI18N
        tutorial.setForeground(new java.awt.Color(255, 255, 255));
        tutorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tutBlanco.png"))); // NOI18N
        tutorial.setText("Tutorial");
        tutorial.setBorder(null);
        tutorial.setBorderPainted(false);
        tutorial.setContentAreaFilled(false);
        tutorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialActionPerformed(evt);
            }
        });
        getContentPane().add(tutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 250, -1));

        jButton5.setBackground(new java.awt.Color(255, 195, 24));
        jButton5.setFont(new java.awt.Font("Dubai", 1, 36)); // NOI18N
        jButton5.setForeground(new java.awt.Color(251, 255, 241));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/salir.png"))); // NOI18N
        jButton5.setText("Salir");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 150, -1));

        jLabel2.setFont(new java.awt.Font("Dubai Light", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 195, 24));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONVERTIR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dubai Light", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 195, 24));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GUARDADOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        tutor.setVisible(true);
        tutor.run();
        this.setVisible(false);
    }//GEN-LAST:event_tutorialActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        chooser = new ChooserFrame(this);
        chooser.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        this.setVisible(false);
        saveS= new SaveStage(this);
        saveS.setVisible(true);
    }//GEN-LAST:event_saveActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Gui().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton save;
    private javax.swing.JButton tutorial;
    // End of variables declaration//GEN-END:variables

    private void paintTree(Arbol arbol) {
        ArbolPanel panel = new ArbolPanel(this, arbol);
        panel.setVisible(true);
    }
}
