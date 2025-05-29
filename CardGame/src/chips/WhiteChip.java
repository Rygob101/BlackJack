package chips;

import java.io.IOException;

import javax.imageio.ImageIO;

public class WhiteChip extends SuperChip{

	public WhiteChip() {
		value = 1;
		x = 770;
		y = 310;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/chips/WhiteChip.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		scale = 2;
		width = 20 * scale;
		height = 20 * scale;
	}
}
