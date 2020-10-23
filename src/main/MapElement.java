package main;

import java.awt.Image;

public class MapElement {

	private final int SPACE = 20;
	
	private int x;
	private int y;
	private Image image;
	
	public MapElement(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}


	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isLeftCollision(MapElement element) {
		return x() - SPACE == element.x() && y() == element.y();
	}
	
	public boolean isRightCollision(MapElement element) {
		return x() + SPACE == element.x() && y() == element.y();
	}
	
	public boolean isTopCollision(MapElement element) {
		return x() == element.x() && y() - SPACE == element.y();
	}
	
	public boolean isBottumCollision(MapElement element) {
		return x() == element.x() && y() + SPACE == element.y();
	}
	
	
}
