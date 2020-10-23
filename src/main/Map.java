package main;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Map extends JPanel {

	private final int OFFSET = 30;
	private final int SPACE = 20;
	private final int LEFT_COLLISION = 1;
	private final int RIGHT_COLLISION = 2;
	private final int TOP_COLLISION = 3;
	private final int BOTTOM_COLLISION = 4;
	
	
	private ArrayList<Wall> walls;
	
	
	public Map() {
		
	}
	
}
