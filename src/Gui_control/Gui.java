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
    
    SaveStage saveS;
    File users, posts, comments;
    Jason jason;
    Arbol arbol;
    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();
        saveS= new SaveStage(this);
        jason = new Jason();
        
        arbol = new Arbol();
        
        users = new File("C:\\Users\\German David\\Desktop\\user.txt");
        posts = new File("C:\\Users\\German David\\Desktop\\posts.txt");
        comments = new File("C:\\Users\\German David\\Desktop\\comments.txt");
        
    }

    //Este método crea el fileChooser para poder navegar y encontrar los archivos
    private static File createFileChooser(final JFrame frame) {
        
        String filename = File.separator+"tmp";
        //Crea el fileChooser
        JFileChooser fileChooser = new JFileChooser(new File(filename));
        //Establece un FileFilter para que solo se muestre cierto tipo de archivo
        fileChooser.setFileFilter(new FileFilter() {
        @Override
        //Verifica que solo se encuentren archivos txt
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            final String name = f.getName();
            return name.endsWith(".txt");
        }
        
        //Agrega al descripción para que el usuario sepa que tipo de archivo debe encontrar
        @Override
        public String getDescription() {
            return "*.txt";
        }
    });
        try{
        // Configura el tipo de mensaje para abrir el buscador de archivos
        fileChooser.showOpenDialog(frame);
        
        System.out.println("File to open: " + fileChooser.getSelectedFile());
        return fileChooser.getSelectedFile();
        }catch(NullPointerException io){
            System.out.println("El proceso fue cancelado, ingrese nuevamente el archivo");
            return null;
        }
        
        /*
        // pop up an "Save File" file chooser dialog
        fileChooser.showSaveDialog(frame);
 
        System.out.println("File to save: " + fileChooser.getSelectedFile());
        */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        save = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Choose");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        text.setColumns(20);
        text.setRows(5);
        scroll.setViewportView(text);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton2.setText("Convert");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Choose");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Choose");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Users");

        jLabel2.setText("Posts");

        jLabel3.setText("Comments");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //BufferedReader para poder convertir el archivo a String
        BufferedReader br;
        text.setText("");
        try {
            //Crea el bufferedReader y le agrega un fileReader que leerá el archivo seleccionado
            users = createFileChooser(this);
            br = new BufferedReader(new FileReader(users));
            String st; 
            while ((st = br.readLine()) != null) 
               text.append(st+"\n");
        //Catchs para los dos tipos de excepciones que podríamos encontrar    
        } catch (FileNotFoundException ex) {
            System.out.println("Este archivo no pudo ser leido");;
        } catch (NullPointerException ex) {
            System.out.println("Ha sucedido un error");;
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    this.setVisible(false);
    saveS.setVisible(true);
    }//GEN-LAST:event_saveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(users == null /*|| comments == null || posts == null*/){
            System.out.println("Hey papi, no has montado una verga");
        }else{
            try {
                arbol = jason.convert(arbol,users, posts, comments);
            } catch (IOException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                //BufferedReader para poder convertir el archivo a String
        BufferedReader br;
        text.setText("");
        try {
            //Crea el bufferedReader y le agrega un fileReader que leerá el archivo seleccionado
            posts = createFileChooser(this);
            br = new BufferedReader(new FileReader(posts));
            String st; 
            while ((st = br.readLine()) != null) 
               text.append(st+"\n");
        //Catchs para los dos tipos de excepciones que podríamos encontrar    
        } catch (FileNotFoundException ex) {
            System.out.println("Este archivo no pudo ser leido");;
        } catch (NullPointerException ex) {
            System.out.println("Ha sucedido un error");;
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                //BufferedReader para poder convertir el archivo a String
        BufferedReader br;
        text.setText("");
        try {
            //Crea el bufferedReader y le agrega un fileReader que leerá el archivo seleccionado
            comments = createFileChooser(this);
            br = new BufferedReader(new FileReader(comments));
            String st; 
            while ((st = br.readLine()) != null) 
               text.append(st+"\n");
        //Catchs para los dos tipos de excepciones que podríamos encontrar    
        } catch (FileNotFoundException ex) {
            System.out.println("Este archivo no pudo ser leido");;
        } catch (NullPointerException ex) {
            System.out.println("Ha sucedido un error");;
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }//GEN-LAST:event_jButton4ActionPerformed

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
                new Gui().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton save;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
