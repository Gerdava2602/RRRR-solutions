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
import java.awt.Font;
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
import javax.swing.JOptionPane;

/**
 * Dibuja árboles acorde a los que desee el usuario
 * Puede dibujar el arbol de toda la información, el de un usuario en específico y el de un post en específico
 */
public class ArbolPanel extends javax.swing.JFrame { 

    Graphics g;
    JFrame blog;
    Arbol a;
    BufferedImage user, post, comment;
    private final int r = 25;
    private final int eV = 100;
    int c;
    Font fontte = new Font("Dubai", Font.BOLD, 14);
    Font font = new Font("Dubai", Font.BOLD, 16);
    Color azul = new Color(40,133,146);
    Color gris = new Color(54,57,66);
    Nodo currentNodo;
    Usuario currentUser;
    Publicacion currentPost;
    /**
     * Es el constructor de la clase ArbolPanel
     * @param blog Toma el JFrame donde se ubicará la información del árbol
     * @param a Recibe el árbol con la información
     */
    public ArbolPanel(JFrame blog, Arbol a) {
        initComponents();
        this.setTitle("Árbol");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.a = a;
        this.a.Raiz.usuario = this.a.getUserPtr();
        this.g = panel.getGraphics();
        this.currentNodo = a.Raiz;
        this.currentUser = null;
        this.currentPost = null;
        this.c = 0;
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
        nextPost = new javax.swing.JButton();
        prevPost = new javax.swing.JButton();
        prevUser = new javax.swing.JButton();
        nextUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(54, 57, 66));
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

        nextPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/siguiente.png"))); // NOI18N
        nextPost.setBorderPainted(false);
        nextPost.setContentAreaFilled(false);
        nextPost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPostActionPerformed(evt);
            }
        });
        getContentPane().add(nextPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, 30, 30));

        prevPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        prevPost.setBorderPainted(false);
        prevPost.setContentAreaFilled(false);
        prevPost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prevPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevPostActionPerformed(evt);
            }
        });
        getContentPane().add(prevPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 30, 30));

        prevUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/atras-rapido.png"))); // NOI18N
        prevUser.setBorderPainted(false);
        prevUser.setContentAreaFilled(false);
        prevUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prevUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevUserActionPerformed(evt);
            }
        });
        getContentPane().add(prevUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 40, 50));

        nextUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avance-rapido.png"))); // NOI18N
        nextUser.setBorderPainted(false);
        nextUser.setContentAreaFilled(false);
        nextUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextUserActionPerformed(evt);
            }
        });
        getContentPane().add(nextUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 40, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.paintTree(a);
        this.currentPost = null;
        this.currentUser = null;
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nextPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPostActionPerformed
    if (this.currentPost == null) {
        if (this.currentUser == null) {
                JOptionPane.showMessageDialog(this, "Usted aun no ha escogido un usuario");
            } else {
                this.currentPost = this.currentUser.getPostPtr();
                SpecificTree(this.currentPost);
            }
        } else {
            if (currentPost.getLink() != null) {
                currentPost = currentPost.getLink();
                SpecificTree(this.currentPost);
            }
        }
    }//GEN-LAST:event_nextPostActionPerformed

    private void prevPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevPostActionPerformed
    if (this.currentUser == null) {
            JOptionPane.showMessageDialog(this, "Usted aun no ha escogido un usuario");
        }else{
            if (this.currentPost == null) {
                JOptionPane.showMessageDialog(this, "Usted aun no ha escogido un Post");
            }else{
                if (this.currentPost != this.currentUser.getPostPtr()) {
                    this.currentPost = buscarPublicacionAnterior(this.currentPost, this.currentUser);
                    SpecificTree(this.currentPost);
                }
            }
        }
    }//GEN-LAST:event_prevPostActionPerformed

    private void nextUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextUserActionPerformed
        if (this.currentUser == null) {
            this.currentUser = a.Raiz.usuario;
            SpecificTree(this.currentUser);
        } else {
            if (currentUser.getLink() != null) {
                currentUser = currentUser.getLink();
                SpecificTree(this.currentUser);
            }
        }
        this.currentPost = null;
    }//GEN-LAST:event_nextUserActionPerformed

    private void prevUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevUserActionPerformed
         if (this.currentUser == null) {
            JOptionPane.showMessageDialog(this, "Usted no sea tan imbecil, hunda esa vaina palante");
        } else {
            if (currentUser != a.Raiz.usuario) {
                this.currentUser = buscarUsuarioAnterior(this.currentUser);
                SpecificTree(this.currentUser);
            }
        }
        this.currentPost = null;
    }//GEN-LAST:event_prevUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton nextPost;
    private javax.swing.JButton nextUser;
    private javax.swing.JPanel panel;
    private javax.swing.JButton prevPost;
    private javax.swing.JButton prevUser;
    // End of variables declaration//GEN-END:variables

    public void setA(Arbol a) {
        this.a = a;
    }
    /**
     * Este método se encarga de dibujar el árbol, de acuerdo a las dimensiones del frame que creamos
     * @param tree Recibe el arbol que se debe dibujar
     */
    public void paintTree(Arbol tree) {
        panel.setOpaque(false);
        int width = panel.getWidth();
        int height = panel.getHeight() + 139;
        g.clearRect(0, 0, width, height);
        System.out.println(width + " " + height);
        g.setColor(gris);
        g.drawOval(width / 2, 70, r, r);
        g.fillOval(width / 2, 70, r, r);
        Usuario u = a.Raiz.usuario;
        int i = 0;
        float k = 0;
        float s = 0;
        while (u != null) {
            g.setColor(gris);
            g.drawLine(10 + (width / 2) + r / 2, 70 + r, 10 + (50 + i * (width / (a.userSize()))) + r / 2, 70 + eV);
            g.drawImage(user, 10 + 50 + i * (width / (a.userSize())), 70 + eV, r, r, null);
            Publicacion p = u.getPostPtr();
            while (p != null) {
                g.setColor(azul);
                g.drawLine((10 + (50 + i * (width / (a.userSize()))) + r / 2), 70 + eV + r, (int) (10 + (k * (width / a.totalPostSize()) + (r - 15) / 2)), 70 + 2 * eV);
                g.drawImage(post, (int) (10 + k * (width / (a.totalPostSize()))), 70 + 2 * eV, r - 15, r - 15, null);
                
                Comentario c = p.getComentarioPtr();
                while (c != null) {
                    
                    int x1 = (int) (10 + s * (width / a.totalCommentSize()));
                    int y1 = 70 + 4 * eV;
                    int x2 = (int) (10 + (k * (width / (a.totalPostSize())) + (r - 15) / 2));
                    int y2 = 70 + 2 * eV;
                    int R = 2;
                    g.setColor(new Color(255,195,24));
                    g.drawImage(comment, x1, y1, 2, 2, null);
                    g.drawLine(x2, y2 + r - 15, x1 + R / 2, y1);
                    s++;
                    c = c.getLink();
                }
                s += 1.25;
                k++;
                p = p.getLink();
            }
            k += 0.5;
            i++;
            u = u.getLink();
        }
    }
    /**
     * Se encarga de ver cual es la instancia del nodo, para dibujar el subárbol deseado
     * @param raiz Recibe el nodo con el subárbol que se debe dibujar
     */
    public void SpecificTree(Nodo raiz) {
        if (raiz instanceof Usuario) {
            PaintSpecificTree((Usuario) raiz);
        } else {
            PaintSpecificTree((Publicacion) raiz);
        }
    }
    /**
     * Dibuja el subárbol del usuario con sus posts
     * @param u Recibe el nodo raiz (Usuario)
     */
    public void PaintSpecificTree(Usuario u) {
        panel.setOpaque(false);
        int width = panel.getWidth();
        int height = panel.getHeight() + 139;
        g.clearRect(0, 0, width, height);
        g.drawImage(user, width / 2, 70, r, r, null);
        int newWidth = width / (u.postSize() + 1);
        Publicacion p = u.getPostPtr();
        int j = 1;
        int k = 1;
        while (p != null) {
            g.setColor(azul);
            g.setFont(font);
            g.drawString("Se está mostrando el arbol del usuario: " + this.currentUser.getUsername(), (width / 2) - 100, 30);
            g.setColor(azul);
            g.drawLine(10 + (width / 2), 70 + r - 5, 10 + j * newWidth + (r - 5) / 4, 50 + eV);
            g.drawImage(post, j * newWidth, 50 + eV, r - 5, r - 5, null);
            Comentario c = p.getComentarioPtr();
            g.setColor(new Color(40,133,146));
            while (c != null) {
                int newWidth2 = width / (u.totalCommentSize() + 9);
                g.drawImage(comment, k * newWidth2, 50 + 2 * eV, r / 2, r / 2, null);
                g.drawLine(j * newWidth + (r - 5) / 2, 50 + eV + (r - 5), k * newWidth2 + r / 4, 50 + 2 * eV);
                c = c.getLink();
                k++;
            }
            p = p.getLink();
            k++;
            j++;
        }
    }
    /**
     * Dibuja el subárbol del post con sus comentarios
     * @param p Recibe el nodo raiz (Publicacion)
     */
    public void PaintSpecificTree(Publicacion p) {
        panel.setOpaque(false);
        int width = panel.getWidth();
        int height = panel.getHeight() + 139;
        g.clearRect(0, 0, width, height);
        g.drawImage(post, width / 2, 70, r * 2, r * 2, null);
        g.setColor(azul);
        g.setFont(fontte);
        g.drawString("Se está mostrando el arbol del post: " + this.currentPost.getId() + " cuyo titulo es:", 20, 30);
        g.drawString(this.currentPost.getTitle(), 20, 50);
        int newWidth = width / (p.commentsSize() + 1);
        Comentario c = p.getComentarioPtr();
        int k = 1;
        while (c != null) {
            g.drawImage(comment, k * newWidth, 50 + 2 * eV, r, r, null);
            g.drawLine(width / 2 + r, 70 + 2 * r, k * newWidth + r / 2, 50 + 2 * eV);
            c = c.getLink();
            k++;
        }
    }
    /**
     * Se encarga de buscar el usuario anterior a donde se encuentra actualmente
     * @param currentUser Recibe la ubicación del usuario en la lista
     * @return u que es el usuario anterior a donde se encuentra anteriormente
     */
    private Usuario buscarUsuarioAnterior(Usuario currentUser) {
        Usuario u = a.Raiz.usuario;
        while (u.getLink() != currentUser) {
            u = u.getLink();
        }
        return u;
    }
    /**
     * Se encarga de buscar el post anterior a donde se encuentra actualmente
     * @param currentPost Recibe la ubicación del post actual, para encontrar el post anterior
     * @param currentUser Recibe el usuario en donde se encuentra, para saber que posts tiene este
     * @return p que es el post anterior a donde se encuentra anteriormente
     */
    private Publicacion buscarPublicacionAnterior(Publicacion currentPost, Usuario currentUser) {
        Publicacion p = currentUser.getPostPtr();
        while (p.getLink() != currentPost) {
            p = p.getLink();
        }
        return p;
    }
    
}
