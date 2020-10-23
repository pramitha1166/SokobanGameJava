package main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Crate extends MapElement {

	private Image image;
	
	public Crate(int x, int y) {
		super(x, y);
		createCrate();
	}
	
	private void createCrate() {
		ImageIcon icon = new ImageIcon("src/main/crate.png");
		image = icon.getImage();
		setImage(image);
	}
	
	public void move(int x, int y) {
		int dx = x() + x;
		int dy = y() + y;
		
		setX(dx);
		setY(dy);
		
	}
	
}
