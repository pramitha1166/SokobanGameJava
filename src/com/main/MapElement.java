package com.main;

import java.awt.Image;

public class MapElement {

    private final int SPACE = 30;

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

    public void setImage(Image img) {
        image = img;
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

    public boolean isLeftCollision(MapElement actor) {
        
        return x() - SPACE == actor.x() && y() == actor.y();
    }

    public boolean isRightCollision(MapElement actor) {
        
        return x() + SPACE == actor.x() && y() == actor.y();
    }

    public boolean isTopCollision(MapElement actor) {
        
        return y() - SPACE == actor.y() && x() == actor.x();
    }

    public boolean isBottomCollision(MapElement actor) {
        
        return y() + SPACE == actor.y() && x() == actor.x();
    }
}
