/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_control;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 * Mostrar en el JList todos archivos ya guardados y serializados en el proyecto.
 * 
 */

public class SaveStage extends javax.swing.JFrame {
    File directory;
    File[] saved;
    JFrame principle;
    String[] nameList;
    Map<String, ImageIcon> imageMap;
    /**
     * Crea un SaveStage
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
        
        DefaultListModel model = new DefaultListModel();
        savedList.setModel(model);
        
        ArrayList<String> nameArray = new ArrayList();
        for (File file : saved) {
            nameArray.add(file.toString());
        }
        nameList=convertToArray(nameArray);
        savedList.setListData(nameList);
        imageMap = createImageMap(nameList);
        savedList.setCellRenderer(new ListRenderer());
    }
    /**
    * Convierte un ArrayList, a una lista que fue implementada por nosotros
    * @param nameArray
    * @return Lista
    */
    private String[] convertToArray(ArrayList<String> nameArray) {
            String[] List = new String[nameArray.size()];
            int i=0;
            for (String string : nameArray) {
                List[i]=string;
                i++;
            }
            return List;
    }

        public class ListRenderer extends DefaultListCellRenderer {

        Font font = new Font("helvitica", Font.BOLD, 15);

        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setIcon(imageMap.get((String) value));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);
            return label;
        }
    }
    /**
     * Hacemos el uso del HashMap, que es un diccionario para almacenar un número arbitrario de objetos,
     * luego se identifican con una clave única dentro de ellos, permitiendo la efienciencia en procesos de búsqueda, selección e inserción
     * @param list
     * @return map
     */
    private Map<String, ImageIcon> createImageMap(String[] list) {
        Map<String, ImageIcon> map = new HashMap<>();
        try {
            ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResource("/Images/folder.png")));
            for (String string : list){
                map.put(string, icon); 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        convertir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        savedList = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
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
        getContentPane().add(convertir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, -1, -1));

        savedList.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        savedList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        savedList.setOpaque(false);
        jScrollPane1.setViewportView(savedList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 680, 480));

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondodecarga.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        principle.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public JFrame getPrinciple() {
        return principle;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton convertir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> savedList;
    // End of variables declaration//GEN-END:variables
}
