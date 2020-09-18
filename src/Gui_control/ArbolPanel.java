/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_control;

import Nodos.Arbol;
import Nodos.Comentario;
import Nodos.Nodo;
import Nodos.Publicacion;
import Nodos.Usuario;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author German David
 */
public class ArbolPanel extends javax.swing.JFrame{ //implements Runnable{

    Graphics g;
    JFrame blog;
    Arbol a;
    BufferedImage user,post,comment;
    private final int r = 25;
    private final int eV = 100;
    
    public ArbolPanel(JFrame blog, Arbol a) {
        initComponents();
        this.setResizable(false);
        this.a = a;
        this.g = panel.getGraphics();
        panel.setAutoscrolls(true);
        try {
            user = ImageIO.read(getClass().getResource("/Images/grupo.png"));
            post = ImageIO.read(getClass().getResource("/Images/blog.png"));
            comment = ImageIO.read(getClass().getResource("/Images/comentario.png"));
        } catch (IOException ex) {
            Logger.getLogger(ArbolPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/*    
    @Override
    public void run() {
    while (true) {
        paintTree(a,a.Raiz);
        g.clearRect(0, 0, panel.getWidth(), panel.getHeight());
    }
}
*/    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("DIBUJAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1254, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 451, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(660, 660, 660))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(466, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            this.paintTree(a, a.Raiz);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    public void setA(Arbol a) {
        this.a = a;
    }

    public void paintTree(Arbol tree, Nodo Raiz) {
        int width = panel.getWidth();
        int height = panel.getHeight() + 139;
        System.out.println(width + " " + height);
        g.drawOval(width / 2, 70, r, r);
        Usuario u = a.getUserPtr();
        int i = 0;
        int k = 0;
        int s = 0;
        while (u != null) {
            g.drawLine(10+(width / 2) + r / 2, 70 + r, 10+(50 + i * (width / (a.userSize()))) + r / 2, 70 + eV);
            g.drawImage(user,10+ 50 + i * (width / (a.userSize())), 70 + eV, r, r, null);
            Publicacion p = u.getPostPtr();
            while (p != null) {
                g.drawLine((10+(50 + i * (width / (a.userSize()))) + r / 2), 70 + eV + r, 10+(k * (width / a.totalPostSize()) + (r - 15) / 2), 70 + 2 * eV);
                g.drawImage(post,10+k * (width / (a.totalPostSize())), 70 + 2 * eV, r - 15, r - 15, null);
                
                Comentario c = p.getComentarioPtr();
                while (c != null) {
                    
                    int x1 = 10+s * (width / a.totalCommentSize());
                    int y1 = 70 + 4 * eV;
                    int x2 = 10+(k * (width / a.totalPostSize()) + (r - 15) / 2);
                    int y2 = 70 + 2 * eV;
                    int R = 2;
                    g.drawImage(comment,x1, y1, 2, 2, null);
                    g.drawLine(x2, y2+r-15, x1 + R/2, y1 );
                    s++;
                    c = c.getLink();
                }
                s++;
                k++;
                p = p.getLink();
            }
            i++;
            u = u.getLink();
        }
    }


}
