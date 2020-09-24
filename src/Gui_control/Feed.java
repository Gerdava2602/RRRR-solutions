
package Gui_control;

import Atributos.Lista;
import Nodos.Arbol;
import Nodos.Comentario;
import Nodos.Publicacion;
import Nodos.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Cursor;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * La clase Feed, es un JFrame que se encarga de mostrar todos los posts, hechos por los usuarios.
 * Para ello, hicimos que se autogenere el código que crea los paneles que muestran la información.
 */
public class Feed extends javax.swing.JFrame {
    ArbolPanel panel;
    Arbol a;
    Blog b;
    JScrollPane scrollPaneBlog, scrollPanePost,scrollPaneUser,actualScrollPane;
    JPanel columnpane;
    Lista states;
    int actualState;
    static infoPage tutor;
    final int blogState = 1, postState = 2, userState = 3;
    Font font = new Font("Dubai Light", Font.BOLD, 18);
    Font fontComment = new Font("Dubai Light", Font.BOLD, 12);
    Font fontTitle = new Font("Dubai", Font.BOLD, 15);
    Color Blanco = new Color(251,255,241);
    //Thread t;
    /**
     * Crea el feed donde se encuentran todos los posts hechos por los usuarios.
     * @param a Recibe el árbol generado por los documentos que sube el usuario 
     * @param b Sirve para crear paneles, con propiedades específicas hechas por nosotros
     * @throws java.io.IOException
     */
    public Feed(Arbol a, Blog b) throws IOException {
        initComponents();
        this.setTitle("Feed");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.a = a;
        this.b = b;
        scrollPaneBlog = new JScrollPane();
        scrollPanePost = new JScrollPane();
        scrollPaneUser = new JScrollPane();
        actualScrollPane = scrollPaneBlog;
        states = new Lista(1);
        actualState = 1;
        initializaBlog();
    }
    /**
     * Se encarga de crear el ScrollPanel en el que el usuario podrá movilizarse.
     * @throws IOException 
     */
    public void initializaBlog() throws IOException{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        scrollPaneBlog.setBounds(50, 40, 900, this.getHeight()-30);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPaneBlog);

        JPanel borderlaoutpanel = new JPanel();
        scrollPaneBlog.setViewportView(borderlaoutpanel);
        borderlaoutpanel.setLayout(new GridLayout(0,1,0,1));
        borderlaoutpanel.setBackground(Color.RED);

        JPanel columnpanel = new JPanel();
        borderlaoutpanel.add(columnpanel);
        columnpanel.setLayout(new BoxLayout(columnpanel, BoxLayout.Y_AXIS));
        columnpanel.setBackground(Color.gray);

        Lista posts = a.getAllPosts();
        posts = posts.getLink();
        while(posts!=null){
            createPost(columnpanel, posts);
            posts = posts.getLink();
        }
    }
    /**
     * Se encarga de poner la información de los posts en el feed
     * @param columnpanel Es un JPanel que se utiliza para ubicar la información
     * @param posts Son los posts que fueron subidos por el usuario
     * @throws IOException 
     */
    public void createPost(JPanel columnpanel, Lista posts) throws IOException{
        ImagePanel rowPanel = new ImagePanel(ImageIO.read(getClass().getResource("/Images/post.png")));
            rowPanel.setPreferredSize(new Dimension(800,400)); 
            rowPanel.setOpaque(false);
            columnpanel.add(rowPanel);
            Publicacion post = (Publicacion) posts.getData();
            //rowPanel.setBackground(Color.yellow);
            rowPanel.setLayout(null);
            
            //Title button
            JButton title = new JButton(post.getTitle());
            title.setBorderPainted(false); 
            title.setContentAreaFilled(false); 
            title.setFocusPainted(false); 
            title.setOpaque(false);
            title.setForeground(new Color(255,195,24));
            title.setFont(font);
            title.setBounds(120, 30, 620, 50);
            title.setHorizontalTextPosition(SwingConstants.CENTER);
            rowPanel.add(title);
            
            //User button
            Usuario u = a.encontrarUsuario(a.getUserPtr(), post.getUserId());
            JButton user = new JButton(u.getName());
            user.setBorderPainted(false); 
            user.setContentAreaFilled(false); 
            user.setFocusPainted(false); 
            user.setOpaque(false);
            user.setBounds(580, 340, 160, 30);
            user.setForeground(new Color(255,195,24));
            Font fontUser = new Font("Dubai", Font.BOLD, 12);
            user.setFont(fontUser);
            user.setHorizontalTextPosition(SwingConstants.LEFT);
            rowPanel.add(user);
            
            //Body text
            JTextArea body = new JTextArea();
            body.setOpaque(false);
            body.setBorder(null);
            body.setBackground(new Color(0,0,0,0));
            body.setLineWrap(true);
            body.setEditable(false);
            body.setForeground(new Color(251,255,241));
            body.setBounds(220, 100, 420, 200);
            body.setFont(font);
            body.setText(post.getBody());
            rowPanel.add(body);
            
            ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    createPostInside(post);
                    scrollPaneBlog.setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(Blog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
            title.addActionListener(al);
            
            //JSeparator separator = new JSeparator();
            //columnpanel.add(separator);
    }
    /**
     * Se asignan las propiedades del texto del post, que se muestra en el feed
     * @param post Recibe los post en particular, para darle las propiedades con las que saldrá en el feed
     * @throws IOException 
     */
    private void createPostInside(Publicacion post) throws IOException{
        scrollPanePost = new JScrollPane();
        states.add(2);
        actualScrollPane = scrollPanePost;
        //scrollPanePost.setOpaque(false);
        scrollPanePost.setBounds(50, 0, 900, this.getHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPanePost);
        scrollPanePost.setVisible(true);

        JPanel columnpanel = new JPanel();
        scrollPanePost.setViewportView(columnpanel);
        columnpanel.setLayout(null);
        columnpanel.setBackground(new Color(255,195,24));
        
        
        ImagePanel blog = new ImagePanel(ImageIO.read(getClass().getResource("/Images/FondofeedUsuario.png")),17,46);
        //blog.setPreferredSize(new Dimension(200, 400)); 
        blog.setBackground(Color.blue);
        blog.setBounds(0, 0, scrollPanePost.getWidth(), scrollPanePost.getHeight());
        blog.setOpaque(false);
        blog.setVisible(true);
        blog.setLayout(null);
        columnpanel.add(blog);
        /**
         * Feed del Usuario
         */
        JButton title = new JButton(post.getTitle()); 
        title.setForeground(new Color(255,195,24));
        title.setBorderPainted(false); 
        title.setContentAreaFilled(false); 
        title.setFocusPainted(false); 
        title.setOpaque(false);
        title.setBounds(40, 90, 600, 50);
        title.setFont(fontTitle);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(title);
        
        JTextArea body = new JTextArea();
            body.setLineWrap(true);
            body.setForeground(new Color(251,255,241));
            body.setBounds(40, 135, 600, 165);
            body.setFont(fontTitle);
            body.setText(post.getBody());
            body.setBackground(new Color(0,0,0,0));
            body.setBorder(null);
            body.setEditable(false);
            blog.add(body);
        //624x145
        
        Usuario user = a.encontrarUsuario(a.getUserPtr(), post.getUserId());
        JButton userName = new JButton(user.getUsername()); 
            userName.setForeground(Blanco);
            userName.setBorderPainted(false); 
            userName.setContentAreaFilled(false); 
            userName.setFocusPainted(false); 
            userName.setOpaque(false);
            userName.setBounds(730, 155, 150, 30);
            userName.setFont(fontComment);
            userName.setHorizontalTextPosition(SwingConstants.CENTER);  
            blog.add(userName);
         JLabel city = new JLabel(user.getDireccion().getCity()); 
            city.setForeground(Blanco);
            city.setOpaque(false);
            city.setFont(fontComment);
            city.setBounds(680, 220, 200, 30);
            city.setHorizontalTextPosition(SwingConstants.CENTER);  
            blog.add(city);
         JLabel phone = new JLabel(user.getPhone()); 
            phone.setForeground(Color.white);
            phone.setOpaque(false);
            phone.setFont(fontComment);
            phone.setBounds(680, 265, 200, 30);
            phone.setHorizontalTextPosition(SwingConstants.CENTER);  
            blog.add(phone);
         JLabel email = new JLabel(user.getEmail()); 
            email.setForeground(Blanco);
            email.setOpaque(false);
            email.setFont(fontComment);
            email.setBounds(680, 310, 200, 30);
            email.setHorizontalTextPosition(SwingConstants.CENTER);  
            blog.add(email);
         JLabel name = new JLabel(user.getName()); 
            name.setForeground(Blanco);
            name.setOpaque(false);
            name.setFont(fontComment);
            name.setBounds(680, 355, 200, 30);
            name.setHorizontalTextPosition(SwingConstants.CENTER);  
            blog.add(name);
         JLabel web = new JLabel(user.getWebsite()); 
            web.setForeground(Blanco);
            web.setOpaque(false);
            web.setFont(fontComment);
            web.setBounds(680, 400, 200, 30);
            web.setHorizontalTextPosition(SwingConstants.CENTER);  
            blog.add(web);
         JLabel companame = new JLabel(user.getCompany().getName()); 
            companame.setForeground(Blanco);
            companame.setOpaque(false);
            companame.setFont(fontComment);
            companame.setBounds(680, 490, 200, 30);
            companame.setHorizontalTextPosition(SwingConstants.CENTER);  
            blog.add(companame);
         JLabel compaphrase = new JLabel(user.getCompany().getCatchPhrase());
            compaphrase.setForeground(Blanco);
            compaphrase.setOpaque(false);
            compaphrase.setFont(fontComment);
            compaphrase.setBounds(680, 535, 200, 30);
            compaphrase.setHorizontalTextPosition(SwingConstants.CENTER);  
            blog.add(compaphrase);
            
        //Comments    
            JScrollPane commentPane = new JScrollPane();
            commentPane.setBackground(new Color(255,195,24));
            blog.add(commentPane);
            commentPane.setBounds(30, 337, 624, 215);
            commentPane.getViewport().setBackground(new Color(0,0,0,0));
            commentPane.setBorder(null);
            
            JPanel column = new JPanel();
            commentPane.setViewportView(column);
            column.setLayout(new BoxLayout(column,BoxLayout.Y_AXIS));
            column.setBackground(new Color(255,195,24));
            //blog.add(column);
            
            Comentario comments = post.getComentarioPtr();
            while(comments != null){
                createComments(column, comments);
                comments = comments.getLink();
            }
            
    }
    /**
     * Se encarga de crear el ScrollPanel en el que el usuario podrá movilizarse.
     * Tambien le asigna las propiedades de texto de los comentarios.
     * @param column JPanel en donde se ubicará la información
     * @param c El comentario del respectivo post
     * @throws IOException 
     */
    private void createComments(JPanel column, Comentario c) throws IOException{
        ImagePanel comentario = new ImagePanel(ImageIO.read(getClass().getResource("/Images/comment.png")),0,0);
                comentario.setOpaque(false);
                comentario.setLayout(null);
                comentario.setPreferredSize(new Dimension(comentario.width,230)); 
                column.add(comentario);
                //TextArea de los comentarios
                JLabel email = new JLabel(c.getEmail());
                email.setForeground(new Color(251,255,241));
                email.setOpaque(false);
                email.setBounds(80, 10, 180, 30);
                email.setHorizontalTextPosition(SwingConstants.LEFT);
                email.setFont(fontTitle);
                comentario.add(email);
                
                JLabel name = new JLabel(c.getName());
                name.setForeground(new Color(251,255,241));
                name.setOpaque(false);
                name.setBounds(280, 10, 320, 30);
                name.setHorizontalTextPosition(SwingConstants.LEFT);
                name.setFont(fontTitle);
                comentario.add(name);
                
                //590x157
                JTextArea body = new JTextArea();
                body.setLineWrap(true);
                body.setOpaque(false);
                body.setBackground(new Color(0,0,0,0));
                body.setBorder(null);
                body.setEditable(false);               
                body.setBounds(10, 55, 570, 150);
                body.setFont(font);
                body.setText(c.getBody());
                comentario.add(body);
    }
    
    private void createUserPage(Usuario user){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atras = new javax.swing.JButton();
        buscarUsuario = new javax.swing.JButton();
        buscarPosts = new javax.swing.JButton();
        tutorial = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/atrasFeed.png"))); // NOI18N
        atras.setBorder(null);
        atras.setBorderPainted(false);
        atras.setContentAreaFilled(false);
        atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        getContentPane().add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        buscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscarUsuarios.png"))); // NOI18N
        buscarUsuario.setBorder(null);
        buscarUsuario.setBorderPainted(false);
        buscarUsuario.setContentAreaFilled(false);
        buscarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(buscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 70, 70));

        buscarPosts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscarPublicacion.png"))); // NOI18N
        buscarPosts.setBorder(null);
        buscarPosts.setBorderPainted(false);
        buscarPosts.setContentAreaFilled(false);
        buscarPosts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscarPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPostsActionPerformed(evt);
            }
        });
        getContentPane().add(buscarPosts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 80, 70));

        tutorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tutAmarillo.png"))); // NOI18N
        tutorial.setBorder(null);
        tutorial.setBorderPainted(false);
        tutorial.setContentAreaFilled(false);
        tutorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialActionPerformed(evt);
            }
        });
        getContentPane().add(tutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 70, 50));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondoFeed.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Este el botón para regresar a la ventana anterior
     * @param evt 
     */
    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        int anterior =(int)states.retroceder(actualState, states);
        switch(anterior){
            case blogState:
                actualState = 1;
                actualScrollPane.setVisible(false);
                actualScrollPane = scrollPaneBlog;
                actualScrollPane.setVisible(true);
                break;
            case 0:
                this.dispose();
                b.setVisible(true);
                break;
        }
    }//GEN-LAST:event_atrasActionPerformed

    private void buscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarUsuarioActionPerformed

    private void buscarPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPostsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarPostsActionPerformed

    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        tutor.setVisible(true);
        tutor.run();
        this.setVisible(false);
    }//GEN-LAST:event_tutorialActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton atras;
    private javax.swing.JButton buscarPosts;
    private javax.swing.JButton buscarUsuario;
    private javax.swing.JButton tutorial;
    // End of variables declaration//GEN-END:variables

    private void onlyVisible() {
        scrollPaneBlog.setVisible(false);
        scrollPanePost.setVisible(false);
        scrollPaneUser.setVisible(false);
    }    
}
