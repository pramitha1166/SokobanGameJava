package com.main;

public class SokobanGame {

private Map myMap;
	
	String level ="";
	
	public SokobanGame() {
		
	}
	/*# - wall, $ - crate, . = diamond, @ = keeper*/

	public void loadMap(String mapName) {
		
		switch(mapName) {
			case "level1":
				level
				="##########\n"
				+"#      # #\n"
			    +"#    @   #\n"
			    +"# $$#   .#\n"
			    +"#   #   .#\n"
			    +"##########\n";
				myMap = new Map(level);
				break;
			case "level2":
				level
				="##########\n"
				+"#      ###\n"
			    +"#    @   #\n"
			    +"# $$#   .#\n"
			    +"#   #   .#\n"
			    +"##########\n";
				myMap = new Map(level);
				break;
			case "level3":
				level
				="##########\n"
			    +"#####.####\n"
			    +"#####$####\n"
			    +"###.$@$.##\n"
			    +"#####$####\n"
			    +"#####.####\n"
			    +"##########\n";
				myMap = new Map(level);
				break;
			default:
				break;	
		}
		
	}
	
	public Map getMap() {
		return myMap;
	}

	
}
