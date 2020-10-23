package main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall extends MapElement {

	private Image image;
	
	public Wall(int x, int y) {
		super(x,y);
		
	}
	
	public void createWall() {
		ImageIcon icon = new ImageIcon("src/main/wall.png");
		image = icon.getImage();
		setImage(image);
	}
	
}
