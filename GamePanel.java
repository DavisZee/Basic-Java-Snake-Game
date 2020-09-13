import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
/*
 * @author Davis Zhong
 * Version: 8/27/2020
 * Description: 
 * 
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1000, HEIGHT = 1000;//was 500
	
	private Thread thread;
	
	private boolean running;
	
	private boolean right = true, left = false, up = false, down = false;
	
	private BodyPart b;
	private ArrayList<BodyPart> snake;
	
	private Bait snakeBait;
	private ArrayList<Bait> baitJar;
	
	private Random r;
	
	private int xCoor = 10, yCoor = 10, size = 10;
	
	private int ticks = 0;
	
	private int score = 0;	
	/*
	 * constructor sets preferred size of window, creates the array list of snake and starts program
	 */
	public GamePanel() {
		setFocusable(true);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);
		snake = new ArrayList<BodyPart>();
		
		baitJar = new ArrayList<Bait>();
		
		r = new Random();
		starting();
	}
	
	/*
	 * starts program and creates thread that runs with start()
	 */
	public void starting() {
		running = true;
		thread = new Thread(this);
		thread.start();	//this start() begins multithreading and is different from our start
		//the start also calls my run method
	}
	
	/*
	 * Ends the while loop in run() and 
	 */
	public void stop() {
		running = false;
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		if(snake.size() == 0) {
			b = new BodyPart(xCoor, yCoor, 10);
			snake.add(b);
		}
		ticks++;
		//System.out.println(ticks);
		if(ticks > 800000) {//initial value 250000 these values control time/speed
			if(right) xCoor++;
			if(left) xCoor--;
			if(up) yCoor--;
			if(down) yCoor++;
			
			ticks = 0;
			
			b = new BodyPart(xCoor, yCoor, 10);
			snake.add(b);
			
			//this if statement ensures that the back end of the snake is removed each tick so snake doesn't stretch
			if(snake.size() > size) {
				snake.remove(0);				
			}
		}
		//determines location of bait generated in game
		if(baitJar.size() == 0) {
			int xCoor = r.nextInt(99);
			int yCoor = r.nextInt(99);
			
			snakeBait = new Bait(xCoor, yCoor, 10);
			baitJar.add(snakeBait);
		}
		
		//what game does after snake collides with bait
		for(int i = 0; i < baitJar.size(); i++) {
			if(xCoor == baitJar.get(i).getxCoor() && yCoor == baitJar.get(i).getyCoor()) {
				baitJar.remove(i);
				score++;
				System.out.println("Score: " + score);
				size += 5;
				i++;
			}
		}
		//snake bit itself
		for (int i = 0; i < snake.size(); i++) {
			if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) {
				if(i != snake.size() - 1) {
					System.out.println("Game Over");//game over execute and ends program
					stop();
				}
			}
		}
		//contact with border of game
		if(xCoor < 0 || xCoor > 99 || yCoor < 0 || yCoor > 99) {
			System.out.println("Game Over");
			stop();
		}
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		for(int i = 0; i < WIDTH / 10; i++) {
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
		
		for(int i = 0; i < HEIGHT / 10; i++) {
			g.drawLine(0, 1 * 10, HEIGHT, i * 10);
		}
		
		for(int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);			
		}
		
		for(int i = 0; i < baitJar.size(); i++) {
			baitJar.get(i).draw(g);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT && !left) {
			right = true;
			up = false;
			down = false;
		}
		
		if(key == KeyEvent.VK_LEFT && !right) {
			left = true;
			up = false;
			down = false;
		}
		
		if(key == KeyEvent.VK_UP && !down) {
			up = true;
			left = false;
			right = false;
		}
		
		if(key == KeyEvent.VK_DOWN && !up) {
			down = true;
			left = false;
			right = false;
		}
		
		//if(key == KeyEvent.VK_A) {
			//System.out.println("OOPS");
		//}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * The run method that starts the game thread loops through 
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(running) {
			tick();
			repaint();
		}
	}
	
	

}
