package com.main;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Sokoban extends JFrame {

	private static final long serialVersionUID = 1L;


	static Sokoban sokoban;
	
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
			sokoban = new Sokoban();
			
		});
		
		
		
	}
	


}


