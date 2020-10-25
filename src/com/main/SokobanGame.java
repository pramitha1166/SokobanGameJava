package com.main;

public class SokobanGame {
	
	String level ="";
	
	public SokobanGame() {
		
	}
	/*# - wall, $ - crate, . = diamond, @ = keeper*/

	public void loadMap(int mapId) {
		
		switch(mapId) {
			case 1:
				level
				="##########\n"
				+"#      # #\n"
			    +"#    @   #\n"
			    +"# $$#   .#\n"
			    +"#   #   .#\n"
			    +"##########\n";
				//myMap = new Map(level);
				break;
			case 2:
				level
				="##########\n"
				+"#      ###\n"
				+"#      ###\n"
			    +"#   #@   #\n"
			    +"# $$#   .#\n"
			    +"#   #   .#\n"
			    +"##########\n";
				//myMap = new Map(level);
				break;
			case 3:
				level
				="#########\n"
			    +"### $ ..#\n"
			    +"#   $   #\n"
			    +"### @ $.#\n"
			    +"#   $####\n"
			    +"#.     ##\n"
			    +"#       #\n"
			    +"#########\n";
				//myMap = new Map(level);
				break;
			case 4:
				level
				="##########\n"
			    +"#..  $  ##\n"
			    +"##   $  ##\n"
			    +"###  @  .#\n"
			    +"##   $ $ #\n"
			    +"#####.   #\n"
			    +"##########\n";
				//myMap = new Map(level);
				break;
			case 5:
				level
				="##########\n"
			    +"#....    #\n"
			    +"#####$ ###\n"
			    +"### $ @  #\n"
			    +"#        #\n"
			    +"# $$     #\n"
			    +"#        #\n"
			    +"##########\n";
				//myMap = new Map(level);
				break;
				
			default:
				break;	
		}
		
	}
	
	public String getMap() {
		return level;
	}

	
}
