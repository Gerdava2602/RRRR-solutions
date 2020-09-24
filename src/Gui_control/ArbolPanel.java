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
        this.setTitle("Árbol");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
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

        panel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1254, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dubai", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(251, 255, 241));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/atras2.png"))); // NOI18N
        jButton2.setText("Atrás");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(251, 255, 241));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dibujar.png"))); // NOI18N
        jButton1.setText("DIBUJAR");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    public void setA(Arbol a) {
        this.a = a;
    }

    public void paintTree(Arbol tree, Nodo Raiz) {
        int width = panel.getWidth();
        int height = panel.getHeight() + 139;
        System.out.println(width + " " + height);
        g.setColor(Color.white);
        g.drawOval(width / 2, 70, r, r);
        Usuario u = a.getUserPtr();
        int i = 0;
        float k = 0;
        float s = 0;
        while (u != null) {
            g.setColor(Color.white);
            g.drawLine(10+(width / 2) + r / 2, 70 + r, 10+(50 + i * (width / (a.userSize()))) + r / 2, 70 + eV);
            g.drawImage(user,10+ 50 + i * (width / (a.userSize())), 70 + eV, r, r, null);
            Publicacion p = u.getPostPtr();
            while (p != null) {
                g.setColor(Color.blue);
                g.drawLine((10+(50 + i * (width / (a.userSize()))) + r / 2), 70 + eV + r, (int) (10+(k * (width / a.totalPostSize()) + (r - 15) / 2)), 70 + 2 * eV);
                g.drawImage(post, (int) (10+k * (width / (a.totalPostSize()))), 70 + 2 * eV, r - 15, r - 15, null);
                
                Comentario c = p.getComentarioPtr();
                while (c != null) {
                    
                    int x1 = (int) (10+s * (width / a.totalCommentSize()));
                    int y1 = 70 + 4 * eV;
                    int x2 = (int) (10+(k * (width / (a.totalPostSize())) + (r - 15) / 2));
                    int y2 = 70 + 2 * eV;
                    int R = 2;
                    g.setColor(Color.ORANGE);
                    g.drawImage(comment,x1, y1, 2, 2, null);
                    g.drawLine(x2, y2+r-15, x1 + R/2, y1 );
                    s++;
                    c = c.getLink();
                }
                s+=1.25;
                k++;
                p = p.getLink();
            }
            k+=0.5;
            i++;
            u = u.getLink();
        }
    }

    
}
