package com.wsoft.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JDesktopPane;

public class ImagePanel extends JDesktopPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Image image;
	private int width;
	private int height;
	
    public ImagePanel(Image image, int width, int height) {
        super();
        this.image = image;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (int) (getWidth() / 2 - height/2);
	    int y = (int) (getHeight() / 2 - width/2);
        g.drawImage(this.image, x, y, width, height, this);
    }
}
