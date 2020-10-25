package com.main;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sokoban extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int OFFSET = 30;
	
	
	private Map map;
	private JFrame gameFrame;
	private JFrame menuFrame;

	
	private JButton lvl1Button;
	private JButton lvl2Button;
	private JButton lvl3Button;
	private JButton lvl4Button;
	private JButton lvl5Button;
	
	
	SokobanGame game;
	
	public Sokoban() {
		
		createUI();
		
	}
	
		
	
	
	public JFrame getGameFrame() {
		return gameFrame;
	}




	public void setGameFrame(JFrame gameFrame) {
		this.gameFrame = gameFrame;
	}




	public JFrame getMenuFrame() {
		return menuFrame;
	}




	public void setMenuFrame(JFrame menuFrame) {
		this.menuFrame = menuFrame;
	}




	private void createUI() {
		

		Font font = new Font( "Arial", Font.BOLD, 12);
		Font fontL = new Font( "Arial", Font.BOLD, 20);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(1, 1, 100, 300);
		panel1.setBackground(Color.CYAN);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(1, 1, 300, 300);
		
		JLabel label1 = new JLabel("Sokoban");
		label1.setFont(fontL);
		panel2.setBackground(Color.MAGENTA);
		panel2.add(label1);
		
		
		lvl1Button = new JButton("Level 01");
		lvl1Button.setFont(font);
	

		lvl2Button = new JButton("Level 02");
		lvl2Button.setFont(font);
		

		lvl3Button = new JButton("Level 03");
		lvl3Button.setFont(font);
		

		lvl4Button = new JButton("Level 04");
		lvl4Button.setFont(font);
		

		lvl5Button = new JButton("Level 05");
		lvl5Button.setFont(font);
	
		JLabel labelLevel = new JLabel("Levels");
		labelLevel.setFont(font);
		
		panel1.add(labelLevel);
        panel1.add(lvl1Button);
        panel1.add(lvl2Button);
        panel1.add(lvl3Button);
        panel1.add(lvl4Button);
        panel1.add(lvl5Button);

        add(panel1);
        add(panel2);

        ButtonHandler handler = new ButtonHandler();  
        lvl1Button.addActionListener(handler);          
        lvl2Button.addActionListener(handler);          
        lvl3Button.addActionListener(handler);          
        lvl4Button.addActionListener(handler);       

        setLocationRelativeTo(null);
         
        setTitle("Sokoban - Menu");
        setSize(400, 300);
        setResizable(false);
        setVisible(true);
        
		
		
	}

	
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			Sokoban sokoban = new Sokoban();
			
		});
		
		
		
	}
	

	private class ButtonHandler implements ActionListener {
		
		JFrame level1Frame;
		
		
		
		 public void actionPerformed(ActionEvent e) {
             if (e.getSource() == lvl1Button) {
                     
            	 	level1Frame = new JFrame();
            	 	
            	 	
            		game = new SokobanGame();
            		game.loadMap("level1");
            		map = game.getMap();
            		level1Frame.add(map);
            		level1Frame.setTitle("Sokoban - Level1");
            		level1Frame.setSize(map.getMapdWidth() +OFFSET,map.getMapHeight() + 2*OFFSET);

            		level1Frame.setLocationRelativeTo(null);
            		
            		level1Frame.setVisible(true);
            		

             }
             if (e.getSource() == lvl2Button) {
            		level1Frame = new JFrame();
            		
            		
            		game = new SokobanGame();
            		game.loadMap("level2");
            		map = game.getMap();
            		level1Frame.add(map);
            		level1Frame.setTitle("Sokoban - Level2");
            		level1Frame.setSize(map.getMapdWidth() +OFFSET,map.getMapHeight() + 2*OFFSET);

            		level1Frame.setLocationRelativeTo(null);
            		
            		level1Frame.setVisible(true);
             }
             if (e.getSource() == lvl3Button) {
         		level1Frame = new JFrame();
         		
         		
         		game = new SokobanGame();
         		game.loadMap("level3");
         		map = game.getMap();
         		level1Frame.add(map);
         		level1Frame.setTitle("Sokoban - Level3");
         		level1Frame.setSize(map.getMapdWidth() +OFFSET,map.getMapHeight() + 2*OFFSET);

         		level1Frame.setLocationRelativeTo(null);
         		
         		level1Frame.setVisible(true);
             }
             if (e.getSource() == lvl4Button) {
         		level1Frame = new JFrame();
         		
         		
         		game = new SokobanGame();
         		game.loadMap("level3");
         		map = game.getMap();
         		level1Frame.add(map);
         		level1Frame.setTitle("Sokoban - Level4");
         		level1Frame.setSize(map.getMapdWidth() +OFFSET,map.getMapHeight() + 2*OFFSET);

         		level1Frame.setLocationRelativeTo(null);
         		
         		level1Frame.setVisible(true);
             }
             if (e.getSource() == lvl5Button) {
          		level1Frame = new JFrame();
          		
          		
          		game = new SokobanGame();
          		game.loadMap("level3");
          		map = game.getMap();
          		level1Frame.add(map);
          		level1Frame.setTitle("Sokoban - Level5");
          		level1Frame.setSize(map.getMapdWidth() +OFFSET,map.getMapHeight() + 2*OFFSET);

          		level1Frame.setLocationRelativeTo(null);
          		
          		level1Frame.setVisible(true);
              }
		 }
	
	}

}


