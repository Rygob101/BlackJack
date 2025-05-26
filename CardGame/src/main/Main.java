package main;

import javax.swing.JFrame;

public class Main {

	
	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Card Game");
		
		GameScreen gs = new GameScreen();
		window.add(gs);
		window.pack();
		
		MouseInteract click = new MouseInteract(gs);
		window.addMouseListener(click);
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}
}
