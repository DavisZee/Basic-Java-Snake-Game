import java.awt.Color;
import java.awt.Graphics;
/*
 * @author Davis Zhong
 * Version: 8/27/2020
 * Description: 
 * 
 */
public class Bait {
	private int xCoor, yCoor, width, height;
	
	public Bait(int xCoor, int yCoor, int tileSize) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		height = tileSize;
	}
	
	//public void tick() {
		
	//}
	
	public void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(xCoor * width, yCoor * height, width, height);
	}

	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
}