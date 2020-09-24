/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_control;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * 
 */
public class ImagePanel extends JPanel{
    BufferedImage img;
    int width,height;
    int x,y;

    public ImagePanel(BufferedImage img) {
        this.img = img;
        width = img.getWidth();
        height = img.getHeight();
        x = 120;
        y = 30;
    }

    ImagePanel(BufferedImage img, int i, int i0) {
        this.img = img;
        width = img.getWidth();
        height = img.getHeight();
        x = i;
        y = i0;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img,x, y, this);
    }
    
    protected void setWidth(int i){
        this.width= i;
    }
}
