package pieces;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SuperPiece {
	public int num;
	public BufferedImage image;
	public int color;

	public void loadPieceImage(String piece) {
		if(color == 0) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/pieces/" + piece + ".png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else if(color == 1) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/pieces/" + piece + "Black" +".png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
