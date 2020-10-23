package com.main;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Map extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int OFFSET = 30;
	private final int SPACE = 20;
	private final int LEFT_COLLISION = 1;
	private final int RIGHT_COLLISION = 2;
	private final int TOP_COLLISION = 3;
	private final int BOTTOM_COLLISION = 4;
	
	
	private ArrayList<Wall> walls;
	private ArrayList<Crate> crates;
	private ArrayList<Diamond> diamonds;
	
	private WareHouseKeeper keeper;
	private int w = 0;
	private int h = 0;
	
	/*# - wall, $ - crate, . = diamond, @ = keeper*/
	
	private String level
		= "    ######\n"
		+ "    ##   #\n"
		+ "    ##$  #\n"
		+ "  ####   $##\n"
		+ "  ##  $ $ #\n"
		+ "#### # ## #   ######\n"
		+ "##   # ## #####  ..#\n"
		+ "## $  $          ..#\n"
		+ "###### ### #@##  ..#\n"
		+ "    ##     #########\n"
		+ "    ########\n";
	
	public Map() {
		initMap();
	}
	
	
	
	private void initMap() {
		intGameWorld();
	}
	
	private void intGameWorld() {
		
		walls = new ArrayList<>();
		crates = new ArrayList<>();
		diamonds = new ArrayList<>();
		
		int x = OFFSET;
		int y = OFFSET;
		
		Wall wall;
		Crate crate;
		Diamond diamond;
		
		for (int i=0; i<level.length(); i++) {
			char item = level.charAt(i);
			
			switch (item) {
			
				case '\n':
					y += SPACE;
					
					if(this.w < x) {
						this.w = x;
					}
					
					x = OFFSET;
			
					break;
				case '#':
					wall = new Wall(x, y);
					walls.add(wall);
					x += SPACE;
					break;
				case '$':
					crate = new Crate(x, y);
					crates.add(crate);
					x += SPACE;
					break;
				case '.':
					diamond = new Diamond(x, y);
					diamonds.add(diamond);
					x += SPACE;
				case '@':
					keeper = new WareHouseKeeper(x, y);
					x += SPACE;
					break;
				case ' ':
					x += SPACE;
					break;
				default:
					break;
						
			}
			
			h = y;
			
		}
		
		
	}
	
	private void buildWorld(Graphics g) {
		
		g.setColor(new Color(250, 240, 170));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		ArrayList<MapElement> world = new ArrayList<>();
		
		world.addAll(crates);
		world.addAll(diamonds);
		world.addAll(walls);
		world.add(keeper);
		
		
		for (int i=0; i<world.size(); i++ ) {
			MapElement element = world.get(i);
			
			if(element instanceof WareHouseKeeper || element instanceof Crate) {
				g.drawImage(element.getImage(), element.x() + 2, element.y() + 2, this);
			} else {
				g.drawImage(element.getImage(), element.x() + 2, element.y(), this);
			}
			
		}
		
	}

	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		buildWorld(g);
	}
	
	
	
}
