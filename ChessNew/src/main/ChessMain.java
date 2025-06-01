package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ChessMain {


	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Chess");

		GameScreen gs = new GameScreen();
		window.add(gs);
		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}
}