package com.main;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sokoban extends JFrame {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private final int OFFSET = 30;
	
	public Sokoban() {
		
		createUI();
		
	}
	
	private void createUI() {
		
		Map map1 = new Map();
		add(map1);
	
		setTitle("Sokoban");
		setSize(400+OFFSET,400+OFFSET);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(() -> {
			Sokoban sokoban = new Sokoban();
			sokoban.setVisible(true);
			//System.out.println("Hello");
		});
		
		
		
	}

}
