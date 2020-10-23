package main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Diamond extends MapElement {

	private Image image;
	
	public Diamond(int x, int y) {
		super(x, y);
		createDiamond();
	}
	
	private void createDiamond() {
		ImageIcon icon = new ImageIcon("src/main/diamond.png");
		image = icon.getImage();
		setImage(image);
	}
	
}
