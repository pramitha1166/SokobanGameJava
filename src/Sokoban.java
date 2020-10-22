import javax.swing.JFrame;

public class Sokoban extends JFrame {
	
	private final int OFFSET = 300;
	
	public Sokoban() {
		
		Map map1 = new Map();
		add(map1);
		
		setTitle("Sokoban");
		setSize(100+OFFSET , 100+OFFSET);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sokoban sokoban = new Sokoban();
		sokoban.setVisible(true);
		System.out.println("Hello");
		
	}

}
