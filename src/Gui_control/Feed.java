package Gui_control;

import Atributos.Lista;
import Nodos.Arbol;
import Nodos.Comentario;
import Nodos.Publicacion;
import Nodos.Usuario;
import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * La clase Feed, es un JFrame que se encarga de mostrar todos los posts, hechos
 * por los usuarios. Para ello, hicimos que se autogenere el código que crea los
 * paneles que muestran la información.
 */
public class Feed extends javax.swing.JFrame {

    ArbolPanel panel;
    Arbol a;
    Blog b;
    JScrollPane scrollPaneBlog, scrollPanePost, scrollPaneUser, scrollPaneBuscador, actualScrollPane;
    JPanel columnpane;
    Lista states;
    int actualState;
    static infoPage tutor;
    boolean buscandoU = false, buscandoP = false;
    final int blogState = 1, postState = 2, userState = 3;
    Font font = new Font("Dubai Light", Font.BOLD, 18);
    Font fontComment = new Font("Dubai Light", Font.BOLD, 12);
    Font fontTitle = new Font("Dubai", Font.BOLD, 15);
    Color Blanco = new Color(251, 255, 241);
    Color amarillo = new Color(255, 195, 24);
    Color azul = new Color(40, 133, 146);
    Color gris = new Color(54, 57, 66);

    /**
     * Crea el feed donde se encuentran todos los posts hechos por los usuarios.
     * @param a Recibe el árbol generado por los documentos que sube el usuario
     * @param b Sirve para crear paneles, con propiedades específicas hechas por
     * nosotros
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
        tutor = new infoPage(this);
        initializaBlog();
    }

    public void initializaBlog() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        actualScrollPane = scrollPaneBlog;
        scrollPaneBlog.setBounds(50, 57, 900, this.getHeight() - 45);
        getContentPane().add(scrollPaneBlog);
        JPanel borderlaoutpanel = new JPanel();
        scrollPaneBlog.setViewportView(borderlaoutpanel);
        borderlaoutpanel.setLayout(new GridLayout(0, 1, 0, 1));
        JPanel columnpanel = new JPanel();
        borderlaoutpanel.add(columnpanel);
        columnpanel.setLayout(new BoxLayout(columnpanel, BoxLayout.Y_AXIS));
        columnpanel.setBackground(amarillo);
        Lista posts = a.getAllPosts();
        posts = posts.getLink();
        while (posts != null) {
            createPost(columnpanel, posts);
            posts = posts.getLink();
        }
    }

    /**
     * Crea un post para el blog
     * @param columnpanel columnpanel
     * @param posts la lista de posts
     * @throws IOException 
     */
    public void createPost(JPanel columnpanel, Lista posts) throws IOException {
        ImagePanel rowPanel = new ImagePanel(ImageIO.read(getClass().getResource("/Images/post.png")));
        rowPanel.setPreferredSize(new Dimension(800, 400));
        rowPanel.setOpaque(false);
        columnpanel.add(rowPanel);
        Publicacion post = (Publicacion) posts.getData();
        rowPanel.setLayout(null);
        JButton title = new JButton(post.getTitle());
        
        //Title button
        title.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        title.setBorderPainted(false);
        title.setContentAreaFilled(false);
        title.setFocusPainted(false);
        title.setOpaque(false);
        title.setForeground(new Color(255, 195, 24));
        title.setFont(font);
        title.setBounds(120, 30, 620, 50);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(title);

        //User button
        Usuario u = a.encontrarUsuario(a.getUserPtr(), post.getUserId());
        JButton user = new JButton(u.getName());
        user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        user.setBorderPainted(false);
        user.setContentAreaFilled(false);
        user.setFocusPainted(false);
        user.setOpaque(false);
        user.setBounds(580, 340, 160, 30);
        user.setForeground(new Color(255, 195, 24));
        Font fontUser = new Font("Dubai", Font.BOLD, 12);
        user.setFont(fontUser);
        user.setHorizontalTextPosition(SwingConstants.LEFT);
        rowPanel.add(user);

        //Body text
        JTextArea body = new JTextArea();
        body.setOpaque(false);
        body.setBorder(null);
        body.setBackground(new Color(0, 0, 0, 0));
        body.setLineWrap(true);
        body.setEditable(false);
        body.setForeground(new Color(251, 255, 241));
        body.setBounds(220, 150, 420, 200);
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

    }

    private void createPostInside(Publicacion post) throws IOException {
        scrollPanePost = new JScrollPane();
        actualScrollPane = scrollPanePost;
        scrollPanePost.setBounds(50, 0, 900, this.getHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPanePost);
        scrollPanePost.setVisible(true);

        JPanel columnpanel = new JPanel();
        scrollPanePost.setViewportView(columnpanel);
        columnpanel.setLayout(null);
        columnpanel.setBackground(new Color(255, 195, 24));

        ImagePanel blog = new ImagePanel(ImageIO.read(getClass().getResource("/Images/FondofeedUsuario.png")), 17, 46);
        blog.setBackground(Color.blue);
        blog.setBounds(0, 0, scrollPanePost.getWidth(), scrollPanePost.getHeight());
        blog.setOpaque(false);
        blog.setVisible(true);
        blog.setLayout(null);
        columnpanel.add(blog);

        JButton title = new JButton(post.getTitle());
        title.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
        body.setForeground(new Color(251, 255, 241));
        body.setBounds(40, 135, 600, 165);
        body.setFont(fontTitle);
        body.setText(post.getBody());
        body.setBackground(new Color(0, 0, 0, 0));
        body.setBorder(null);
        body.setEditable(false);
        blog.add(body);
        
        Usuario user = a.encontrarUsuario(a.getUserPtr(), post.getUserId());
        JButton userName = new JButton(user.getUsername());
        userName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userName.setForeground(amarillo);
        userName.setBackground(new Color(0, 0, 0, 0));
        userName.setBorderPainted(false);
        userName.setContentAreaFilled(false);
        userName.setFocusPainted(false);
        userName.setOpaque(false);
        userName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Font boton = new Font("Dubai", Font.BOLD, 18);
        userName.setBounds(675, 155, 200, 30);
        userName.setFont(boton);
        userName.setHorizontalTextPosition(SwingConstants.LEFT);
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
        city.setForeground(Blanco);
        city.setOpaque(false);
        city.setFont(fontComment);
        city.setBounds(680, 220, 200, 30);
        city.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(city);
        JLabel phone = new JLabel(user.getPhone());
        phone.setForeground(Blanco);
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
        commentPane.setBackground(new Color(255, 195, 24));
        blog.add(commentPane);
        commentPane.setBounds(30, 337, 624, 215);
        commentPane.getViewport().setBackground(new Color(0, 0, 0, 0));
        commentPane.setBorder(null);

        JPanel column = new JPanel();
        commentPane.setViewportView(column);
        column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
        column.setBackground(new Color(255, 195, 24));
        //blog.add(column);

        Comentario comments = post.getComentarioPtr();
        while (comments != null) {
            createComments(column, comments);
            comments = comments.getLink();
        }

    }

    /**
     * Se encarga de crear el ScrollPanel en el que el usuario podrá
     * movilizarse. Tambien le asigna las propiedades de texto de los
     * comentarios.
     *
     * @param column JPanel en donde se ubicará la información
     * @param c El comentario del respectivo post
     * @throws IOException
     */
    private void createComments(JPanel column, Comentario c) throws IOException {
        ImagePanel comentario = new ImagePanel(ImageIO.read(getClass().getResource("/Images/comment.png")), 0, 0);
        comentario.setOpaque(false);
        comentario.setLayout(null);
        comentario.setPreferredSize(new Dimension(comentario.width, 230));
        column.add(comentario);

        JLabel email = new JLabel(c.getEmail());
        email.setForeground(new Color(251, 255, 241));
        email.setOpaque(false);
        email.setBounds(80, 10, 180, 30);
        email.setHorizontalTextPosition(SwingConstants.LEFT);
        comentario.add(email);

        JLabel name = new JLabel(c.getName());
        name.setForeground(new Color(251, 255, 241));
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
        body.setBounds(10, 55, 570, 150);
        body.setFont(font);
        body.setText(c.getBody());
        comentario.add(body);
    }

    private void createUserPage(Usuario user) throws IOException {
        scrollPaneUser = new JScrollPane();

        actualScrollPane = scrollPaneUser;
        scrollPaneUser.setBounds(50, 0, 900, this.getHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPaneUser);
        scrollPaneUser.setVisible(true);

        JPanel columnpanel = new JPanel();
        scrollPaneUser.setViewportView(columnpanel);
        columnpanel.setLayout(null);
        columnpanel.setBackground(amarillo);
        
        ImagePanel blog = new ImagePanel(ImageIO.read(getClass().getResource("/Images/fondoUsuario.png")), 20, 56);
        blog.setBackground(Color.blue);
        blog.setBounds(0, 0, scrollPaneUser.getWidth(), scrollPaneUser.getHeight());
        blog.setOpaque(false);
        blog.setVisible(true);
        blog.setLayout(null);
        columnpanel.add(blog);

        JLabel title = new JLabel(user.getName());
        title.setOpaque(false);
        title.setBounds(180, 50, 620, 50);
        title.setFont(fontTitle);
        title.setForeground(Blanco);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(title);
        
        fontComment = new Font("Dubai", Font.BOLD, 14);
        
        JLabel userName = new JLabel(user.getUsername());
        userName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userName.setOpaque(false);
        userName.setFont(fontComment);
        userName.setForeground(amarillo);
        userName.setBounds(180, 80, 620, 50);
        userName.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(userName);
        JLabel street = new JLabel(user.getDireccion().getStreet());
        street.setOpaque(false);
        street.setBounds(100, 210, 200, 30);
        street.setFont(fontComment);
        street.setForeground(Blanco);
        street.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(street);
        JLabel suite = new JLabel(user.getDireccion().getSuite());
        suite.setOpaque(false);
        suite.setBounds(100, 265, 200, 30);
        suite.setFont(fontComment);
        suite.setForeground(Blanco);
        suite.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(suite);
        JLabel zip = new JLabel(user.getDireccion().getZipcode());
        zip.setOpaque(false);
        zip.setBounds(100, 325, 200, 30);
        zip.setFont(fontComment);
        zip.setForeground(Blanco);
        zip.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(zip);
        JLabel city = new JLabel(user.getDireccion().getCity());
        city.setOpaque(false);
        city.setBounds(100, 375, 200, 30);
        city.setFont(fontComment);
        city.setForeground(Blanco);
        city.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(city);
        JLabel lat = new JLabel(user.getDireccion().getGeo().getLatitud());
        lat.setOpaque(false);
        lat.setBounds(100, 470, 200, 30);
        lat.setFont(fontComment);
        lat.setForeground(Blanco);
        lat.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(lat);
        JLabel lng = new JLabel(user.getDireccion().getGeo().getLongitud());
        lng.setOpaque(false);
        lng.setBounds(100, 515, 200, 30);
        lng.setFont(fontComment);
        lng.setForeground(Blanco);
        lng.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(lng);
        JLabel numCome = new JLabel(String.valueOf(user.totalCommentSize()));
        numCome.setOpaque(false);
        numCome.setBounds(400, 105, 620, 50);
        numCome.setFont(fontComment);
        numCome.setForeground(Blanco);
        numCome.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(numCome);
        JLabel numPost = new JLabel(String.valueOf(user.postSize()));
        numPost.setOpaque(false);
        numPost.setBounds(210, 105, 620, 50);
        numPost.setFont(fontComment);
        numPost.setForeground(Blanco);
        numPost.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(numPost);
        //Posts
        JScrollPane commentPane = new JScrollPane();
        commentPane.setBackground(amarillo);
        blog.add(commentPane);
        commentPane.setBounds(427, 57, 470, 538);
        commentPane.getViewport().setBackground(new Color(0, 0, 0, 0));
        commentPane.setBorder(null);
        JLabel phone = new JLabel(user.getPhone());
        phone.setOpaque(false);
        phone.setBounds(250, 180, 200, 30);
        phone.setFont(fontComment);
        phone.setForeground(Blanco);
        phone.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(phone);
        JLabel web = new JLabel(user.getWebsite());
        web.setOpaque(false);
        web.setBounds(250, 240, 200, 30);
        web.setFont(fontComment);
        web.setForeground(Blanco);
        web.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(web);
        JLabel id = new JLabel(String.valueOf(user.getId()));
        id.setOpaque(false);
        id.setBounds(250, 290, 200, 30);
        id.setFont(fontComment);
        id.setForeground(Blanco);
        id.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(id);
        JLabel compaName = new JLabel(user.getCompany().getName());
        compaName.setOpaque(false);
        compaName.setBounds(250, 350, 200, 30);
        compaName.setFont(fontComment);
        compaName.setForeground(Blanco);
        compaName.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(compaName);
        JTextArea cf = new JTextArea();
        cf.setText(user.getCompany().getCatchPhrase());
        cf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cf.setOpaque(false);
        cf.setLineWrap(true);
        cf.setBorder(null);
        cf.setEditable(false);
        cf.setBackground(new Color(0, 0, 0, 0));
        cf.setForeground(Blanco);
        cf.setFont(fontComment);
        cf.setBounds(240, 410, 184, 60);
        blog.add(cf);
        JLabel bs = new JLabel(user.getCompany().getBs());
        bs.setOpaque(false);
        bs.setBounds(240, 500, 184, 30);
        bs.setFont(fontComment);
        bs.setForeground(Blanco);
        bs.setHorizontalTextPosition(SwingConstants.CENTER);
        blog.add(bs);
        JPanel column = new JPanel();
        commentPane.setViewportView(column);
        column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
        column.setBackground(amarillo);

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
        tutorial = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atras.setBorder(null);
        atras.setBorderPainted(false);
        atras.setContentAreaFilled(false);
        atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        getContentPane().add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

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
        getContentPane().add(buscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 70, 50));

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

        browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscarPublicacion.png"))); // NOI18N
        browse.setBorderPainted(false);
        browse.setContentAreaFilled(false);
        browse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        getContentPane().add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 80, 60));

        browseField.setBackground(new java.awt.Color(112, 120, 142));
        browseField.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        browseField.setForeground(new java.awt.Color(251, 255, 241));
        browseField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        browseField.setBorder(null);
        browseField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseFieldActionPerformed(evt);
            }
        });
        getContentPane().add(browseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 790, 40));

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
        getContentPane().add(tutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 70, 70));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondoFeed.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        browseField.setVisible(false);
        browse.setVisible(false);
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
        } else {
            JOptionPane.showMessageDialog(null, "Solo se puede hacer otro tipo de búsqueda desde el blog principal");
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
        } else {
            JOptionPane.showMessageDialog(null, "Solo se puede hacer otro tipo de búsqueda desde el blog principal");
        }
    }//GEN-LAST:event_buscarPostsActionPerformed

    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        tutor.setVisible(true);
        tutor.run();
        this.setVisible(false);
    }//GEN-LAST:event_tutorialActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        onlyVisible();
        scrollPaneBuscador.setVisible(false);
        scrollPaneBuscador = new JScrollPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        actualScrollPane = scrollPaneBuscador;
        scrollPaneBuscador.setBounds(50, 57, 900, this.getHeight() - 45);
        scrollPaneBuscador.setVisible(true);
        getContentPane().add(scrollPaneBuscador);

        JPanel borderlaoutpanel = new JPanel();
        scrollPaneBuscador.setViewportView(borderlaoutpanel);
        borderlaoutpanel.setLayout(new GridLayout(0, 1, 0, 1));

        JPanel columnpanel = new JPanel();
        borderlaoutpanel.add(columnpanel);
        columnpanel.setLayout(new BoxLayout(columnpanel, BoxLayout.Y_AXIS));
        columnpanel.setBackground(amarillo);

        if (buscandoU) {
            Lista encontrados = a.encontrarUsuarios(browseField.getText());
            if (encontrados.getData() != null) {
                while (encontrados != null) {
                    try {
                        createPostUser(columnpanel, encontrados);
                    } catch (IOException ex) {
                        Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    encontrados = encontrados.getLink();
                }
            } else {
                try {
                    ImagePanel notFound = new ImagePanel(ImageIO.read(getClass().getResource("/Images/noEncontrado.png")),20, 0);
                    notFound.setPreferredSize(new Dimension(800, 400));
                    notFound.setOpaque(false);
                    columnpanel.add(notFound);
                } catch (IOException ex) {
                    Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
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
            } else {
                try {
                    ImagePanel notFound = new ImagePanel(ImageIO.read(getClass().getResource("/Images/noEncontrado.png")),20,0);
                    notFound.setPreferredSize(new Dimension(800, 400));
                    notFound.setOpaque(false);
                    columnpanel.add(notFound);
                } catch (IOException ex) {
                    Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_browseActionPerformed

    private void browseFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_browseFieldActionPerformed

    

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

    private void createPostUser(JPanel columnpanel, Lista encontrado) throws IOException {
        ImagePanel rowPanel = new ImagePanel(ImageIO.read(getClass().getResource("/Images/postUser.png")));
        rowPanel.setPreferredSize(new Dimension(800, 400));
        rowPanel.setOpaque(false);
        columnpanel.add(rowPanel);
        Usuario user = (Usuario) encontrado.getData();
        rowPanel.setLayout(null);

        //Title button
        JButton userName = new JButton(user.getUsername());
        userName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userName.setBorderPainted(false);
        userName.setContentAreaFilled(false);
        userName.setFocusPainted(false);
        userName.setOpaque(false);
        userName.setForeground(azul);
        Font fontTitle = new Font("Dubai", Font.BOLD, 15);
        userName.setFont(fontTitle);
        userName.setBounds(150, 40, 640, 50);
        userName.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(userName);

        Font fontTe = new Font("Dubai", Font.BOLD, 12);
        JLabel name = new JLabel(user.getName());
        name.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        name.setOpaque(false);
        name.setForeground(azul);
        name.setFont(fontTe);
        name.setBounds(135, 90, 620, 110);
        name.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(name);

        fontTe = new Font("Dubai", Font.BOLD, 16);
        JLabel Id = new JLabel(String.valueOf(user.getId()));
        Id.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Id.setOpaque(false);
        Id.setForeground(azul);
        Id.setFont(fontTe);
        Id.setBounds(135, 145, 620, 110);
        Id.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(Id);

        JLabel phone = new JLabel(user.getPhone());
        phone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        phone.setOpaque(false);
        phone.setForeground(azul);
        fontTe = new Font("Dubai", Font.BOLD, 12);
        phone.setFont(fontTe);
        phone.setBounds(135, 195, 620, 110);
        phone.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(phone);

        fontTe = new Font("Dubai", Font.BOLD, 10);
        JLabel email = new JLabel(user.getEmail());
        email.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        email.setOpaque(false);
        email.setForeground(azul);
        email.setFont(fontTe);
        email.setBounds(135, 245, 620, 110);
        email.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(email);

        fontTe = new Font("Dubai", Font.BOLD, 16);
        JLabel zipcode = new JLabel(user.getDireccion().getZipcode());
        zipcode.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        zipcode.setOpaque(false);
        zipcode.setForeground(azul);
        zipcode.setFont(fontTe);
        zipcode.setBounds(135, 305, 620, 110);
        zipcode.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(zipcode);

        JTextArea bs = new JTextArea();
        bs.setText(user.getCompany().getBs());
        bs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bs.setOpaque(false);
        bs.setForeground(Blanco);
        bs.setFont(fontTe);
        bs.setEditable(false);
        bs.setBackground(new Color(0, 0, 0, 0));
        bs.setBorder(null);
        bs.setLineWrap(true);
        bs.setBounds(280, 300, 220, 60);
        rowPanel.add(bs);

        JTextArea cf = new JTextArea();
        cf.setText(user.getCompany().getCatchPhrase());
        cf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cf.setOpaque(false);
        cf.setLineWrap(true);
        cf.setBorder(null);
        cf.setEditable(false);
        cf.setBackground(new Color(0, 0, 0, 0));
        cf.setForeground(Blanco);
        cf.setFont(fontTe);
        cf.setBounds(280, 215, 220, 60);
        rowPanel.add(cf);

        JLabel nameC = new JLabel(user.getCompany().getName());
        nameC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nameC.setOpaque(false);
        nameC.setForeground(Blanco);
        nameC.setFont(fontTe);
        nameC.setBounds(300, 115, 620, 110);
        nameC.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(nameC);

        JLabel city = new JLabel(user.getDireccion().getCity());
        city.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        city.setOpaque(false);
        city.setForeground(Blanco);
        city.setFont(fontTe);
        city.setBounds(550, 100, 620, 110);
        city.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(city);

        JLabel lng = new JLabel(user.getDireccion().getGeo().getLongitud());
        lng.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lng.setOpaque(false);
        lng.setForeground(Blanco);
        lng.setFont(fontTe);
        lng.setBounds(574, 183, 620, 110);
        lng.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(lng);

        JLabel lat = new JLabel(user.getDireccion().getGeo().getLatitud());
        lat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lat.setOpaque(false);
        lat.setForeground(Blanco);
        lat.setFont(fontTe);
        lat.setBounds(570, 279, 620, 110);
        lat.setHorizontalTextPosition(SwingConstants.CENTER);
        rowPanel.add(lat);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    browseField.setVisible(false);
                    browse.setVisible(false);
                    actualScrollPane.setVisible(false);
                    createUserPage(user);

                } catch (IOException ex) {
                    Logger.getLogger(Blog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        userName.addActionListener(al);
    }

}
