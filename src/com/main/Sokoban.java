package com.main;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Panel;
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
	
	public Sokoban() {
		
		createUI();
		
	}
	
	private void createUI() {
		
	
		SokobanGame game = new SokobanGame();
		game.loadMap("level1");
		map = game.getMap();
		
		add(map);
	
		setTitle("Sokoban - Menu");
		setSize(400+OFFSET,400+OFFSET);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setVisible(true);

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			Sokoban sokoban = new Sokoban();
			
		});
		
		
		
	}

}
