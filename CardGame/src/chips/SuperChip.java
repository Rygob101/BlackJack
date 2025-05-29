package chips;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class SuperChip {
	int value;
	BufferedImage image;
	int width;
	int height;
	int x, y;
	int scale;
	public void draw(Graphics2D g2) {
		g2.drawImage(this.image, this.x, this.y, this.width, this.height, null);
	}
}
