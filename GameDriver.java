import javax.swing.JFrame;
/*
 * @author Davis Zhong
 * Version: 8/27/2020
 * Description: 
 * 
 */

public class GameDriver {
	
	private static GamePanel gamepanel = new GamePanel();
	//private static GameMenu menupanel;
	
	public static void game() {
		JFrame frame = new JFrame();
				
		frame.add(gamepanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SNAKEGAME");
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);		
	}
	
	//public static void menu() {
		//JFrame frame = new JFrame();
		
		//frame.add(menupanel);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setTitle("SNAKEGAME");
		//frame.pack();
		//frame.setVisible(true);
		//frame.setLocationRelativeTo(null);	
	//}

	public static void main(String[] args) {
		game();
	}
}
