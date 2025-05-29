package chips;

import java.io.IOException;

import javax.imageio.ImageIO;

public class GreenChip extends SuperChip{

	public GreenChip() {
		value = 10;
		x = 770;
		y = 450;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/chips/GreenChip.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		scale = 2;
		width = 20 * scale;
		height = 20 * scale;
	}
}
