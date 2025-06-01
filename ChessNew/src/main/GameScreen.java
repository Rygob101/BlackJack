package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import pieces.Pawn;
import pieces.Space;
import pieces.SuperPiece;



@SuppressWarnings("serial")
public class GameScreen extends JPanel{
	
	public final int screenWidth = 1000;
	public final int screenHeight = 600;
	public Space[][] board = new Space[8][8];
	public SuperPiece[] pieceTypes = new SuperPiece[7];
	BufferedImage bgImage = null;
	
	Graphics2D g2;
	
	public GameScreen(){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		try {
			bgImage = ImageIO.read(getClass().getResourceAsStream("/background/ChessBackground2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		loadBoard();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g2 = (Graphics2D)g;
		
		g2.drawImage(bgImage, 0, 0, null);
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(board[i][j] != null) {
					g2.drawImage(board[i][j].piece.image, board[i][j].x, board[i][j].y, null);
				}
			}
		}
	}
	
	public void loadPieces() {
		pieceTypes[0] = null;
		pieceTypes[1] = new Pawn();
	}
	
	public void loadBoard() {
		int xPos = 480;
		int yPos = 75;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i == 1) {
					board[i][j] = new Space(1, 1);
					board[i][j].x = xPos;
					board[i][j].y = yPos;
				}
				if(i == 6) {
					board[i][j] = new Space(1, 0);
					board[i][j].x = xPos;
					board[i][j].y = yPos;
				}
				xPos += 40;
				yPos += 20;
			}
			yPos -= 140;
			xPos -= 360;
		}
		
	}
}
