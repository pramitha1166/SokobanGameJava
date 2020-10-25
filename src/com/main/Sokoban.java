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

	
	public Sokoban() {
		
		createUI();
		
	}
	

	private void createUI() {
		
		Map map = new Map();

		add(map);
		setLocationRelativeTo(null);
         
        setTitle("Sokoban");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        
		
		
	}

	
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			Sokoban sokoban = new Sokoban();
			
		});
		
		
		
	}
	


}


