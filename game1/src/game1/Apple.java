package game1;


import java.awt.Color;
import java.awt.Graphics;

public class Apple {
	private int xCoor, yCoor, width, height;

	public Apple(int xCoor,int yCoor,int tileSize){
		this.xCoor=xCoor;
		this.yCoor=yCoor;
		width=tileSize;
		height=tileSize;
	}
	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}

	
	
	public void tick() {
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(xCoor*width, yCoor*height, width, height);
	}
	public int getxCoor() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

