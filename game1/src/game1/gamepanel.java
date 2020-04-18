package game1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class gamepanel extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	private static final int width = 500, height = 500;
	private Thread thread;
	private boolean running;
	private ArrayList<bodypart> snake;
	private int xCoor = 10;
	private int yCoor = 10;
	private int size = 15, ticks;
	private boolean right = true, left = false, up = false, down = false;
	private Apple apple;
	private ArrayList<Apple> apples;
	private Random r;
	// private int xCoor=10,yCoor=10,size=15;

	gamepanel() {
		setFocusable(true);
		// setPreferredSize(new Dimension(width, height));

		setPreferredSize(new Dimension(width, height));
		addKeyListener(this);
		snake = new ArrayList<bodypart>();
		apples = new ArrayList<Apple>();
		r = new Random();

		start();
	}

	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private bodypart b;

	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tick() {
		if (snake.size() == 0) {
			b = new bodypart(xCoor, yCoor, 10);
			snake.add(b);
		}
		ticks++;
		if (ticks > 2500000) {
			if (right)
				xCoor++;
			if (left)
				xCoor--;
			if (up)
				yCoor--;
			if (down)
				yCoor++;

			ticks = 0;
			b = new bodypart(xCoor, yCoor, 10);
			snake.add(b);

			if (snake.size() > size) {
				snake.remove(0);
			}
		}
		if (apples.size() == 0) {
			int xCoor = r.nextInt(49);
			int yCoor = r.nextInt(49);
			apple = new Apple(xCoor, yCoor, 10);
			apples.add(apple);
		}

		for (int i = 0; i < apples.size(); i++) {
			if ((xCoor == apples.get(i).getxCoor()) && (yCoor == apples.get(i).getyCoor())) {
				size++;
				apples.remove(i);
				i++;
			}
		}
		
		for (int i = 0; i <snake.size(); i++) {
			if ((xCoor == snake.get(i).getxCoor()) && (yCoor == snake.get(i).getyCoor())) {
				size++;
				apples.remove(i);
				i++;
			}
		}

		if (xCoor < 0 || xCoor > 49 || yCoor < 0 || yCoor > 49) {
			System.out.print("game ovcer");
			stop();
		}

	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, width, height);
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		for (int i = 0; i < width / 10; i++) {
			g.drawLine(i * 10, 0, i * 10, height);
		}
		for (int i = 0; i < height / 10; i++) {
			g.drawLine(0, i * 10, height, i * 10);
		}
		for (int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		for (int i = 0; i < apples.size(); i++) {
			apples.get(i).draw(g);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (running) {
			tick();
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT && !left) {
			right = true;
			up = false;
			down = false;
		}
		if (key == KeyEvent.VK_LEFT && !right) {
			up = false;
			left = true;
			right = false;
		}
		if (key == KeyEvent.VK_UP && !down) {
			left = false;
			up = true;
			right = false;
		}
		if (key == KeyEvent.VK_DOWN && !up) {
			down = true;
			left = false;
			right = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
