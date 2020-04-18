package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class bodypart {
	private int xCoor,yCoor,width,height;
	
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
	
	public bodypart(int xCoor,int yCoor,int tileSize) {
		this.xCoor=xCoor;
		this.yCoor=yCoor;
		width=tileSize;
		height=tileSize;
		
	}
	
	public void trick() {}
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(xCoor*width, yCoor*height, width, height);
	}
}
