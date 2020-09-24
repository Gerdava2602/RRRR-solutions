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
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author German David
 */
public class Feed extends javax.swing.JFrame {

    ArbolPanel panel;
    Arbol a;
    Blog b;
    JScrollPane scrollPaneBlog, scrollPanePost, scrollPaneUser, scrollPaneBuscador, actualScrollPane;
    JPanel columnpane;
    boolean buscandoU = false, buscandoP = false;
    //int actualState;
    final int blogState = 1, postState = 2, userState = 3;

    //Thread t;
    /**
     * Creates new form Blog
     *
     * @param a
     * @param b
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
        scrollPaneBuscador = new JScrollPane();
        actualScrollPane = scrollPaneBlog;
        browseField.setVisible(false);
        browse.setVisible(false);
        //states = new Lista(blogState);
        //actualState = 1;
        initializaBlog();
    }

    public void initializaBlog() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        //actualState = blogState;
        //states.add(blogState);
        actualScrollPane = scrollPaneBlog;
        scrollPaneBlog.setBounds(50, 40, 900, this.getHeight() - 30);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPaneBlog);

        JPanel borderlaoutpanel = new JPanel();
        scrollPaneBlog.setViewportView(borderlaoutpanel);
        borderlaoutpanel.setLayout(new GridLayout(0, 1, 0, 1));
        borderlaoutpanel.setBackground(Color.RED);

        JPanel columnpanel = new JPanel();
        borderlaoutpanel.add(columnpanel);
        columnpanel.setLayout(new BoxLayout(columnpanel, BoxLayout.Y_AXIS));
        columnpanel.setBackground(Color.gray);

        Lista posts = a.getAllPosts();
        posts = posts.getLink();
        while (posts != null) {
            createPost(columnpanel, posts);
            posts = posts.getLink();
        }
    }

    //Creates a post for the blog
    public void createPost(JPanel columnpanel, Lista posts) throws IOException {
        ImagePanel rowPanel = new ImagePanel(ImageIO.read(getClass().getResource("/Images/post.png")));
        rowPanel.setPreferredSize(new Dimension(800, 400));
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
        user.setHorizontalTextPosition(SwingConstants.LEFT);
        rowPanel.add(user);

        //Body text
        JTextArea body = new JTextArea();
        body.setLineWrap(true);
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        body.setBounds(220, 100, 420, 200);
        body.setFont(font);
        body.setText(post.getBody());
        rowPanel.add(body);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    browseField.setVisible(false);
                    browse.setVisible(false);
                    actualScrollPane.setVisible(false);
                    createPostInside(post);

                } catch (IOException ex) {
                    Logger.getLogger(Blog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        title.addActionListener(al);

        //JSeparator separator = new JSeparator();
        //columnpanel.add(separator);
    }

    private void createPostInside(Publicacion post) throws IOException {
        scrollPanePost = new JScrollPane();
        //states.add(postState);
        //actualState = postState;
        actualScrollPane = scrollPanePost;
        scrollPanePost.setBounds(50, 0, 900, this.getHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPanePost);
        scrollPanePost.setVisible(true);

        JPanel columnpanel = new JPanel();
        scrollPanePost.setViewportView(columnpanel);
        columnpanel.setLayout(null);
        columnpanel.setBackground(Color.yellow);

        ImagePanel blog = new ImagePanel(ImageIO.read(getClass().getResource("/Images/FondofeedUsuario.png")), 17, 46);
        //blog.setPreferredSize(new Dimension(200, 400)); 
        blog.setBackground(Color.blue);
        blog.setBounds(0, 0, scrollPanePost.getWidth(), scrollPanePost.getHeight());
        blog.setOpaque(false);
        blog.setVisible(true);
        blog.setLayout(null);
        columnpanel.add(blog);

        JButton title = new JButton(post.getTitle());
        title.setBorderPainted(false);
        title.setContentAreaFilled(false);
        title.setFocusPainted(false);
        title.setOpaque(false);
        title.setBounds(40, 90, 600, 50);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(title);

        JTextArea body = new JTextArea();
        body.setLineWrap(true);
        Font font = new Font("Times New Roman", Font.BOLD, 16);
        body.setBounds(40, 135, 600, 165);
        body.setFont(font);
        body.setText(post.getBody());
        body.setBackground(new Color(0, 0, 0, 0));
        body.setBorder(null);
        body.setEditable(false);
        blog.add(body);
        //624x145
        Usuario user = a.encontrarUsuario(a.getUserPtr(), post.getUserId());
        JButton userName = new JButton(user.getUsername());
        //userName.setBorderPainted(false); 
        //userName.setContentAreaFilled(false); 
        //userName.setFocusPainted(false); 
        userName.setOpaque(false);
        userName.setBounds(730, 155, 150, 30);
        userName.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(userName);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    actualScrollPane.setVisible(false);
                    browseField.setVisible(false);
                    browse.setVisible(false);
                    createUserPage(user);

                } catch (IOException ex) {
                    Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        userName.addActionListener(al);
        JLabel city = new JLabel(user.getDireccion().getCity());
        city.setOpaque(false);
        city.setBounds(680, 220, 200, 30);
        city.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(city);
        JLabel phone = new JLabel(user.getPhone());
        phone.setOpaque(false);
        phone.setBounds(680, 265, 200, 30);
        phone.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(phone);
        JLabel email = new JLabel(user.getEmail());
        email.setOpaque(false);
        email.setBounds(680, 310, 200, 30);
        email.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(email);
        JLabel name = new JLabel(user.getName());
        name.setOpaque(false);
        name.setBounds(680, 355, 200, 30);
        name.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(name);
        JLabel web = new JLabel(user.getWebsite());
        web.setOpaque(false);
        web.setBounds(680, 400, 200, 30);
        web.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(web);
        JLabel companame = new JLabel(user.getCompany().getName());
        companame.setOpaque(false);
        companame.setBounds(680, 490, 200, 30);
        companame.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(companame);
        JLabel compaphrase = new JLabel(user.getCompany().getCatchPhrase());
        compaphrase.setOpaque(false);
        compaphrase.setBounds(680, 535, 200, 30);
        compaphrase.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(compaphrase);

        //Comments    
        JScrollPane commentPane = new JScrollPane();
        commentPane.setBackground(Color.yellow);
        blog.add(commentPane);
        commentPane.setBounds(30, 337, 624, 215);
        commentPane.getViewport().setBackground(new Color(0, 0, 0, 0));
        commentPane.setBorder(null);

        JPanel column = new JPanel();
        commentPane.setViewportView(column);
        column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
        column.setBackground(Color.yellow);
        //blog.add(column);

        Comentario comments = post.getComentarioPtr();
        while (comments != null) {
            createComments(column, comments);
            comments = comments.getLink();
        }

    }

    private void createComments(JPanel column, Comentario c) throws IOException {
        ImagePanel comentario = new ImagePanel(ImageIO.read(getClass().getResource("/Images/comment.png")), 0, 0);
        comentario.setOpaque(false);
        comentario.setLayout(null);
        comentario.setPreferredSize(new Dimension(comentario.width, 230));
        column.add(comentario);

        JLabel email = new JLabel(c.getEmail());
        email.setOpaque(false);
        email.setBounds(80, 10, 180, 30);
        email.setHorizontalTextPosition(SwingConstants.LEFT);
        comentario.add(email);

        JLabel name = new JLabel(c.getName());
        name.setOpaque(false);
        name.setBounds(280, 10, 320, 30);
        name.setHorizontalTextPosition(SwingConstants.LEFT);
        comentario.add(name);

        //590x157
        JTextArea body = new JTextArea();
        body.setLineWrap(true);
        body.setOpaque(false);
        body.setBackground(new Color(0, 0, 0, 0));
        body.setBorder(null);
        body.setEditable(false);
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        body.setBounds(10, 55, 570, 150);
        body.setFont(font);
        body.setText(c.getBody());
        comentario.add(body);
    }

    private void createUserPage(Usuario user) throws IOException {
        scrollPaneUser = new JScrollPane();
        //states.add(userState);
        //actualState = userState;
        actualScrollPane = scrollPaneUser;
        scrollPaneUser.setBounds(50, 0, 900, this.getHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPaneUser);
        scrollPaneUser.setVisible(true);

        JPanel columnpanel = new JPanel();
        scrollPaneUser.setViewportView(columnpanel);
        columnpanel.setLayout(null);
        columnpanel.setBackground(Color.yellow);

        ImagePanel blog = new ImagePanel(ImageIO.read(getClass().getResource("/Images/FondoUsuario.png")), 17, 46);
        //blog.setPreferredSize(new Dimension(200, 400)); 
        blog.setBackground(Color.blue);
        blog.setBounds(0, 0, scrollPaneUser.getWidth(), scrollPaneUser.getHeight());
        blog.setOpaque(false);
        blog.setVisible(true);
        blog.setLayout(null);
        columnpanel.add(blog);

        JLabel title = new JLabel(user.getName());
        title.setOpaque(false);
        title.setBounds(40, 90, 600, 50);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(title);

        //624x145
        JButton userName = new JButton(user.getUsername());
        userName.setBorderPainted(false);
        userName.setContentAreaFilled(false);
        userName.setFocusPainted(false);
        userName.setOpaque(false);
        userName.setBounds(730, 155, 150, 30);
        userName.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(userName);
        JLabel city = new JLabel(user.getDireccion().getCity());
        city.setOpaque(false);
        city.setBounds(680, 220, 200, 30);
        city.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(city);
        JLabel phone = new JLabel(user.getPhone());
        phone.setOpaque(false);
        phone.setBounds(680, 265, 200, 30);
        phone.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(phone);
        JLabel email = new JLabel(user.getEmail());
        email.setOpaque(false);
        email.setBounds(680, 310, 200, 30);
        email.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(email);
        JLabel name = new JLabel(user.getName());
        name.setOpaque(false);
        name.setBounds(680, 355, 200, 30);
        name.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(name);
        JLabel web = new JLabel(user.getWebsite());
        web.setOpaque(false);
        web.setBounds(680, 400, 200, 30);
        web.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(web);
        JLabel companame = new JLabel(user.getCompany().getName());
        companame.setOpaque(false);
        companame.setBounds(680, 490, 200, 30);
        companame.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(companame);
        JLabel compaphrase = new JLabel(user.getCompany().getCatchPhrase());
        compaphrase.setOpaque(false);
        compaphrase.setBounds(680, 535, 200, 30);
        compaphrase.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(compaphrase);

        //Posts
        JScrollPane commentPane = new JScrollPane();
        commentPane.setBackground(Color.yellow);
        blog.add(commentPane);
        commentPane.setBounds(430, 50, 470, 538);
        commentPane.getViewport().setBackground(new Color(0, 0, 0, 0));
        commentPane.setBorder(null);

        JPanel column = new JPanel();
        commentPane.setViewportView(column);
        column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
        column.setBackground(Color.yellow);
        //blog.add(column);

        Publicacion post = user.getPostPtr();
        while (post != null) {
            createPost(column, user.getPosts());
            post = post.getLink();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atras = new javax.swing.JButton();
        buscarUsuario = new javax.swing.JButton();
        buscarPosts = new javax.swing.JButton();
        browse = new javax.swing.JButton();
        browseField = new javax.swing.JTextField();
        Fondo = new javax.swing.JLabel();
        tutorial = new javax.swing.JButton();

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
        getContentPane().add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, -1));

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
        getContentPane().add(buscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

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
        getContentPane().add(buscarPosts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 60, -1));

        browse.setText("Buscar");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        getContentPane().add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        browseField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseFieldActionPerformed(evt);
            }
        });
        getContentPane().add(browseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 700, 30));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondoFeed.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        getContentPane().add(tutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 70, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        /*
        int anterior =(int)states.retroceder(actualState, states);
        switch(anterior){
            case blogState:
                actualState = 1;
                actualScrollPane.setVisible(false);
                actualScrollPane = scrollPaneBlog;
                actualScrollPane.setVisible(true);
                break;
            case postState:
                actualState = postState;
                actualScrollPane.setVisible(false);
                actualScrollPane = scrollPanePost;
                actualScrollPane.setVisible(true);
                break;
            case 0:
                setVisible(false);
                b.setVisible(true);
                break;
        }
         */
        if (actualScrollPane != scrollPaneBlog) {
            actualScrollPane.setVisible(false);
            scrollPaneBlog.setVisible(true);
            actualScrollPane = scrollPaneBlog;
        } else {
            setVisible(false);
            b.setVisible(true);
        }
    }//GEN-LAST:event_atrasActionPerformed

    private void buscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarUsuarioActionPerformed
        if (actualScrollPane == scrollPaneBlog) {
            if (!browseField.isVisible()) {
                browseField.setVisible(true);
                browse.setVisible(true);
            } else {
                browseField.setVisible(false);
                browse.setVisible(false);
            }
            if (buscandoP == true) {
                buscandoP = false;
                buscandoU = true;
            } else {
                buscandoU = true;
            }
        }
    }//GEN-LAST:event_buscarUsuarioActionPerformed

    private void buscarPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPostsActionPerformed
        if (actualScrollPane == scrollPaneBlog) {
            if (!browseField.isVisible()) {
                browseField.setVisible(true);
                browse.setVisible(true);
            } else {
                browseField.setVisible(false);
                browse.setVisible(false);
            }

            if (buscandoU == true) {
                buscandoU = false;
                buscandoP = true;
            } else {
                buscandoP = true;
            }
        }
    }//GEN-LAST:event_buscarPostsActionPerformed

    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_tutorialActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        onlyVisible();
        //scrollPaneBuscador.removeAll();
        scrollPaneBuscador.setVisible(false);
        scrollPaneBuscador = new JScrollPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        //actualState = blogState;
        //states.add(blogState);
        actualScrollPane = scrollPaneBuscador;
        scrollPaneBuscador.setBounds(50, 40, 900, this.getHeight() );
        scrollPaneBuscador.setVisible(true);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPaneBuscador);

        JPanel borderlaoutpanel = new JPanel();
        scrollPaneBuscador.setViewportView(borderlaoutpanel);
        borderlaoutpanel.setLayout(new GridLayout(0, 1, 0, 1));
        borderlaoutpanel.setBackground(Color.RED);

        JPanel columnpanel = new JPanel();
        borderlaoutpanel.add(columnpanel);
        columnpanel.setLayout(new BoxLayout(columnpanel, BoxLayout.Y_AXIS));
        columnpanel.setBackground(Color.gray);

        if (buscandoU) {
            Lista encontrados = a.encontrarUsuarios(browseField.getText());
            if (encontrados.getData() != null) {
                while (encontrados != null) {
                    try {
                        createPost(columnpanel, encontrados);
                    } catch (IOException ex) {
                        Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    encontrados = encontrados.getLink();
                }
            }
        } else if (buscandoP) {
            Lista encontrados = a.encontrarPosts(browseField.getText());
            if (encontrados.getData() != null) {
                while (encontrados != null) {
                    try {
                        createPost(columnpanel, encontrados);
                    } catch (IOException ex) {
                        Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    encontrados = encontrados.getLink();

                }
            }
        }
    }//GEN-LAST:event_browseActionPerformed

    private void browseFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_browseFieldActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton atras;
    private javax.swing.JButton browse;
    private javax.swing.JTextField browseField;
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
