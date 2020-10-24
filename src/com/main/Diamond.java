package com.main;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Diamond extends MapElement {

    public Diamond(int x, int y) {
        super(x, y);
        
        initArea();
    }
    
    private void initArea() {

        ImageIcon iicon = new ImageIcon("src/resources/diamond.png");
        Image image = iicon.getImage();
        setImage(image);
    }
}
