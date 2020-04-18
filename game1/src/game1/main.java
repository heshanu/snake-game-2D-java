package game1;

import javax.swing.JFrame;

public class main {

	public main() {
		JFrame frame = new JFrame();
		gamepanel gamepanel1 = new gamepanel();

		frame.add(gamepanel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ffff");
		frame.setLocationRelativeTo(null);

		frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new main();
	}
}
