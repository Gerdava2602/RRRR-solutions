/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_control;

import file_control.Jason;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    File selected;
    Jason jason;
    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();
        saveS= new SaveStage(this);
        jason = new Jason();
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archivo.png"))); // NOI18N
        jButton1.setText("Escoger archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 60));

        text.setColumns(20);
        text.setRows(5);
        scroll.setViewportView(text);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 700, 290));

        save.setBackground(new java.awt.Color(0, 102, 153));
        save.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        save.setText("Archivos guardados");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 250, 60));

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/convertir.png"))); // NOI18N
        jButton2.setText("Convertir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 190, 60));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bik.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //BufferedReader para poder convertir el archivo a String
        BufferedReader br;
        text.setText("");
        try {
            //Crea el bufferedReader y le agrega un fileReader que leerá el archivo seleccionado
            selected = createFileChooser(this);
            br = new BufferedReader(new FileReader(selected));
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
        if(selected == null){
            System.out.println("Hey papi, no has montado una verga");
        }else{
            try {
                Jason.convert(null,selected,null,null);
            } catch (IOException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton save;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
