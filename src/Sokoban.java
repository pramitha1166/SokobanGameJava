import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sokoban extends JFrame {
	
	private final int OFFSET = 300;
	
	public Sokoban() {
		
		
		JFrame f = new JFrame("Panel Example");
		
		JPanel panel = new JPanel();
		panel.setBounds(1,1,100,400);
		panel.setBackground(Color.gray);
		
		Map map1 = new Map();
		add(map1);
		
		JButton button1 = new JButton("Level 1");
		JButton button2 = new JButton("Level 2");
		JButton button3 = new JButton("Level 3");
		JButton button4 = new JButton("Level 4");
		JButton button5 = new JButton("Level 5");
		button1.setBounds(50, 100, 80, 30);
		button2.setBounds(100, 100, 80, 30);
		button3.setBounds(100, 100, 80, 30);
		button4.setBounds(100, 100, 80, 30);
		button5.setBounds(100, 100, 80, 30);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		
		/*setTitle("Sokoban");
		setSize(100+OFFSET , 100+OFFSET);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(button1);
		setLocationRelativeTo(null);*/
		
		
		
		f.add(panel);
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setLayout(null);
		f.setVisible(true);

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	EventQueue.invokeLater(() -> {
			Sokoban sokoban = new Sokoban();
			sokoban.setVisible(true);
			System.out.println("Hello");
		});*/
		
		new Sokoban();
	
		
	}

}
