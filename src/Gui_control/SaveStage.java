/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_control;

import Nodos.Arbol;
import file_control.Serializador;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Panel donde se muestra un preview, cuando se carga un archivo serializado.
 */
public class SaveStage extends javax.swing.JFrame {

    File directory;
    File[] saved;
    JFrame principle;
    String path;

    /**
     * Creates new form SaveStage
     *
     * @param frame
     */
    public SaveStage(JFrame frame) {
        initComponents();
        principle = frame;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        String workingDirectory = System.getProperty("user.dir");
        String images = workingDirectory + "\\" + "src\\Images";
        directory = new File(images);
        saved = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                final String name = f.getName();
                return name.endsWith(".txt");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        convertir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        convertir.setBackground(new java.awt.Color(0, 102, 153));
        convertir.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        convertir.setForeground(new java.awt.Color(54, 57, 66));
        convertir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arcAzul.png"))); // NOI18N
        convertir.setText("Convertir");
        convertir.setBorder(null);
        convertir.setBorderPainted(false);
        convertir.setContentAreaFilled(false);
        convertir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        convertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertirActionPerformed(evt);
            }
        });
        getContentPane().add(convertir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        jButton1.setForeground(new java.awt.Color(251, 255, 241));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/atras.png"))); // NOI18N
        jButton1.setText("Atrás");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 230, -1));

        loadButton.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        loadButton.setForeground(new java.awt.Color(54, 57, 66));
        loadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cargar.png"))); // NOI18N
        loadButton.setText("Cargar");
        loadButton.setBorder(null);
        loadButton.setBorderPainted(false);
        loadButton.setContentAreaFilled(false);
        loadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 230, 80));

        text.setColumns(20);
        text.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        text.setRows(5);
        text.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        text.setEnabled(false);
        text.setOpaque(false);
        scroll.setViewportView(text);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 690, 480));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondodecarga.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        principle.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void convertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertirActionPerformed
        Arbol a;
        try {
            if (path != null) {
                a = Serializador.crearArbol(path);
                Blog blog = new Blog(a, this, path);
                this.setVisible(false);
                blog.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "No ha escogido ningun archivo");
            }

        } catch (IOException ex) {
            Logger.getLogger(Blog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_convertirActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        BufferedReader br;
        text.setText("");
        File file;

        try {
            //Crea el bufferedReader y le agrega un fileReader que leerá el archivo seleccionado
            file = ChooserFrame.createFileChooser(this, ".csv");
            path = file.getPath();
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                text.append(st + "\n");
            }
            //Catchs para los dos tipos de excepciones que podríamos encontrar
        } catch (FileNotFoundException ex) {
            System.out.println("Este archivo no pudo ser leido");;
        } catch (NullPointerException ex) {
            System.out.println("Ha sucedido un error");;
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    public JFrame getPrinciple() {
        return principle;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton convertir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loadButton;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
