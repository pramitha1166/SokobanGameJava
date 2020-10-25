package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Map extends JPanel {

    private final int OFFSET = 40;
    private final int SPACE = 30;
    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;

    private ArrayList<Wall> walls;
    private ArrayList<Crate> crates;
    private ArrayList<Diamond> diamonds;
    
    private WareHouseKeeper soko;
    private int w = 0;
    private int h = 0;
    
    private int numMove = 0;
    
    private boolean isCompleted = false;

    private String level = "";

    public Map(String level) {

    	this.level = level;
        initMap();
    }

    private void initMap() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        initWorld();
    }

    public int getMapdWidth() {
        return this.w;
    }

    public int getMapHeight() {
        return this.h;
    }

    private void initWorld() {
        
        walls = new ArrayList<>();
        crates = new ArrayList<>();
        diamonds = new ArrayList<>();

        int x = OFFSET;
        int y = OFFSET;

        Wall wall;
        Crate crate;
        Diamond diamond;

        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            switch (item) {

                case '\n':
                    y += SPACE;

                    if (this.w < x) {
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
                    break;

                case '@':
                    soko = new WareHouseKeeper(x, y);
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

        g.setColor(Color.CYAN);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        
   
        
        
        
        ArrayList<MapElement> world = new ArrayList<>();

        world.addAll(walls);
        world.addAll(diamonds);
        world.addAll(crates);
        world.add(soko);

        for (int i = 0; i < world.size(); i++) {

            MapElement item = world.get(i);

            if (item instanceof WareHouseKeeper || item instanceof Crate) {
                
                g.drawImage(item.getImage(), item.x() + 2, item.y() + 2,30,30, this);
            } else {
                
                g.drawImage(item.getImage(), item.x(), item.y(),30,30, this);
            }

            if (isCompleted) {
                
                g.setColor(new Color(0, 0, 0));
                g.drawString("Completed", 25, 20);
                g.drawString(String.valueOf(numMove), 100, 20);
            }

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        buildWorld(g);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (isCompleted) {
                return;
            }

            int key = e.getKeyCode();

            switch (key) {
                
                case KeyEvent.VK_LEFT:
                    
                    if (checkWallCollision(soko,
                            LEFT_COLLISION)) {
                        return;
                    }
                    
                    if (checkCrateCollision(LEFT_COLLISION)) {
                        return;
                    }
                    
                    numMove++;
                    soko.move(-SPACE, 0);
                    
                    break;
                    
                case KeyEvent.VK_RIGHT:
                    
                    if (checkWallCollision(soko, RIGHT_COLLISION)) {
                        return;
                    }
                    
                    if (checkCrateCollision(RIGHT_COLLISION)) {
                        return;
                    }
                    
                    numMove++;
                    soko.move(SPACE, 0);
                    
                    break;
                    
                case KeyEvent.VK_UP:
                    
                    if (checkWallCollision(soko, TOP_COLLISION)) {
                        return;
                    }
                    
                    if (checkCrateCollision(TOP_COLLISION)) {
                        return;
                    }
                    
                    numMove++;
                    soko.move(0, -SPACE);
                    
                    break;
                    
                case KeyEvent.VK_DOWN:
                    
                    if (checkWallCollision(soko, BOTTOM_COLLISION)) {
                        return;
                    }
                    
                    if (checkCrateCollision(BOTTOM_COLLISION)) {
                        return;
                    }
                    
                    numMove++;
                    soko.move(0, SPACE);
                    
                    break;
                    
                case KeyEvent.VK_R:
                    
                    restartLevel();
                    
                    break;
                    
                default:
                    break;
            }

            repaint();
        }
    }

    private boolean checkWallCollision(MapElement actor, int type) {

        switch (type) {
            
            case LEFT_COLLISION:
                
                for (int i = 0; i < walls.size(); i++) {
                    
                    Wall wall = walls.get(i);
                    
                    if (actor.isLeftCollision(wall)) {
                        
                        return true;
                    }
                }
                
                return false;
                
            case RIGHT_COLLISION:
                
                for (int i = 0; i < walls.size(); i++) {
                    
                    Wall wall = walls.get(i);
                    
                    if (actor.isRightCollision(wall)) {
                        return true;
                    }
                }
                
                return false;
                
            case TOP_COLLISION:
                
                for (int i = 0; i < walls.size(); i++) {
                    
                    Wall wall = walls.get(i);
                    
                    if (actor.isTopCollision(wall)) {
                        
                        return true;
                    }
                }
                
                return false;
                
            case BOTTOM_COLLISION:
                
                for (int i = 0; i < walls.size(); i++) {
                    
                    Wall wall = walls.get(i);
                    
                    if (actor.isBottomCollision(wall)) {
                        
                        return true;
                    }
                }
                
                return false;
                
            default:
                break;
        }
        
        return false;
    }

    private boolean checkCrateCollision(int type) {

        switch (type) {
            
            case LEFT_COLLISION:
                
                for (int i = 0; i < crates.size(); i++) {

                    Crate crate = crates.get(i);

                    if (soko.isLeftCollision(crate)) {

                        for (int j = 0; j < crates.size(); j++) {
                            
                            Crate item = crates.get(j);
                            
                            if (!crate.equals(item)) {
                                
                                if (crate.isLeftCollision(item)) {
                                    return true;
                                }
                            }
                            
                            if (checkWallCollision(crate, LEFT_COLLISION)) {
                                return true;
                            }
                        }
                        
                        crate.move(-SPACE, 0);
                        isCompleted();
                    }
                }
                
                return false;
                
            case RIGHT_COLLISION:
                
                for (int i = 0; i < crates.size(); i++) {

                    Crate bag = crates.get(i);
                    
                    if (soko.isRightCollision(bag)) {
                        
                        for (int j = 0; j < crates.size(); j++) {

                            Crate item = crates.get(j);
                            
                            if (!bag.equals(item)) {
                                
                                if (bag.isRightCollision(item)) {
                                    return true;
                                }
                            }
                            
                            if (checkWallCollision(bag, RIGHT_COLLISION)) {
                                return true;
                            }
                        }
                        
                        bag.move(SPACE, 0);
                        isCompleted();
                    }
                }
                return false;
                
            case TOP_COLLISION:
                
                for (int i = 0; i < crates.size(); i++) {

                    Crate bag = crates.get(i);
                    
                    if (soko.isTopCollision(bag)) {
                        
                        for (int j = 0; j < crates.size(); j++) {

                            Crate item = crates.get(j);

                            if (!bag.equals(item)) {
                                
                                if (bag.isTopCollision(item)) {
                                    return true;
                                }
                            }
                            
                            if (checkWallCollision(bag, TOP_COLLISION)) {
                                return true;
                            }
                        }
                        
                        bag.move(0, -SPACE);
                        isCompleted();
                    }
                }

                return false;
                
            case BOTTOM_COLLISION:
                
                for (int i = 0; i < crates.size(); i++) {

                    Crate bag = crates.get(i);
                    
                    if (soko.isBottomCollision(bag)) {
                        
                        for (int j = 0; j < crates.size(); j++) {

                            Crate item = crates.get(j);
                            
                            if (!bag.equals(item)) {
                                
                                if (bag.isBottomCollision(item)) {
                                    return true;
                                }
                            }
                            
                            if (checkWallCollision(bag,BOTTOM_COLLISION)) {
                                
                                return true;
                            }
                        }
                        
                        bag.move(0, SPACE);
                        isCompleted();
                    }
                }
                
                break;
                
            default:
                break;
        }

        return false;
    }

    public void isCompleted() {

        int nOfCrates = crates.size();
        int finishedCrates = 0;

        for (int i = 0; i < nOfCrates; i++) {
            
            Crate crate = crates.get(i);
            
            for (int j = 0; j < nOfCrates; j++) {
                
                Diamond diamond =  diamonds.get(j);
                
                if (crate.x() == diamond.x() && crate.y() == diamond.y()) {
                    
                	finishedCrates += 1;
                }
            }
        }

        if (finishedCrates == nOfCrates) {
            
            isCompleted = true;
            repaint();
        }
    }

    private void restartLevel() {

    	diamonds.clear();
        crates.clear();
        walls.clear();

        initWorld();

        if (isCompleted) {
            isCompleted = false;
        }
    }
}
