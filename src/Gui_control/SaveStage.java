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
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author German David
 */
public class SaveStage extends javax.swing.JFrame {
    File directory;
    File[] saved;
    JFrame principle;
    String[] nameList;
    Map<String, ImageIcon> imageMap;
    /**
     * Creates new form SaveStage
     * @param frame
     */
    public SaveStage(JFrame frame) {
        initComponents();
        principle = frame;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        directory = new File("C:\\Users\\German David\\Desktop\\Trabajos\\2020-3\\Datos II\\Lab01_GermanVargas_RaulLopez_SebastianGonzalez\\saved");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        savedList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        savedList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(savedList);

        jLabel1.setText("Guardados");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        principle.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> savedList;
    // End of variables declaration//GEN-END:variables
}
