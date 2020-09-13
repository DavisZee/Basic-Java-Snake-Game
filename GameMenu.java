import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * @author Davis Zhong
 * Version: 8/27/2020
 * Description: 
 * 
 */
public class GameMenu extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 900, HEIGHT = 900;
	JLabel welcomeMsg;
	JButton start;
	JButton size;
	
	public GameMenu() {
		setFocusable(true);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		welcomeMsg = new JLabel("Welcome to Davis' Snake Game!");
		start = new JButton("Start Game!");
		size = new JButton("Size");
		
		start.addActionListener(this);
		size.addActionListener(this);
		
		this.add(start);//remember to find out how to move buttons around on window
		this.add(size);
		this.add(welcomeMsg);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		//if(a.getSource().equals(start)) System.out.println("Starting");
		//if(a.getSource().equals(size)) System.out.println("size");
	}

}
