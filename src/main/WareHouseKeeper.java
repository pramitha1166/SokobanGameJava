package main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class WareHouseKeeper extends MapElement {

	private Image image;
	
	public WareHouseKeeper(int x, int y) {
		super(x, y);
		createWareHouseKeeper();
	}
	
	private void createWareHouseKeeper() {
		ImageIcon icon = new ImageIcon("src/main/keeper.png");
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
