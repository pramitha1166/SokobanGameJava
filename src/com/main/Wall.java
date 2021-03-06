package com.main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall extends MapElement {

	private Image image;
	
	public Wall(int x, int y) {
		super(x,y);
		createWall();
	}
	
	private void createWall() {
		ImageIcon icon = new ImageIcon("src/resources/wall.png");
		image = icon.getImage();
		setImage(image);
	}
	
}
