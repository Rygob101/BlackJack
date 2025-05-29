package chips;

import java.io.IOException;

import javax.imageio.ImageIO;

public class RedChip extends SuperChip{

	public RedChip() {
		value = 5;
		x = 770;
		y = 380;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/chips/RedChip.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		scale = 2;
		width = 20 * scale;
		height = 20 * scale;
	}
}